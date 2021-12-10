package ca.qc.johnabbott.finalproject;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.NumberFormat;
import java.util.List;

import ca.qc.johnabbott.finalproject.Model.CartItem;
import ca.qc.johnabbott.finalproject.UI.MainActivity;
import ca.qc.johnabbott.finalproject.databinding.FragmentCartItemListBinding;

/**
 * A fragment representing a list of Items.
 */
public class CartItemListFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

//    private final MainActivity mainActivity;
    private FragmentCartItemListBinding binding;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public CartItemListFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static CartItemListFragment newInstance(int columnCount) {
        CartItemListFragment fragment = new CartItemListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        ((MainActivity) getActivity()).getOrderViewModel().addOnUpdateListener(this, item -> populateTotalPriceTable());
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentCartItemListBinding.inflate(inflater, container, false);

        if(((MainActivity) getActivity()).getOrderViewModel().getOrder().getLocation() != null){
            binding.orderInfoTextView.setText(((MainActivity) getActivity()).getOrderViewModel().getOrder().getLocation().getName());
        }

        // Set the adapter
        Context context = getContext();
        if (mColumnCount <= 1) {
            binding.cartRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        } else {
            binding.cartRecyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
        }

        binding.cartRecyclerView.setAdapter(new CartItemRecyclerViewAdapter(((MainActivity) getActivity()).getOrderViewModel().getOrder().getCartItemList(), this));

        populateTotalPriceTable();

        //todo maybe have a isEmpty
        if(((MainActivity) getActivity()).getOrderViewModel().getOrder().isEmpty())
            binding.checkoutButton.setVisibility(View.INVISIBLE);

        binding.checkoutButton.setOnClickListener(view -> {

            Fragment fragment = new CheckoutFragment();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_main,fragment).commit();
        });

        return binding.getRoot();
    }

    private void populateTotalPriceTable() {
        double subtotal = ((MainActivity) getActivity()).getOrderViewModel().getOrder().getCartItemList().stream().mapToDouble(ci -> ci.getQuantity() * ci.getUnitPrice()).sum();
        double taxes = subtotal * 0.15;
        NumberFormat formatter = NumberFormat.getCurrencyInstance();


        binding.subtotalNumber.setText(formatter.format(subtotal));
        binding.taxesNumber.setText(formatter.format(taxes));
        binding.totalNumber.setText(formatter.format(subtotal + taxes));
    }
}