import calculator.Calculator;
import org.junit.Assert;
import org.junit.Test;

public class SimpleCalculatorTests {

    protected Calculator prepareOperation(double a, double b, String operator) {
        Calculator calculator = new Calculator();
        calculator.setA(String.valueOf(a));
        calculator.setB(String.valueOf(b));
        calculator.setOperator(operator);
        return calculator;
    }

    protected Calculator prepareOperation(double a, String operator) {
        Calculator calculator = new Calculator();
        calculator.setA(String.valueOf(a));
        calculator.setOperator(operator);
        return calculator;
    }

    @Test
    public void testSum() {
        double a = 4.65;
        double b = 4.87;
        Calculator calculator = prepareOperation(a, b, "+");
        Assert.assertTrue("The operator is not set as binary", calculator.isBinaryOperator());
        calculator.calculate();
        Assert.assertEquals("Sum works incorrectly", String.valueOf(a + b), calculator.getResult());
    }

    @Test
    public void testSubtraction() {
        double a = 0.40;
        double b = 1.82;
        Calculator calculator = prepareOperation(a, b, "-");
        Assert.assertTrue("The operator is not set as binary", calculator.isBinaryOperator());
        calculator.calculate();
        Assert.assertEquals("Subtraction works incorrectly", String.valueOf(a - b), calculator.getResult());
    }

    @Test
    public void testMultiply() {
        double a = 0.88;
        double b = 2.14;
        Calculator calculator = prepareOperation(a, b, "*");
        Assert.assertTrue("The operator is not set as binary", calculator.isBinaryOperator());
        calculator.calculate();
        Assert.assertEquals("Multiply works incorrectly", String.valueOf(a * b), calculator.getResult());
    }

    @Test
    public void testDivision() {
        double a = 3.11;
        double b = 1.23;
        Calculator calculator = prepareOperation(a, b, "/");
        Assert.assertTrue("The operator is not set as binary", calculator.isBinaryOperator());
        calculator.calculate();
        Assert.assertEquals("Division works incorrectly", String.valueOf(a / b), calculator.getResult());
    }

    @Test(expected = ArithmeticException.class)
    public void testDivisionByZero() {
        double a = 0.53;
        double b = 0;
        Calculator calculator = prepareOperation(a, b, "/");
        Assert.assertTrue("The operator is not set as binary", calculator.isBinaryOperator());
        calculator.calculate();
    }

    @Test
    public void testOneDivideByA() {
        double a = 0.58;
        Calculator calculator = prepareOperation(a, "1/");
        Assert.assertFalse("The operator is set as binary", calculator.isBinaryOperator());
        calculator.calculate();
        Assert.assertEquals("Division 1/a works incorrectly", String.valueOf(1 / a), calculator.getResult());
    }

    @Test(expected = ArithmeticException.class)
    public void testOneDivideByZero() {
        double a = 0;
        Calculator calculator = prepareOperation(a, "1/");
        Assert.assertFalse("The operator is set as binary", calculator.isBinaryOperator());
        calculator.calculate();
        Assert.assertEquals("Division 1/0 works incorrectly", String.valueOf(1 / a), calculator.getResult());
    }

    @Test
    public void testSquare() {
        double a = 0.61;
        Calculator calculator = prepareOperation(a, "^2");
        Assert.assertFalse("The operator is set as binary", calculator.isBinaryOperator());
        calculator.calculate();
        Assert.assertEquals("Square works incorrectly", String.valueOf(a * a), calculator.getResult());
    }

    @Test
    public void testSquareRoot() {
        double a = 4;
        Calculator calculator = prepareOperation(a, "sqrt");
        Assert.assertFalse("The operator is set as binary", calculator.isBinaryOperator());
        calculator.calculate();
        Assert.assertEquals("Square root works incorrectly", "2", calculator.getResult());
    }

    @Test(expected = ArithmeticException.class)
    public void testSquareRootFromNegative() {
        double a = -4;
        Calculator calculator = prepareOperation(a, "sqrt");
        Assert.assertFalse("The operator is set as binary", calculator.isBinaryOperator());
        calculator.calculate();
    }

    @Test
    public void testChangeSign() {
        double a = 4;
        Calculator calculator = prepareOperation(a, "+/-");
        Assert.assertFalse("The operator is set as binary", calculator.isBinaryOperator());
        calculator.calculate();
        Assert.assertEquals("Changing sign works incorrectly", "-4", calculator.getResult());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUnknownOperator() {
        Calculator calculator = new Calculator();
        calculator.setOperator(".");
        calculator.isBinaryOperator();
    }
}
