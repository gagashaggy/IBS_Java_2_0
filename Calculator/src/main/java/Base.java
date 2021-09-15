import java.util.Scanner;

/**
 * Base class of the program
 *
 * @author vmokhnachev
 */
public class Base {
    public static void main(String[] args) {
        // initialize scanner for reading user's input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first number:");
        // read first number
        float a = scanner.nextFloat();
        System.out.println("Enter second number:");
        // read second number
        float b = scanner.nextFloat();
        // calculate and output the result
        System.out.printf(/*round to 4 decimal places*/"Sum = %.4f", calculate(a, b));
    }

    /**
     * Calculates sum of given numbers
     * @param a - first number
     * @param b - second number
     * @return sum of a and b
     */
    private static float calculate(float a, float b) {
        // return sum of given numbers
        return a + b;
    }
}
