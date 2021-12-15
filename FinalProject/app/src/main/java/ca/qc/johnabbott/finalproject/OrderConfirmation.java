package ca.qc.johnabbott.finalproject;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ca.qc.johnabbott.finalproject.Model.CartItem;
import ca.qc.johnabbott.finalproject.Model.Order;
import ca.qc.johnabbott.finalproject.UI.MainActivity;
import ca.qc.johnabbott.finalproject.databinding.FragmentCheckoutBinding;
import ca.qc.johnabbott.finalproject.databinding.FragmentOrderConfirmationBinding;
import ca.qc.johnabbott.finalproject.sqlite.DatabaseException;

public class OrderConfirmation extends Fragment {

    private FragmentOrderConfirmationBinding binding;
    private MainActivity mainActivity;
    private long orderId;

    public OrderConfirmation(long orderId) {
        this.orderId = orderId;
//        mainActivity = (MainActivity) getActivity();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentOrderConfirmationBinding.inflate(inflater, container, false);
        return binding.getRoot();
//        return inflater.inflate(R.layout.fragment_oder_confirmation, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mainActivity = (MainActivity) getActivity();

        try {
            Order orderFromDb = (Order) mainActivity.getDBhandler().getOrderTable().readAll().stream().filter(o -> o.getId() == orderId).toArray()[0];

            List<CartItem> cartItemList = mainActivity.getDBhandler().getCartItemTable().readAll().stream().filter(ci -> ci.getCartId() == orderId).collect(Collectors.toList());

            List<CartItem> fromDb = new ArrayList<>();
            for (CartItem ci :cartItemList) {
                ci.setMenuItem(mainActivity.getDBhandler().getMenuItemTable().read(ci.getMenuItemId()));
                fromDb.add(ci);
            }
            orderFromDb.setCartItemList(fromDb);


            String orderString = "";
            String totalString = "";
            String dateString = "";
            dateString += "Placed order on"+orderFromDb.getOrderDate() + "\n";
            double total = 0.0;
            orderString += "Items Ordered:\n";
            for (CartItem ci : orderFromDb.getCartItemList()) {
                orderString += +ci.getQuantity() + " " + ci.getMenuItem().getTitle() + "\n";
                total += ci.getQuantity() * ci.getMenuItem().getPrice();
            }


            totalString += total*1.15;
            binding.itemsDetailsTextView.setText(orderString);
            binding.totalTextview.setText("Total: $"+totalString);
            binding.dateTextview.setText(dateString);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }

    }
}