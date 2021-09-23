package task2.sweets;

public class Candy extends Sweets {

    private String classification;

    protected Candy(String name, double weight, double price) {
        super(name, weight, price);
    }

    public Candy(String name, double weight, double price, String classification) {
        this(name, weight, price);
        this.classification = classification;
    }

    public String getClassification() {
        return classification;
    }

    @Override
    public String toString() {
        return "Candy \"" + getName() + "\": weight: " + getWeight() + ", price: " + getPrice() + ", class: " + getClassification();
    }
}
