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
}
