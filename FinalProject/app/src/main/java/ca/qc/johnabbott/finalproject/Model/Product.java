package ca.qc.johnabbott.finalproject.Model;

public class Product {

    // generate local IDs (in memory only).
    private static int CURRENT_LOCAL_ID = 0;

    private int id;
    private String name;
    private String description;
    private double price;
    private int imageResourceId;

    public Product() {
        id = CURRENT_LOCAL_ID++;
    }

    public Product(int id, String name, String description, double price, int imageResourceId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageResourceId = imageResourceId;
    }

    public int getId() {
        return id;
    }

    public Product setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;

    }

    public String getDescription() {
        return description;
    }

    public Product setDescription(String description) {
        this.description = description;
        return this;

    }

    public double getPrice() {
        return price;
    }

    public Product setPrice(double price) {
        this.price = price;
        return this;

    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public Product setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
        return this;

    }
}
