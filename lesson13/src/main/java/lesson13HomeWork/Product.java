package lesson13HomeWork;

public class Product {
    private int id;

    public Product(int id, String title, int productCost) {
        this.id = id;
        this.title = title;
        this.productCost = productCost;
    }

    private String title;
    private int productCost;

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setProductCost(int productCost) {
        this.productCost = productCost;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getProductCost() {
        return productCost;
    }

    @Override
    public String toString() {
        return ("Товар " + title + "(id: " + id + ") стоит " + productCost + " руб.");
    }
}
