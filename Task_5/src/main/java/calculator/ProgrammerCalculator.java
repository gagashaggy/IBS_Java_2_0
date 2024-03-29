package calculator;

/**
 * This calculator tries to imitate behaviour of standard MS Windows calculator.
 * This class contains functions available in programmer version of the calculator.
 *
 * @author vmokhnachev
 */
public class ProgrammerCalculator extends Calculator {

    private int a;
    private int b;
    private int result;
    // possible values are bin, oct, dec, hex
    private String numeralSystem = "dec";
    private String convertTo;
    private String convertedResult;

    public String getNumeralSystem() {
        return numeralSystem;
    }

    public void setNumeralSystem(String numeralSystem) {
        this.numeralSystem = numeralSystem;
    }

    @Override
    public void setA(String a) throws NumberFormatException {
        switch (numeralSystem) {
            case "dec":
                this.a = Integer.parseInt(a);
                break;
            case "bin":
                this.a = Integer.parseInt(a, 2);
                break;
            case "oct":
                this.a = Integer.parseInt(a, 8);
                break;
            case "hex":
                this.a = Integer.parseInt(a, 16);
                break;
        }
    }

    @Override
    public String getResult() {
        if (convertTo != null)
            return convertedResult;
        switch (numeralSystem) {
            case "bin":
                return Integer.toBinaryString(result);
            case "oct":
                return Integer.toOctalString(result);
            case "hex":
                return Integer.toHexString(result).toUpperCase();
        }
        return String.valueOf(result);
    }

    @Override
    public void setB(String b) throws NumberFormatException {
        switch (numeralSystem) {
            case "dec":
                this.b = Integer.parseInt(b);
                break;
            case "bin":
                this.b = Integer.parseInt(b, 2);
                break;
            case "oct":
                this.b = Integer.parseInt(b, 8);
                break;
            case "hex":
                this.b = Integer.parseInt(b, 16);
                break;
        }
    }

    @Override
    public boolean isBinaryOperator() {
        switch (operator) {
            case "+":
            case "-":
            case "*":
            case "/":
            case "and":
            case "&":
            case "or":
            case "|":
            case "nand":
            case "nor":
            case "xor":
            case "^":
                return true;
            case "bin":
            case "oct":
            case "dec":
            case "hex":
            case "not":
            case "~":
                return false;
        }
        throw new IllegalArgumentException("Such operator does not exist or not available in the current type of calculator. Enter another operator:");
    }

    @Override
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
                if (b == 0)
                    throw new ArithmeticException("Cannot divide by zero");
                result = a / b;
                break;
            case "and":
            case "&":
                result = a & b;
                break;
            case "or":
            case "|":
                result = a | b;
                break;
            case "not":
            case "~":
                result = ~a;
                break;
            case "nand":
                result = ~(a & b);
                break;
            case "nor":
                result = ~(a | b);
                break;
            case "xor":
            case "^":
                result = a ^ b;
                break;
            case "bin":
                convertTo = operator;
                convertedResult = Integer.toBinaryString(a);
                break;
            case "oct":
                convertTo = operator;
                convertedResult = Integer.toOctalString(a);
                break;
            case "dec":
                convertTo = operator;
                convertedResult = Integer.toString(a);
                break;
            case "hex":
                convertTo = operator;
                convertedResult = Integer.toHexString(a).toUpperCase();
                break;
        }
    }

    @Override
    public void reset() {
        a = 0;
        b = 0;
        operator = null;
        convertTo = null;
        convertedResult = null;
    }

    @Override
    public String toString() {
        return "Available operations: x + y, x - y, x * y, x / y, +/-, bin(x), oct(x), dec(x), hex(x), x and y (x & y),\n" +
                "x or y (x | y), not(x) (~(x)), x nand y, x nor y, x xor y (x ^ y)\nCurrent numeral system is: "
                + getNumeralSystem() + "\nAvailable numeral systems: bin, oct, dec, hex";
    }
}
