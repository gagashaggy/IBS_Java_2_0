import java.util.Scanner;

/**
 * Base class of the program
 *
 * @author vmokhnachev
 */
public class Base {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first number:");
        float a = scanner.nextFloat();
        System.out.println("Enter second number");
        float b = scanner.nextFloat();
        System.out.printf("Sum = %.4f", calculate(a, b));
    }

    /**
     * Calculates sum of given numbers
     * @param a - first number
     * @param b - second number
     * @return sum of a and b
     */
    private static float calculate(float a, float b) {
        return a + b;
    }
}
