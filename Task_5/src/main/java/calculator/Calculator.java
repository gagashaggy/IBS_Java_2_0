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
    protected String errorMessage;
    // used to cut extra zeros after point
    protected DecimalFormat decimalFormat = new DecimalFormat("#.################");

    /**
     * Sets first number
     * @param a
     * @return true if the number was set correctly, false if something went wrong
     */
    public boolean setA(String a) {
        try {
            this.a = Double.parseDouble(a.replace(",", "."));
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Not a number. Enter a number:");
            return false;
        }
    }

    /**
     * Sets second number
     * @param b
     * @return true if the number was set correctly, false if something went wrong
     */
    public boolean setB(String b) {
        try {
            this.b = Double.parseDouble(b.replace(",", "."));
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Not a number. Enter a number:");
            return false;
        }
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getResult() {
        if (errorMessage != null)
            return errorMessage;
        if (Double.isNaN(result))
            return null;
        return decimalFormat.format(result);
    }

    /**
     * Determines if the given operator is binary
     *
     * @return true if the operator is binary, false if the operator is unary, null if the operator is unknown
     */
    public Boolean isBinaryOperator() {
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
        return null;
    }

    public void calculate() {
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
                result = a / b;
                break;
            case "1/":
                result = 1 / a;
                break;
            case "^2":
                result = Math.pow(a, 2);
                break;
            case "sqrt":
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
        errorMessage = null;
    }

    @Override
    public String toString() {
        return "Available operations: x + y, x - y, x * y, x / y, 1/x, x^2, sqrt(x), +/-";
    }
}
