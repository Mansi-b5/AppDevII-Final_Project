package ca.qc.johnabbott.finalproject.Model;

import ca.qc.johnabbott.finalproject.sqlite.Identifiable;

public class MenuItem implements Identifiable<Long> {

    private Long id;
    private String category;
    private String title;
    private String description;
    private int quantity;
    private double price;
    private Size size;
    private int imageResourceId;

    public MenuItem()
    {
    }
    public MenuItem(Long id)
    {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public MenuItem setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public MenuItem setDescription(String description) {

        this.description = description;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public MenuItem setCategory(String category) {

        this.category = category;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public MenuItem setTitle(String title) {

        this.title = title;
        return this;
    }

    public double getPrice(){
        return price;
    }

    public MenuItem setPrice(double price)
    {
        this.price = price;
        return this;
    }

    public Size getSize(){
        return size;
    }

    public MenuItem setSize(Size size) {
        this.size = size;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public MenuItem setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }


    public int getImageResourceId() {
        return imageResourceId;
    }

    public MenuItem setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
        return this;
    }
}

