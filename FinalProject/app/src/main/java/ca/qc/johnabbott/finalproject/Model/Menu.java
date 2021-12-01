package ca.qc.johnabbott.finalproject.Model;

public class Menu {

    private int id;
    private String category;
    private String title;
    private String description;
    private double price;
    private Size size;

    public Menu()
    {
    }
    public Menu(int id)
    {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Menu setId(int id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Menu setDescription(String description) {

        this.description = description;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public Menu setCategory(String category) {

        this.category = category;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Menu setTitle(String title) {

        this.title = title;
        return this;
    }

    public double getPrice(){
        return price;
    }

    public Menu setPrice(double price)
    {
        this.price = price;
        return this;
    }

    public Size getSize(){
        return size;
    }

    public Menu setSize(Size size) {
        this.size = size;
        return this;
    }
}

