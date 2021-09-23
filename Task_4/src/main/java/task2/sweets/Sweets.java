package task2.sweets;

/**
 * Abstract class for some sweets
 */
public abstract class Sweets {
    private String name;
    private double weight;
    private double price;

    protected Sweets(String name, double weight, double price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }
}
