package ca.qc.johnabbott.finalproject.UI;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.viewpager.widget.ViewPager;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

import ca.qc.johnabbott.finalproject.R;
import ca.qc.johnabbott.finalproject.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private TextView combo, price;
    private Button close;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        int[] sampleImages = {R.drawable.pizza,R.drawable.pizza,R.drawable.pizza};
        binding.firstDealCardview.setVisibility(View.GONE);
        binding.textView2.setVisibility(View.GONE);

        binding.carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(sampleImages[position]);
            }

        });
       binding.carouselView.setImageClickListener(new ImageClickListener() {
           @Override
           public void onClick(int position) {
               PopupDealsFragment popupDealsFragment = new PopupDealsFragment();
               switch (position)
               {
                   case 0:
                       popupDealsFragment.set_combo("2 large pizzas and 2 drinks of your choice");
                       popupDealsFragment.set_price("$25.99");
                       break;
                   case 1:
                       popupDealsFragment.set_combo("1 Large pizza for the price of a small pizza ");
                       popupDealsFragment.set_price("$10.99");
                       break;
                   case 2:
                       popupDealsFragment.set_combo("1 Large pizza, chicken wings and a drink of your choice");
                       popupDealsFragment.set_price("$20.99");
                       break;

               }

           }
       });
        binding.carouselView.setPageCount(sampleImages.length);


    }

    public void popUpDealsOnClick()
    {

        dialogBuilder = new AlertDialog.Builder(getContext());
        View popUpWindow = getLayoutInflater().inflate(R.layout.fragment_popupdealswindow,null);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}