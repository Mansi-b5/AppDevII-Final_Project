package ca.qc.johnabbott.finalproject;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.RadioGroup;
import android.widget.Spinner;

import ca.qc.johnabbott.finalproject.Model.LocationD;
import ca.qc.johnabbott.finalproject.Model.LocationData;
import ca.qc.johnabbott.finalproject.Model.Order;
import ca.qc.johnabbott.finalproject.Model.SpinAdapter;
import ca.qc.johnabbott.finalproject.UI.MainActivity;
import ca.qc.johnabbott.finalproject.databinding.FragmentCheckoutBinding;

public class CheckoutFragment extends Fragment {

    private FragmentCheckoutBinding binding;

    private Spinner spinner;
    private SpinAdapter spinAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCheckoutBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MainActivity activity = (MainActivity) getActivity();
        Order order = activity.getOrderViewModel().getOrder();

        LocationD[] locations = LocationData.getData().toArray(new LocationD[0]);
        spinAdapter = new SpinAdapter(getContext(), android.R.layout.simple_spinner_item, locations);
        spinner = binding.locationSpinner;
        spinner.setAdapter(spinAdapter);
        if(order.getLocation() != null) {
            spinner.setSelection(spinAdapter.getPosition(order.getLocation()));
        }
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                order.setLocation(spinAdapter.getItem(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId) {
                    case R.id.deliveryRadioButton:
                        binding.deliveryWarningTextView.setVisibility(View.VISIBLE);
                        break;
                    case R.id.pickupRadioButton:
                        binding.deliveryWarningTextView.setVisibility(View.GONE);
                        break;
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}