package ca.qc.johnabbott.finalproject;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.text.NumberFormat;

import ca.qc.johnabbott.finalproject.Model.CartItem;
import ca.qc.johnabbott.finalproject.Model.CartItemSampleData;
import ca.qc.johnabbott.finalproject.databinding.FragmentCartItemListBinding;
import ca.qc.johnabbott.finalproject.placeholder.PlaceholderContent;

/**
 * A fragment representing a list of Items.
 */
public class CartItemListFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FragmentCartItemListBinding binding = FragmentCartItemListBinding.inflate(inflater, container, false);

        // Set the adapter
        Context context = getContext();
        if (mColumnCount <= 1) {
            binding.cartRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        } else {
            binding.cartRecyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
        }
        binding.cartRecyclerView.setAdapter(new CartItemRecyclerViewAdapter(CartItemSampleData.getData()));

        double subtotal = CartItemSampleData.getData().stream().mapToDouble(ci -> ci.getQuantity() * ci.getUnitPrice()).sum();
        //todo maybe do this in the object

        double taxes = subtotal * 0.15; //todo do w constant
        NumberFormat formatter = NumberFormat.getCurrencyInstance();

        binding.subtotalNumber.setText(formatter.format(subtotal));
        binding.taxesNumber.setText(formatter.format(taxes));
        binding.totalNumber.setText(formatter.format(subtotal + taxes));


        return binding.getRoot();
    }
}