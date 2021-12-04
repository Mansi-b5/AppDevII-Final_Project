package ca.qc.johnabbott.finalproject.Model;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import ca.qc.johnabbott.finalproject.R;

public class CartItemSampleData {

    private static List<CartItem> data;

    private static void loadData() throws ParseException {
        data = new ArrayList<>();

        data.add(new CartItem()
                .setProduct(new MenuItem()
                        .setCategory("Pizza")
                        .setTitle("Cheese")
                        .setSize(null)
                        .setDescription("Topped with a mix of mozzarella, provolone and parmesan.")
                        .setPrice(10.99)
                        .setImageResourceId(R.drawable.cart_placeholder_image)
                )
                .setQuantity(3)
                .setUnitPrice(10.99));

        data.add(new CartItem()
                .setProduct(new MenuItem()
                        .setCategory("Sides")
                        .setTitle("Wings")
                        .setSize(null)
                        .setDescription("Classic chicken wings tossed in bbq sauce")
                        .setPrice(5.99)
                        .setImageResourceId(R.drawable.cart_placeholder_image)
                )
                .setQuantity(2)
                .setUnitPrice(9.99));

        data.add(new CartItem()
                .setProduct(new MenuItem()
                        .setCategory("Drinks")
                        .setTitle("Coke")
                        .setSize(null)
                        .setDescription("cola sensation that is a refreshing part of sharing life")
                        .setPrice(2.99)
                        .setImageResourceId(R.drawable.cart_placeholder_image)
                )
                .setQuantity(5)
                .setUnitPrice(2.99));
    }

    public static List<CartItem> getData() {
        if (data == null) {
            try {
                loadData();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return data;
    }
}
