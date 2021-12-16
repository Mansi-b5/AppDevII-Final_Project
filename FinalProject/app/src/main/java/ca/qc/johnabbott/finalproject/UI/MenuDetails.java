package ca.qc.johnabbott.finalproject.UI;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import ca.qc.johnabbott.finalproject.CartItemRecyclerViewAdapter;
import ca.qc.johnabbott.finalproject.Model.CartItem;
import ca.qc.johnabbott.finalproject.Model.MenuData;
import ca.qc.johnabbott.finalproject.Model.MenuItem;
import ca.qc.johnabbott.finalproject.Model.Size;
import ca.qc.johnabbott.finalproject.R;
import ca.qc.johnabbott.finalproject.databinding.FragmentMenuDetailsBinding;
import ca.qc.johnabbott.finalproject.viewmodel.ObservableModel;
import ca.qc.johnabbott.finalproject.viewmodel.OrderViewModel;

public class MenuDetails extends Fragment {

    private FragmentMenuDetailsBinding binding;
    private MenuItem menuItem;

    public MenuDetails(MenuItem menuItem) {

        this.menuItem = menuItem;
    }


    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
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


        binding.title.setText(menuItem.getTitle());

        binding.imageView.setImageResource(menuItem.getImageResourceId());
        binding.description.setText(menuItem.getDescription());

        binding.confirmOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivity activity = (MainActivity) getActivity();
                List<CartItem> currentCartItems = activity.getOrderViewModel().getOrder().getCartItemList();
                String snackBarText = "";

                CartItem cartItem = currentCartItems.stream().filter(ci -> ci.getMenuItem().getTitle().equals(menuItem.getTitle())).findFirst().orElse(null);

                // create new cart item else plus one the quantity of the existing cartItem
                if(cartItem == null) {
                    currentCartItems.add(new CartItem()
                            .setMenuItem(menuItem)
                            .setQuantity(1)
                            .setUnitPrice(menuItem.getPrice()));

                    snackBarText = "Added " + menuItem.getTitle() + " to the cart.";
                } else {
                    int quantity = cartItem.getQuantity();
                    cartItem.setQuantity(++quantity);

                    snackBarText = "Added one more " + menuItem.getTitle() + " to the cart.";
                }

                Snackbar.make(getView(), snackBarText, Snackbar.LENGTH_SHORT)
                        .setAction("VIEW CART", new View.OnClickListener() {
                            @Override
                            public void onClick(View view1) {
                                activity.setter(R.id.ic_cart);
                            }
                        })
                        .show();
            }
        });


    }

    private void notifyViewModel() {

        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.getOrderViewModel().notifyChange();
    }
}