package calculator;

import java.text.DecimalFormat;

/**
 * This calculator tries to imitate behaviour of standard MS Windows calculator.
 * This class contains only basic functions available in simple version of the calculator.
 *
 * @author vmokhnachev
 */
public class Calculator {

    protected double a = Double.NaN;
    protected double b = Double.NaN;
    protected String operator;
    protected double result = Double.NaN;
    // used to cut extra zeros after point
    protected DecimalFormat decimalFormat = new DecimalFormat("#.################");

    /**
     * Sets first number
     * @param a
     */
    public void setA(String a) throws NumberFormatException {
        this.a = Double.parseDouble(a.replace(",", "."));
    }

    /**
     * Sets second number
     * @param b
     */
    public void setB(String b) throws NumberFormatException {
        this.b = Double.parseDouble(b.replace(",", "."));
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getResult() {
        if (Double.isNaN(result))
            return null;
        return decimalFormat.format(result);
    }

    /**
     * Determines if the given operator is binary
     *
     * @return true if the operator is binary, false if the operator is unary
     * @throws IllegalArgumentException if the operator is unknown
     */
    public boolean isBinaryOperator() throws IllegalArgumentException {
        switch (operator) {
            case "+":
            case "-":
            case "*":
            case "/":
                return true;
            case "1/":
            case "^2":
            case "sqrt":
            case "+/-":
                return false;
        }
        throw new IllegalArgumentException("Such operator does not exist or not available in the current type of calculator. Enter another operator:");
    }

    public void calculate() throws ArithmeticException {
        switch (operator) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                if (b == 0)
                    throw new ArithmeticException("Cannot divide by zero");
                result = a / b;
                break;
            case "1/":
                if (a == 0)
                    throw new ArithmeticException("Cannot divide by zero");
                result = 1 / a;
                break;
            case "^2":
                result = Math.pow(a, 2);
                break;
            case "sqrt":
                if (a < 0)
                    throw new ArithmeticException("Cannot get square root from a negative number");
                result = Math.sqrt(a);
                break;
            case "+/-":
                result = a * -1;
                break;
        }
    }

    public void reset() {
        a = Double.NaN;
        b = Double.NaN;
        operator = null;
        result = Double.NaN;
    }

    @Override
    public String toString() {
        return "Available operations: x + y, x - y, x * y, x / y, 1/x, x^2, sqrt(x), +/-";
    }
}
