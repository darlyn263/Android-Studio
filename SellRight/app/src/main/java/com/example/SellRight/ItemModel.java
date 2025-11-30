public class ItemModel {

    private int image;
    private String name;
    private String quantity;
    private double price;

    public ItemModel(int image, String name, String quantity, double price) {
        this.image = image;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public int getImage() { return image; }
    public String getName() { return name; }
    public String getQuantity() { return quantity; }
    public double getPrice() { return price; }
}
