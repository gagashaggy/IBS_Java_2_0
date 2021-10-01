import calculator.Calculator;
import calculator.ProgrammerCalculator;
import calculator.ScientificCalculator;

import java.util.Scanner;

/**
 * This calculator tries to imitate behaviour of standard MS Windows calculator.
 *
 * @author vmokhnachev
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        System.out.println("This is simple calculator. It can perform the following operations:");
        System.out.println(calculator.toString());
        System.out.println("Where x and y are some numbers.");
        System.out.println();
        System.out.println("To use the calculator, you have to type first number, then operator sign, then second number (if applicable).");
        System.out.println("You can change the type of calculator. Available types are: simple, scientific, programmer.");
        System.out.println("You can type \"exit\" to exit the program.");
        System.out.println();
        System.out.println("Enter the first number or some command:");
        String command;
        while (!(command = scanner.next().toLowerCase().trim()).equals("exit")) {
            switch (command.toLowerCase()) {
                case "simple":
                    calculator = new Calculator();
                    System.out.println("You have selected simple calculator.");
                    System.out.println(calculator.toString());
                    System.out.println();
                    System.out.println("Enter the first number or some command:");
                    break;
                case "scientific":
                    calculator = new ScientificCalculator();
                    System.out.println("You have selected engineer calculator.");
                    System.out.println(calculator.toString());
                    System.out.println();
                    System.out.println("Enter the first number or some command:");
                    break;
                case "programmer":
                    calculator = new ProgrammerCalculator();
                    System.out.println("You have selected programmer calculator.");
                    System.out.println(calculator.toString());
                    System.out.println();
                    System.out.println("Enter the first number or some command:");
                    break;
                case "bin":
                case "oct":
                case "dec":
                case "hex":
                    if (calculator instanceof ProgrammerCalculator) {
                        if (!command.equals(((ProgrammerCalculator) calculator).getNumeralSystem())) {
                            ((ProgrammerCalculator) calculator).setNumeralSystem(command);
                            System.out.println("You have selected new numeral system: " + ((ProgrammerCalculator) calculator).getNumeralSystem());
                        } else System.out.println("This numeral system is already selected");
                    } else System.out.println("This type of calculator does not support numeral systems. Please switch to Programmer calculator.");
                    break;
                default:
                    calculator.setA(command);
                    System.out.println("Enter the operation symbol:");
                    calculator.setOperator(scanner.next().trim());
                    Boolean isBinary = calculator.isBinaryOperator();
                    if (isBinary != null) {
                        if (isBinary) {
                            System.out.println("Enter the second number:");
                            calculator.setB(scanner.next());
                        }
                    } else {
                        System.out.println("Such operator does not exist or not available in the current type of calculator.");
                        calculator.reset();
                        continue;
                    }
                    calculator.calculate();
                    if (calculator.getResult() == null) {
                        System.out.println("The requested operation could not be executed on given operands.");
                        calculator.reset();
                    } else {
                        System.out.println("result = " + calculator.getResult());
                    }
                    System.out.println();
                    System.out.println("Enter the first number or some command:");
                    System.out.println(calculator.toString());
                    calculator.reset();
            }
        }
        scanner.close();
        System.out.println("The calculator is finished.");
    }
}
