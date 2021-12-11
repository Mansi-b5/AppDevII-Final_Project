package ca.qc.johnabbott.finalproject.UI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import ca.qc.johnabbott.finalproject.CartItemListFragment;
import ca.qc.johnabbott.finalproject.Model.CartItem;
import ca.qc.johnabbott.finalproject.Model.MenuItem;
import ca.qc.johnabbott.finalproject.R;
import ca.qc.johnabbott.finalproject.databinding.FragmentPopupdealswindowBinding;

public class PopupDealsFragment extends DialogFragment {


    private FragmentPopupdealswindowBinding binding;
    private MenuItem menuItem;
    private HomeFragment homeFragment;

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public HomeFragment getFragment()
    {
        return this.homeFragment;
    }
    public void setHomeFragment(HomeFragment homeFragment)
    {
        this.homeFragment = homeFragment;
    }
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentPopupdealswindowBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.comboNameTextview.setText(menuItem.getDescription());
        binding.priceOfComboTextview.setText(String.valueOf(menuItem.getPrice()));
        binding.dealsImageView.setImageResource(menuItem.getImageResourceId());

        binding.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity activity = (MainActivity) getActivity();
                menuItem.setImageResourceId(R.drawable.cart_placeholder_image);
                List<CartItem> currentCartItems = activity.getOrderViewModel().getOrder().getCartItemList();
                String snackBarText = "";

                CartItem cartItem = currentCartItems.stream().filter(ci -> ci.getProduct().getTitle().equals(menuItem.getTitle())).findFirst().orElse(null);

                // create new cart item else plus one the quantity of the existing cartItem
                if(cartItem == null) {
                    currentCartItems.add(new CartItem()
                            .setProduct(menuItem)
                            .setQuantity(1)
                            .setUnitPrice(menuItem.getPrice()));

                    snackBarText = "Added " + menuItem.getTitle() + " to the cart.";
                } else {
                    int quantity = cartItem.getQuantity();
                    cartItem.setQuantity(++quantity);

                    snackBarText = "Added one more " + menuItem.getTitle() + " to the cart.";
                }

                Snackbar.make(getFragment().getView(), snackBarText, Snackbar.LENGTH_SHORT)
                        .setAction("VIEW CART", new View.OnClickListener() {
                            @Override
                            public void onClick(View view1) {
                                Fragment fragment = new CartItemListFragment();
                                getFragment().getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_main,fragment).commit();
                            }
                        })
                        .show();
            }
        });
        binding.cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                closeWindow();

            }
        });
    }
    private void closeWindow()
    {
        this.dismiss();
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}
