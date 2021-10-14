import calculator.Calculator;
import calculator.ScientificCalculator;
import org.junit.Assert;
import org.junit.Test;

public class ScientificCalculatorTests extends SimpleCalculatorTests {

    @Override
    protected Calculator prepareOperation(double a, double b, String operator) {
        Calculator calculator = new ScientificCalculator();
        calculator.setA(String.valueOf(a));
        calculator.setB(String.valueOf(b));
        calculator.setOperator(operator);
        return calculator;
    }

    @Override
    protected Calculator prepareOperation(double a, String operator) {
        Calculator calculator = new ScientificCalculator();
        calculator.setA(String.valueOf(a));
        calculator.setOperator(operator);
        return calculator;
    }

    @Test
    public void testPow() {
        double a = 4;
        double b = 3;
        Calculator calculator = prepareOperation(a, b, "^");
        Assert.assertTrue("The operator is not set as binary", calculator.isBinaryOperator());
        calculator.calculate();
        Assert.assertEquals("Pow works incorrectly", String.valueOf(64), calculator.getResult());
    }

    @Test
    public void testMod() {
        double a = 10;
        double b = 8;

        Calculator calculator = prepareOperation(a, b, "%");
        Assert.assertTrue("The operator is not set as binary", calculator.isBinaryOperator());
        calculator.calculate();
        Assert.assertEquals("Mod works incorrectly", String.valueOf(2), calculator.getResult());

        calculator = prepareOperation(a, b, "mod");
        Assert.assertTrue("The operator is not set as binary", calculator.isBinaryOperator());
        calculator.calculate();
        Assert.assertEquals("Mod works incorrectly", String.valueOf(2), calculator.getResult());
    }

    @Test
    public void testExp() {
        double a = 0.12;
        double b = 5;
        Calculator calculator = prepareOperation(a, b, "exp");
        Assert.assertTrue("The operator is not set as binary", calculator.isBinaryOperator());
        calculator.calculate();
        Assert.assertEquals("Exp works incorrectly", String.valueOf(12000), calculator.getResult());
    }

    @Test
    public void testCube() {
        double a = 8;
        Calculator calculator = prepareOperation(a,"^3");
        Assert.assertFalse("The operator is set as binary", calculator.isBinaryOperator());
        calculator.calculate();
        Assert.assertEquals("Cube works incorrectly", String.valueOf(512), calculator.getResult());
    }

    @Test
    public void testCubeRoot() {
        double a = 512;
        Calculator calculator = prepareOperation(a,"cbrt");
        Assert.assertFalse("The operator is set as binary", calculator.isBinaryOperator());
        calculator.calculate();
        Assert.assertEquals("Cube root works incorrectly", String.valueOf(8), calculator.getResult());
    }

    @Test
    public void test2Pow() {
        double a = 4;
        Calculator calculator = prepareOperation(a, "2^");
        Assert.assertFalse("The operator is set as binary", calculator.isBinaryOperator());
        calculator.calculate();
        Assert.assertEquals("2 Pow works incorrectly", String.valueOf(16), calculator.getResult());
    }

    @Test
    public void testEPow() {
        double a = Math.log(9);
        Calculator calculator = prepareOperation(a, "e^");
        Assert.assertFalse("The operator is set as binary", calculator.isBinaryOperator());
        calculator.calculate();
        Assert.assertEquals("E Pow works incorrectly", String.valueOf(9), calculator.getResult());
    }

    @Test
    public void test10Pow() {
        double a = 8;
        Calculator calculator = prepareOperation(a, "10^");
        Assert.assertFalse("The operator is set as binary", calculator.isBinaryOperator());
        calculator.calculate();
        Assert.assertEquals("10 Pow works incorrectly", String.valueOf(100000000), calculator.getResult());
    }

