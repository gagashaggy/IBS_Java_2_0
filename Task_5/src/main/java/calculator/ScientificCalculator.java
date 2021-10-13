package calculator;

import java.util.Random;

/**
 * This calculator tries to imitate behaviour of standard MS Windows calculator.
 * This class contains functions available in scientific version of the calculator.
 *
 * @author vmokhnachev
 */
public class ScientificCalculator extends Calculator {

    @Override
    public void setA(String a) {
        switch (a) {
            case "random":
                this.a = new Random().nextDouble();
                System.out.println(this.a);
            case "e":
                this.a = Math.E;
                System.out.println(this.a);
            case "pi":
                this.a = Math.PI;
                System.out.println(this.a);
            default:
                super.setA(a);
        }
    }

    @Override
    public void setB(String b) {
        switch (b) {
            case "random":
                this.b = new Random().nextDouble();
                System.out.println(this.b);
            case "e":
                this.b = Math.E;
                System.out.println(this.b);
            case "pi":
                this.b = Math.PI;
                System.out.println(this.b);
            default:
                 super.setB(b);
        }
    }

    @Override
    public boolean isBinaryOperator() {
        switch (operator) {
            case "^":
            case "%":
            case "mod":
            case "exp":
                return true;
            case "^3":
            case "cbrt":
            case "2^":
            case "e^":
            case "10^":
            case "log":
            case "ln":
            case "abs":
            case "!":
            case "sin":
            case "cos":
            case "tan":
            case "asin":
            case "acos":
            case "sinh":
            case "cosh":
            case "tanh":
                return false;
        }
        return super.isBinaryOperator();
    }

    @Override
    public void calculate() {
        switch (operator) {
            case "^":
                result = Math.pow(a, b);
                break;
            case "mod":
            case "%":
                if (b == 0)
                    throw new ArithmeticException("Cannot divide by zero");
                result = a % b;
                break;
            case "^3":
                result = Math.pow(a, 3);
                break;
            case "cbrt":
                result = Math.cbrt(a);
                break;
            case "2^":
                result = Math.pow(2, a);
                break;
            case "e^":
                result = Math.exp(a);
                break;
            case "10^":
                result = Math.pow(10, a);
                break;
            case "log":
                result = Math.log10(a);
                break;
            case "ln":
                result = Math.log(a);
                break;
            case "exp":
                result = a * Math.pow(10, b);
                break;
            case "abs":
                result = Math.abs(a);
                break;
            case "!":
                factorial();
                break;
            case "sin":
                result = Math.sin(a);
                break;
            case "cos":
                result = Math.cos(a);
                break;
            case "tan":
                result = Math.tan(a);
                break;
            case "asin":
                result = Math.asin(a);
                break;
            case "acos":
                result = Math.acos(a);
                break;
            case "sinh":
                result = Math.sinh(a);
                break;
            case "cosh":
                result = Math.cosh(a);
                break;
            case "tanh":
                result = Math.tanh(a);
                break;
            default:
                super.calculate();
                break;
        }
    }

    private void factorial() {
        int result = (int) this.a;
        int i = result;
        while (i > 1) {
            result *= --i;
        }
        this.result = result;
    }

    @Override
    public String toString() {
        return super.toString() + ", x^3, cbrt(x), x^y, 2^x, e^x, 10^x, log(x), ln(x), exp(x, y), abs(x), x!,\n" +
                "x mod y (x % y),sin(x), cos(x), tan(x), asin(x), acos(x), sinh(x), cosh(x), tanh(x).\n" +
                "You can also use commands \"random\", \"e\", \"pi\", instead of numbers";
    }
}
