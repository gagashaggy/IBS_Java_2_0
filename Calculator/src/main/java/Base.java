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
        System.out.println("Choose a program: 1 - run calculator, 2 - search longest word in array");
        byte n = scanner.nextByte();
        switch (n) {
            case 1:
                runCalculator();
                break;
            case 2:
                searchMaxWordInArray();
                break;
            default:
                System.out.println("Unknown value");
        }
        scanner.close();
    }

    /**
     * Search for the longest word in array
     */
    private static void searchMaxWordInArray() {
        // initialize scanner for reading user's input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Define size of the array:");
        int size = scanner.nextInt();
        String[] words = new String[size];
        for (int i = 0; i < size; i++) {
            System.out.println("Enter a word:");
            words[i] = scanner.next();
        }
        scanner.close();
        System.out.println("Searching for the longest word...");
        int index = 0;
        int length = 0;
        for (int i = 0; i < size; i++) {
            if (words[i].length() > length) {
                length = words[i].length();
                index = i;
            }
        }
        System.out.println("The longest word is " + words[index]);
    }

    /**
     * Run calculator
     */
    private static void runCalculator() {
        // initialize scanner for reading user's input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first number:");
        // read first number
        float a = scanner.nextFloat();
        System.out.println("Enter an operation symbol (+,-,*,/):");
        // read the operator
        String operator = scanner.next();
        System.out.println("Enter second number:");
        // read second number
        float b = scanner.nextFloat();
        // calculate and output the result
        System.out.printf(/*round to 4 decimal places*/"Result = %.4f\n", calculate(a, b, operator));
        scanner.close();
    }

    /**
     * Calculates expression of given numbers and operator
     *
     * @param a        - first number
     * @param b        - second number
     * @param operator - the operator (+,-,*,/)
     * @return sum of a and b
     */
    private static float calculate(float a, float b, String operator) {
        switch (operator) {
            case "+":
                // return sum of given numbers
                return a + b;
            case "-":
                // return difference of given numbers
                return a - b;
            case "*":
                // return product of given numbers
                return a * b;
            case "/":
                // return division of given numbers
                return a / b;
            default:
                throw new RuntimeException("Unknown operator");
        }
    }
}