    @Test
    public void testLog() {
        double a = 100000;
        Calculator calculator = prepareOperation(a, "log");
        Assert.assertFalse("The operator is set as binary", calculator.isBinaryOperator());
        calculator.calculate();
        Assert.assertEquals("Log works incorrectly", String.valueOf(5), calculator.getResult());
    }

    @Test
    public void testLn() {
        double a = Math.pow(Math.E, 8);
        Calculator calculator = prepareOperation(a, "ln");
        Assert.assertFalse("The operator is set as binary", calculator.isBinaryOperator());
        calculator.calculate();
        Assert.assertEquals("Ln works incorrectly", String.valueOf(8), calculator.getResult());
    }

    @Test
    public void testAbs() {
        double a = -7;
        Calculator calculator = prepareOperation(a, "abs");
        Assert.assertFalse("The operator is set as binary", calculator.isBinaryOperator());
        calculator.calculate();
        Assert.assertEquals("Abs works incorrectly", String.valueOf(7), calculator.getResult());
    }

    @Test
    public void testFactorial() {
        double a = 8;
        Calculator calculator = prepareOperation(a, "!");
        Assert.assertFalse("The operator is set as binary", calculator.isBinaryOperator());
        calculator.calculate();
        Assert.assertEquals("Factorial works incorrectly", String.valueOf(40320), calculator.getResult());
    }

    @Test
    public void testFactorialOfZero() {
        double a = 0;
        Calculator calculator = prepareOperation(a, "!");
        Assert.assertFalse("The operator is set as binary", calculator.isBinaryOperator());
        calculator.calculate();
        Assert.assertEquals("Factorial works incorrectly", String.valueOf(1), calculator.getResult());
    }

    @Test(expected = ArithmeticException.class)
    public void testFactorialOfNegativeNumber() {
        double a = -6;
        Calculator calculator = prepareOperation(a, "!");
        calculator.calculate();
    }

    @Test
    public void testSin() {
        double a = Math.PI * 3 / 2;
        Calculator calculator = prepareOperation(a, "sin");
        Assert.assertFalse("The operator is set as binary", calculator.isBinaryOperator());
        calculator.calculate();
        Assert.assertEquals("Sin works incorrectly", String.valueOf(-1), calculator.getResult());
    }

    @Test
    public void testCos() {
        double a = Math.PI * 3;
        Calculator calculator = prepareOperation(a, "cos");
        Assert.assertFalse("The operator is set as binary", calculator.isBinaryOperator());
        calculator.calculate();
        Assert.assertEquals("Cos works incorrectly", String.valueOf(-1), calculator.getResult());
    }

    @Test
    public void testTan() {
        double a = Math.PI / 4;
        Calculator calculator = prepareOperation(a, "tan");
        Assert.assertFalse("The operator is set as binary", calculator.isBinaryOperator());
        calculator.calculate();
        Assert.assertEquals("Tan works incorrectly", String.valueOf(1), calculator.getResult());
    }

    @Test(expected = ArithmeticException.class)
    public void testTan90() {
        double a = Math.PI / 2;
        Calculator calculator = prepareOperation(a, "tan");
        calculator.calculate();
    }

    @Test
    public void testAsin() {
        double a = 0;
        Calculator calculator = prepareOperation(a, "asin");
        Assert.assertFalse("The operator is set as binary", calculator.isBinaryOperator());
        calculator.calculate();
        Assert.assertEquals("Asin works incorrectly", String.valueOf(0), calculator.getResult());
    }

    @Test
    public void testAcos() {
        double a = 1;
        Calculator calculator = prepareOperation(a, "acos");
        Assert.assertFalse("The operator is set as binary", calculator.isBinaryOperator());
        calculator.calculate();
        Assert.assertEquals("Acos works incorrectly", String.valueOf(0), calculator.getResult());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUnknownOperator() {
        Calculator calculator = new ScientificCalculator();
        calculator.setOperator(".");
        calculator.isBinaryOperator();
    }
}
