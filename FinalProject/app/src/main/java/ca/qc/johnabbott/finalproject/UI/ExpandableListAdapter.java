package ca.qc.johnabbott.finalproject.UI;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.google.android.material.snackbar.Snackbar;

import java.util.HashMap;
import java.util.List;

import ca.qc.johnabbott.finalproject.CartItemListFragment;
import ca.qc.johnabbott.finalproject.Model.CartItem;
import ca.qc.johnabbott.finalproject.Model.MenuItem;
import ca.qc.johnabbott.finalproject.R;
import ca.qc.johnabbott.finalproject.menuDetails;

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private HashMap<String, List<MenuItem>> items;
    private List<String> listHeader;
    private final MenuCategoryFragment menuCategoryFragment;

    public ExpandableListAdapter(List<String> listHeader,HashMap<String,List<MenuItem>> items, MenuCategoryFragment menuCategoryFragment)
    {
        this.items = items;
        this.listHeader = listHeader;
        this.menuCategoryFragment = menuCategoryFragment;
    }

    @Override
    public int getGroupCount() {
        return this.listHeader.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return this.items.get(this.listHeader.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return listHeader.get(i);
    }

    @Override
    public Object getChild(int groupPos, int itemPos) {
        return items.get(listHeader.get(groupPos)).get(itemPos);
    }

    @Override
    public long getGroupId(int groupPos) {
        return groupPos;
    }

    @Override
    public long getChildId(int groupPos, int itemPos) {
        return itemPos;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPos, boolean isExpanded, View view, ViewGroup viewGroup) {
        if(view == null)
        {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_menu_group,viewGroup,false);
        }

        TextView textView = view.findViewById(R.id.expandedListGroup);
        LinearLayout linearLayout = view.findViewById(R.id.cardViewColor);
        ImageView imageView = view.findViewById(R.id.image);

        String header = listHeader.get(groupPos);
        textView.setText(header);

        switch (header) {
            case "Pizza":
                linearLayout.setBackgroundResource(R.drawable.gradient1);
                imageView.setBackgroundResource(R.drawable.ic_baseline_local_pizza_24);
                break;
            case "Sides":
                linearLayout.setBackgroundResource(R.drawable.gradient2);
                imageView.setBackgroundResource(R.drawable.ic_baseline_fastfood_24);
                break;
            case "Drinks":
                linearLayout.setBackgroundResource(R.drawable.gradient3);
                imageView.setBackgroundResource(R.drawable.ic_baseline_local_drink_24);
                break;
            case "Combos":
                //todo mantis change this
                linearLayout.setBackgroundResource(R.drawable.gradient3);
                imageView.setBackgroundResource(R.drawable.ic_baseline_local_drink_24);
                break;
        }

        return view;
    }

    @Override
    public View getChildView(int groupPos, int itemPos, boolean isLast, View view, ViewGroup viewGroup) {
        if(view == null)
        {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_menu_item,viewGroup,false);
        }


        MenuItem menuItem = items.get(listHeader.get(groupPos)).get(itemPos);
        String title = menuItem.getTitle();
        TextView textView = view.findViewById(R.id.textItem);
        textView.setText(title);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new menuDetails();
                menuCategoryFragment.getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_main,fragment).commit();
            }
        });

        ImageButton addToCart = view.findViewById(R.id.addToCartImageButton);
        addToCart.setOnClickListener(view1 -> {
            MainActivity activity = (MainActivity) menuCategoryFragment.getActivity();
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

            Snackbar.make(menuCategoryFragment.getView(), snackBarText, Snackbar.LENGTH_SHORT)
                    .setAction("VIEW CART", new View.OnClickListener() {
                        @Override
                        public void onClick(View view1) {
                            Fragment fragment = new CartItemListFragment();
                            menuCategoryFragment.getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_main,fragment).commit();
                        }
                    })
                    .show();
        });

        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }

}
