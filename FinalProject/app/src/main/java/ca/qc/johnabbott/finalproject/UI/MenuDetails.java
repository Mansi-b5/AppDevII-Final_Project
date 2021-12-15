package ca.qc.johnabbott.finalproject.UI;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

import ca.qc.johnabbott.finalproject.CartItemRecyclerViewAdapter;
import ca.qc.johnabbott.finalproject.Model.CartItem;
import ca.qc.johnabbott.finalproject.Model.MenuData;
import ca.qc.johnabbott.finalproject.Model.Size;
import ca.qc.johnabbott.finalproject.R;
import ca.qc.johnabbott.finalproject.databinding.FragmentMenuDetailsBinding;
import ca.qc.johnabbott.finalproject.viewmodel.ObservableModel;
import ca.qc.johnabbott.finalproject.viewmodel.OrderViewModel;

public class MenuDetails extends Fragment {

    private FragmentMenuDetailsBinding binding;

    public MenuDetails() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentMenuDetailsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view,savedInstanceState);

        MainActivity mainActivity = (MainActivity) getActivity();
        final Spinner spinner = binding.spinnerSize;
        spinner.setAdapter(new ArrayAdapter<Size>(mainActivity,R.layout.support_simple_spinner_dropdown_item,Size.values()));


        binding.title.setText(mainActivity.getOrderViewModel().getItem().getTitle());
        //binding.quantityTextView.setText(mainActivity.getOrderViewModel().getItem().getQuantity());
        binding.imageView.setImageResource(mainActivity.getOrderViewModel().getItem().getImageResourceId());
        binding.description.setText(mainActivity.getOrderViewModel().getItem().getDescription());
        //binding.quantityTextView.setText(mainActivity.getOrderViewModel().getItem().getQuantity());


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Object item = adapterView.getItemAtPosition(i).toString();

         
                if(item.equals("MEDIUM"))
                {
                    binding.price.setText(String.valueOf(mainActivity.getOrderViewModel().getItem().getPrice() + 3.00));
                    notifyViewModel();
                }
                else if(item.equals("LARGE")){
                    binding.price.setText(String.valueOf(mainActivity.getOrderViewModel().getItem().getPrice() + 5.00));
                    notifyViewModel();
                }else{
                    binding.price.setText(String.valueOf(mainActivity.getOrderViewModel().getItem().getPrice()));
                    notifyViewModel();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



//        binding.quantityMinusButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int old = Integer.parseInt(binding.quantityTextView.getText().toString());
//                if(old <= 1) {
//                    return;
//                }
//                binding.quantityTextView.setText(--old);
//            }
//        });
//
//        binding.quantityPlusButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int old = Integer.parseInt(binding.quantityTextView.getText().toString());
//                binding.quantityTextView.setText(++old);
//            }
//        });


    }

    private void notifyViewModel() {

        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.getOrderViewModel().notifyChange();
    }
}