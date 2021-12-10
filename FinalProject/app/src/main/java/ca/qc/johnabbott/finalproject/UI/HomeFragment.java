package ca.qc.johnabbott.finalproject.UI;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ca.qc.johnabbott.finalproject.Model.MenuData;
import ca.qc.johnabbott.finalproject.Model.MenuItem;
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

        List<MenuItem> menuDataComboList = MenuData.getData().get("Combo");

        binding.carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(menuDataComboList.get(position).getImageResourceId());
            }

        });
       binding.carouselView.setImageClickListener(new ImageClickListener() {
           @Override
           public void onClick(int position) {
               PopupDealsFragment popupDealsFragment = new PopupDealsFragment();


               popupDealsFragment.setMenuItem(menuDataComboList.get(position));
               popupDealsFragment.setHomeFragment(fragment());
               popupDealsFragment.show(getActivity().getSupportFragmentManager(), "deals");

           }
       });
        binding.carouselView.setPageCount(menuDataComboList.size());

        binding.pizzaImageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new MenuCategoryFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fl_wrapper,fragment).commit();

            }
        });
        binding.drinksImageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new MenuCategoryFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fl_wrapper,fragment).commit();

            }
        });
        binding.sidesImageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new MenuCategoryFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fl_wrapper,fragment).commit();

            }
        });


    }
    private HomeFragment fragment()
    {
        return this;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}