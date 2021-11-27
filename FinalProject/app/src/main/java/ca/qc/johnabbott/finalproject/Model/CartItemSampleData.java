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
                .setProduct(new Product()
                    .setName("Pepperoni pizza")
                    .setDescription("miam good pizza")
                    .setPrice(10.99)
                    .setImageResourceId(R.drawable.cart_placeholder_image)
                )
                .setQuantity(3)
                .setUnitPrice(10.99));

        data.add(new CartItem()
                .setProduct(new Product()
                        .setName("Cheese pizza")
                        .setDescription("maim cheesy pizza")
                        .setPrice(9.99)
                        .setImageResourceId(R.drawable.cart_placeholder_image)
                )
                .setQuantity(2)
                .setUnitPrice(2.99));

        data.add(new CartItem()
                .setProduct(new Product()
                        .setName("Coke")
                        .setDescription("slurp good coke")
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
