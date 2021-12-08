package ca.qc.johnabbott.finalproject;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ca.qc.johnabbott.finalproject.Model.CartItem;
import ca.qc.johnabbott.finalproject.UI.MainActivity;
import ca.qc.johnabbott.finalproject.databinding.FragmentCheckoutBinding;

public class CheckoutFragment extends Fragment {

    private FragmentCheckoutBinding binding;

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
        String orderDetails = "";
        for (CartItem cartItem : activity.getOrderViewModel().getOrder().getCartItemList()) {
            orderDetails += cartItem.getQuantity() + " " + cartItem.getProduct().getTitle() + "\n";
        }
        binding.orderDetailsTextView.setText(orderDetails);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}