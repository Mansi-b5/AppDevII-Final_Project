package ca.qc.johnabbott.finalproject;

import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import ca.qc.johnabbott.finalproject.Model.CartItem;
import ca.qc.johnabbott.finalproject.Model.LocationD;

import ca.qc.johnabbott.finalproject.Model.LocationData;
import ca.qc.johnabbott.finalproject.Model.Order;
import ca.qc.johnabbott.finalproject.Model.OrderStatus;
import ca.qc.johnabbott.finalproject.Model.Product;
import ca.qc.johnabbott.finalproject.Model.SpinAdapter;
import ca.qc.johnabbott.finalproject.UI.MainActivity;
import ca.qc.johnabbott.finalproject.databinding.FragmentCheckoutBinding;
import ca.qc.johnabbott.finalproject.sqlite.DatabaseException;

public class CheckoutFragment extends Fragment {

    private FragmentCheckoutBinding binding;

    private Spinner spinner;
    private SpinAdapter spinAdapter;
    private int  currentNotificationId = 0;

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

        binding.pickupRadioButton.setChecked(true);

        binding.confirmOrderButton.setOnClickListener(view1 -> {
            if(!isFormFilled()) {
                return;
            }

            order.setOrderDate(new Date());
            order.setStatus(OrderStatus.PENDING);
            MainActivity mainActivity = (MainActivity) getActivity();
            try {
                NotificationThread noti = new NotificationThread();
                noti.setActivity(activity);
                Thread thread = new Thread(noti);
                thread.start();

                long cartId = mainActivity.getDBhandler().getOrderTable().create(order);
                for (CartItem ci: order.getCartItemList()) {
                    ci.setCartId(cartId);
                    mainActivity.getDBhandler().getCartItemTable().create(ci);
                }
                mainActivity.getOrderViewModel().setOrder(new Order());
                Fragment fragment = new OrderConfirmation(cartId);
//                mainActivity.getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_main,fragment).commit();
                mainActivity.getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_main,fragment).commit();
            } catch (DatabaseException e) {
                e.printStackTrace();
            }
        });
    }



    private boolean isFormFilled() {
        String name = binding.nameEditText.getText().toString();
        String phoneNumber = binding.phoneTextView.getText().toString();
        String address = binding.addressEditText.getText().toString();

        boolean nameFilled = isFormSectionFilled(name, binding.nameEditText);
        boolean phoneNumberFilled = isFormSectionFilled(phoneNumber, binding.phoneEditText);
        boolean addressFilled = isFormSectionFilled(address, binding.addressEditText);

        return nameFilled && phoneNumberFilled && addressFilled;
    }

    private boolean isFormSectionFilled(String input, EditText editText) {
        if(input != null && input.trim().isEmpty()) {
            editText.setHint("please fill up this section");
            editText.setHintTextColor(Color.RED);
            return false;
        }
        return true;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}