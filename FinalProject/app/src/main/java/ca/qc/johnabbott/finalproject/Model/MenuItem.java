package ca.qc.johnabbott.finalproject.Model;

public class MenuItem {

    private int id;
    private String category;
    private String title;
    private String description;
    private double price;
    private Size size;
    private int imageResourceId;

    public MenuItem()
    {
    }
    public MenuItem(int id)
    {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public MenuItem setId(int id) {
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

    public int getImageResourceId() {
        return imageResourceId;
    }

    public MenuItem setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
        return this;
    }
}

