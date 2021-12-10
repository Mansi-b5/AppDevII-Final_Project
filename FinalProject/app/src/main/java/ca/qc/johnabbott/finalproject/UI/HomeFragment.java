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

        int[] sampleImages = {R.drawable.firstcombo,R.drawable.secondcombo,R.drawable.thirdcombo};


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
                       popupDealsFragment.set_combo("2 large pizzas+2 drinks+fries");
                       popupDealsFragment.set_price("$25.99");
                       popupDealsFragment.set_image(R.drawable.firstcombo);

                       break;
                   case 1:
                       popupDealsFragment.set_combo("Buy 1 large pizza, get small free");
                       popupDealsFragment.set_price("$17.99");
                       popupDealsFragment.set_image(R.drawable.secondcombo);
                       break;
                   case 2:
                       popupDealsFragment.set_combo("1 Large pizza+6 chicken wings+ 1 drink");
                       popupDealsFragment.set_price("$20.99");
                       popupDealsFragment.set_image(R.drawable.thirdcombo);
                       break;

               }
               popupDealsFragment.show(getFragmentManager(), "deals");

           }
       });
        binding.carouselView.setPageCount(sampleImages.length);

        binding.pizzaImageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new MenuCategoryFragment();



            }
        });


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}