package task2.sweets;

public class Jellybean extends Sweets {

    private String flavor;

    protected Jellybean(String name, double weight, double price) {
        super(name, weight, price);
    }

    public Jellybean(String name, double weight, double price, String flavor) {
        this(name, weight, price);
        this.flavor = flavor;
    }

    public String getFlavor() {
        return flavor;
    }

    @Override
    public String toString() {
        return "Jellybean \"" + getName() + "\": weight: " + getWeight() + ", price: " + getPrice() + ", flavor: " + getFlavor();
    }
}
