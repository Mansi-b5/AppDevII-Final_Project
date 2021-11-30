package ca.qc.johnabbott.finalproject.Model;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MenuData {

    private static List<Menu> pizza;
    private static List<Menu> sides;
    private static List<Menu> drinks;
    private static HashMap<String,List<Menu>> items;

    public static void loadData() throws ParseException {
        pizza = new ArrayList<>();
        sides = new ArrayList<>();
        drinks = new ArrayList<>();
        items = new HashMap<>();

        pizza.add(new Menu()
                .setCategory("Pizza")
                .setTitle("Cheese")
                .setSize(null)
                .setDescription("Topped with a mix of mozzarella, provolone and parmesan.")
                .setPrice(10.99));

        pizza.add(new Menu()
                .setCategory("Pizza")
                .setTitle("Vegetarian")
                .setSize(null)
                .setDescription("Fresh green peppers, onion, tomatoes, mushrooms, and olives.")
                .setPrice(10.99));

        pizza.add(new Menu()
                .setCategory("Pizza")
                .setTitle("Pepperoni")
                .setSize(null)
                .setDescription("Pepperoni topped with an extra layer of cheese.")
                .setPrice(10.99));

        pizza.add(new Menu()
                .setCategory("Pizza")
                .setTitle("All Dressed")
                .setSize(null)
                .setDescription("Peppers, onion, tomatoes, mushrooms, olives and pepperoni.")
                .setPrice(10.99));

        pizza.add(new Menu()
                .setCategory("Pizza")
                .setTitle("Hawaiian")
                .setSize(null)
                .setDescription("Pineapple and slices of ham topped with an extra layer of cheese.")
                .setPrice(10.99));

        pizza.add(new Menu()
                .setCategory("Pizza")
                .setTitle("All Dressed")
                .setSize(null)
                .setDescription("A topping of spicy barbeque sauce, diced chicken, cilantro, peppers, and onions")
                .setPrice(10.99));

        sides.add(new Menu()
                .setCategory("Sides")
                .setTitle("French Fries")
                .setSize(null)
                .setDescription("A thin strip of potato, deep fried and garnished with salt and mixed herbs")
                .setPrice(5.99));

        sides.add(new Menu()
                .setCategory("Sides")
                .setTitle("French Fries")
                .setSize(null)
                .setDescription("A thin strip of potato, deep fried and garnished with salt and mixed herbs")
                .setPrice(5.99));

        sides.add(new Menu()
                .setCategory("Sides")
                .setTitle("Bread sticks")
                .setSize(null)
                .setDescription("Crispy on the outside, soft and chewy on the inside. Served with marinara dipping sauce.")
                .setPrice(5.99));

        sides.add(new Menu()
                .setCategory("Sides")
                .setTitle("Garlic Bread")
                .setSize(null)
                .setDescription("Thick slices of toasted bread brushed with buttery garlic spread.")
                .setPrice(5.99));

        sides.add(new Menu()
                .setCategory("Sides")
                .setTitle("Wings")
                .setSize(null)
                .setDescription("Classic chicken wings tossed in bbq sauce")
                .setPrice(5.99));

        sides.add(new Menu()
                .setCategory("Sides")
                .setTitle("Garden Salad")
                .setSize(null)
                .setDescription("Garden greens, red peppers, red onions, cucumbers, carrots, beets and citrus vinaigrette")
                .setPrice(5.99));

        sides.add(new Menu()
                .setCategory("Sides")
                .setTitle("Chicken Caesar Salad")
                .setSize(null)
                .setDescription("Grilled chicken breast, romaine, croutons, bacon and freshly grated Parmesan topped with caesar dressing.")
                .setPrice(5.99));

        drinks.add(new Menu()
                .setCategory("Drinks")
                .setTitle("Coke")
                .setSize(null)
                .setDescription("cola sensation that is a refreshing part of sharing life")
                .setPrice(2.99));

        drinks.add(new Menu()
                .setCategory("Drinks")
                .setTitle("Diet Coke")
                .setSize(null)
                .setDescription("Beautifully balanced adult cola taste in a no calorie beverage")
                .setPrice(2.99));

        drinks.add(new Menu()
                .setCategory("Drinks")
                .setTitle("Ginger Ale")
                .setSize(null)
                .setDescription("A delicious carbonated drink made with real ginger.")
                .setPrice(2.99));

        drinks.add(new Menu()
                .setCategory("Drinks")
                .setTitle("Ice Tea")
                .setSize(null)
                .setDescription("Iced Tea invigorates and quenches your thirst.")
                .setPrice(2.99));

        drinks.add(new Menu()
                .setCategory("Drinks")
                .setTitle("Sprite")
                .setSize(null)
                .setDescription("Lemon-lime flavor, clear, clean and crisp with no caffeine.")
                .setPrice(2.99));

        drinks.add(new Menu()
                .setCategory("Drinks")
                .setTitle("Pepsi")
                .setSize(null)
                .setDescription("The bold, robust, effervescently magic cola")
                .setPrice(2.99));

        drinks.add(new Menu()
                .setCategory("Drinks")
                .setTitle("Diet Pepsi")
                .setSize(null)
                .setDescription("Light.Crisp Refreshing. With zero sugar, zero calories and zero carbs")
                .setPrice(2.99));

        items.put("Pizza", pizza);
        items.put("Sides", sides);
        items.put("Drinks",drinks);
    }

    public static HashMap<String, List<Menu>> getData() {
        if (items == null) {
            try {
                loadData();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return items;
    }
}
