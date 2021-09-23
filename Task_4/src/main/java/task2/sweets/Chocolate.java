package task2.sweets;

public class Chocolate extends Sweets {

    private String type;

    protected Chocolate(String name, double weight, double price) {
        super(name, weight, price);
    }

    public Chocolate(String name, double weight, double price, String type) {
        this(name, weight, price);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Chocolate \"" + getName() + "\": weight: " + getWeight() + ", price: " + getPrice() + ", type: " + getType();
    }
}
