package task2.sweets;

public class Marmalade extends Sweets {

    private String color;

    protected Marmalade(String name, double weight, double price) {
        super(name, weight, price);
    }

    public Marmalade(String name, double weight, double price, String color) {
        this(name, weight, price);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Marmalade \"" + getName() + "\": weight: " + getWeight() + ", price: " + getPrice() + ", color: " + getColor();
    }
}
