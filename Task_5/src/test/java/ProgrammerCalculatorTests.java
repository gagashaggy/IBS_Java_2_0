import calculator.Calculator;
import calculator.ProgrammerCalculator;
import org.junit.Assert;
import org.junit.Test;

public class ProgrammerCalculatorTests {

    private ProgrammerCalculator prepareOperation(int a, int b, String operator) {
        ProgrammerCalculator calculator = new ProgrammerCalculator();
        calculator.setA(String.valueOf(a));
        calculator.setB(String.valueOf(b));
        calculator.setOperator(operator);
        return calculator;
    }

    private ProgrammerCalculator prepareOperation(int a, String operator) {
        ProgrammerCalculator calculator = new ProgrammerCalculator();
        calculator.setA(String.valueOf(a));
        calculator.setOperator(operator);
        return calculator;
    }

    @Test
    public void testSum() {
        int a = 149;
        int b = 492;
        ProgrammerCalculator calculator = prepareOperation(a, b, "+");
        Assert.assertTrue("The operator is not set as binary", calculator.isBinaryOperator());
        calculator.calculate();
        Assert.assertEquals("Sum works incorrectly", String.valueOf(a + b), calculator.getResult());
    }

    @Test
    public void testSumBin() {
        int a = 0b101001011;
        int b = 0b111100101;
        ProgrammerCalculator calculator = prepareOperation(a, b, "+");
        Assert.assertTrue("The operator is not set as binary", calculator.isBinaryOperator());
        calculator.setNumeralSystem("bin");
        calculator.calculate();
        Assert.assertEquals("Binary sum works incorrectly", String.valueOf(1100110000), calculator.getResult());
    }

    @Test
    public void testSumOct() {
        int a = 0745;
        int b = 0216;
        ProgrammerCalculator calculator = prepareOperation(a, b, "+");
        Assert.assertTrue("The operator is not set as binary", calculator.isBinaryOperator());
        calculator.setNumeralSystem("oct");
        calculator.calculate();
        Assert.assertEquals("Octal sum works incorrectly", String.valueOf(1163), calculator.getResult());
    }

    @Test
    public void testSumHex() {
        int a = 0x15C;
        int b = 0xCD;
        ProgrammerCalculator calculator = prepareOperation(a, b, "+");
        Assert.assertTrue("The operator is not set as binary", calculator.isBinaryOperator());
        calculator.setNumeralSystem("hex");
        calculator.calculate();
        Assert.assertEquals("Hex sum works incorrectly", String.valueOf(229), calculator.getResult());
    }

    @Test
    public void testSubtraction() {
        int a = 110;
        int b = 234;
        ProgrammerCalculator calculator = prepareOperation(a, b, "-");
        Assert.assertTrue("The operator is not set as binary", calculator.isBinaryOperator());
        calculator.calculate();
        Assert.assertEquals("Subtraction works incorrectly", String.valueOf(a - b), calculator.getResult());
    }

    @Test
    public void testSubtractionBin() {
        int a = 0b100000001;
        int b = 0b1010111;
        ProgrammerCalculator calculator = prepareOperation(a, b, "-");
        Assert.assertTrue("The operator is not set as binary", calculator.isBinaryOperator());
        calculator.setNumeralSystem("bin");
        calculator.calculate();
        Assert.assertEquals("Binary subtraction works incorrectly", String.valueOf(10101010), calculator.getResult());
    }

    @Test
    public void testSubtractionOct() {
        int a = 0710;
        int b = 0663;
        ProgrammerCalculator calculator = prepareOperation(a, b, "-");
        Assert.assertTrue("The operator is not set as binary", calculator.isBinaryOperator());
        calculator.setNumeralSystem("oct");
        calculator.calculate();
        Assert.assertEquals("Octal subtraction works incorrectly", String.valueOf(25), calculator.getResult());
    }

    @Test
    public void testSubtractionHex() {
        int a = 0x2C8;
        int b = 0xD0;
        ProgrammerCalculator calculator = prepareOperation(a, b, "-");
        Assert.assertTrue("The operator is not set as binary", calculator.isBinaryOperator());
        calculator.setNumeralSystem("hex");
        calculator.calculate();
        Assert.assertEquals("Hex subtraction works incorrectly", "1F8", calculator.getResult());
    }

    @Test
    public void testMultiply() {
        int a = 229;
        int b = 46;
        ProgrammerCalculator calculator = prepareOperation(a, b, "*");
        Assert.assertTrue("The operator is not set as binary", calculator.isBinaryOperator());
        calculator.calculate();
        Assert.assertEquals("Multiply works incorrectly", String.valueOf(a * b), calculator.getResult());
    }

    @Test
    public void testMultiplyBin() {
        int a = 0b110;
        int b = 0b10010;
        ProgrammerCalculator calculator = prepareOperation(a, b, "*");
        Assert.assertTrue("The operator is not set as binary", calculator.isBinaryOperator());
        calculator.setNumeralSystem("bin");
        calculator.calculate();
        Assert.assertEquals("Binary multiply works incorrectly", String.valueOf(1101100), calculator.getResult());
    }

    @Test
    public void testMultiplyOct() {
        int a = 015;
        int b = 014;
        ProgrammerCalculator calculator = prepareOperation(a, b, "*");
        Assert.assertTrue("The operator is not set as binary", calculator.isBinaryOperator());
        calculator.calculate();
        calculator.setNumeralSystem("oct");
        Assert.assertEquals("Octal multiply works incorrectly", String.valueOf(234), calculator.getResult());
    }

    @Test
    public void testMultiplyHex() {
        int a = 2;
        int b = 7;
        ProgrammerCalculator calculator = prepareOperation(a, b, "*");
        Assert.assertTrue("The operator is not set as binary", calculator.isBinaryOperator());
        calculator.calculate();
        calculator.setNumeralSystem("hex");
        Assert.assertEquals("Hex multiply works incorrectly", "E", calculator.getResult());
    }

    @Test
    public void testDivision() {
        int a = 717;
        int b = 418;
        ProgrammerCalculator calculator = prepareOperation(a, b, "/");
        Assert.assertTrue("The operator is not set as binary", calculator.isBinaryOperator());
        calculator.calculate();
        Assert.assertEquals("Division works incorrectly", String.valueOf(a / b), calculator.getResult());
    }

    @Test
    public void testDivisionBin() {
        int a = 0b10000;
        int b = 0b1110;
        ProgrammerCalculator calculator = prepareOperation(a, b, "/");
        Assert.assertTrue("The operator is not set as binary", calculator.isBinaryOperator());
        calculator.setNumeralSystem("bin");
        calculator.calculate();
        Assert.assertEquals("Binary division works incorrectly", String.valueOf(1), calculator.getResult());
    }

    @Test
    public void testDivisionOct() {
        int a = 024;
        int b = 012;
        ProgrammerCalculator calculator = prepareOperation(a, b, "/");
        Assert.assertTrue("The operator is not set as binary", calculator.isBinaryOperator());
        calculator.setNumeralSystem("oct");
        calculator.calculate();
        Assert.assertEquals("Octal division works incorrectly", String.valueOf(2), calculator.getResult());
    }

    @Test
    public void testDivisionHex() {
        int a = 0x12;
        int b = 0x4;
        ProgrammerCalculator calculator = prepareOperation(a, b, "/");
        Assert.assertTrue("The operator is not set as binary", calculator.isBinaryOperator());
        calculator.setNumeralSystem("hex");
        calculator.calculate();
        Assert.assertEquals("Hex division works incorrectly", String.valueOf(4), calculator.getResult());
    }

    @Test(expected = ArithmeticException.class)
    public void testDivisionByZero() {
        int a = 682;
        int b = 0;
        ProgrammerCalculator calculator = prepareOperation(a, b, "/");
        Assert.assertTrue("The operator is not set as binary", calculator.isBinaryOperator());
        calculator.calculate();
    }

    @Test
    public void testAnd() {
        int a = 0b110;
        int b = 0b1100;
        ProgrammerCalculator calculator = prepareOperation(a, b, "and");

        Assert.assertTrue("The operator is not set as binary", calculator.isBinaryOperator());
        calculator.setNumeralSystem("bin");
        calculator.calculate();
        Assert.assertEquals("And works incorrectly", String.valueOf(100), calculator.getResult());

        calculator = prepareOperation(a, b, "&");
        Assert.assertTrue("The operator is not set as binary", calculator.isBinaryOperator());
        calculator.setNumeralSystem("bin");
        calculator.calculate();
        Assert.assertEquals("And works incorrectly", String.valueOf(100), calculator.getResult());
    }

    @Test
    public void testOr() {
        int a = 0b110;
        int b = 0b10100;
        ProgrammerCalculator calculator = prepareOperation(a, b, "or");

        Assert.assertTrue("The operator is not set as binary", calculator.isBinaryOperator());
        calculator.setNumeralSystem("bin");
        calculator.calculate();
        Assert.assertEquals("Or works incorrectly", String.valueOf(10110), calculator.getResult());

        calculator = prepareOperation(a, b, "|");
        Assert.assertTrue("The operator is not set as binary", calculator.isBinaryOperator());
        calculator.setNumeralSystem("bin");
        calculator.calculate();
        Assert.assertEquals("Or works incorrectly", String.valueOf(10110), calculator.getResult());
    }

    @Test
    public void testNot() {
        int a = 0b10011;
        ProgrammerCalculator calculator = prepareOperation(a, "not");

        Assert.assertFalse("The operator is set as binary", calculator.isBinaryOperator());
        calculator.setNumeralSystem("bin");
        calculator.calculate();
        Assert.assertEquals("Not works incorrectly", Integer.toBinaryString(0b11111111111111111111111111101100), calculator.getResult());

        calculator = prepareOperation(a, "~");
        Assert.assertFalse("The operator is set as binary", calculator.isBinaryOperator());
        calculator.setNumeralSystem("bin");
        calculator.calculate();
        Assert.assertEquals("Not works incorrectly", Integer.toBinaryString(0b11111111111111111111111111101100), calculator.getResult());
    }

    @Test
    public void testNand() {
        int a = 0b1111;
        int b = 0b1011;
        ProgrammerCalculator calculator = prepareOperation(a, b, "nand");
        Assert.assertTrue("The operator is not set as binary", calculator.isBinaryOperator());
        calculator.setNumeralSystem("bin");
        calculator.calculate();
        Assert.assertEquals("Nand works incorrectly", Integer.toBinaryString(0b11111111111111111111111111110100), calculator.getResult());
    }

    @Test
    public void testNor() {
        int a = 0b11;
        int b = 0b1111;
        ProgrammerCalculator calculator = prepareOperation(a, b, "nor");
        Assert.assertTrue("The operator is not set as binary", calculator.isBinaryOperator());
        calculator.setNumeralSystem("bin");
        calculator.calculate();
        Assert.assertEquals("Nor works incorrectly", Integer.toBinaryString(0b11111111111111111111111111110000), calculator.getResult());
    }

    @Test
    public void testXor() {
        int a = 0b11;
        int b = 0b110;
        ProgrammerCalculator calculator = prepareOperation(a, b, "xor");
        Assert.assertTrue("The operator is not set as binary", calculator.isBinaryOperator());
        calculator.setNumeralSystem("bin");
        calculator.calculate();
        Assert.assertEquals("Xor works incorrectly", String.valueOf(101), calculator.getResult());
    }

    @Test
    public void testConvertDecToBin() {
        int a = 16;
        ProgrammerCalculator calculator = prepareOperation(a, "bin");
        Assert.assertFalse("The operator is set as binary", calculator.isBinaryOperator());
        calculator.calculate();
        Assert.assertEquals("Convert Dec to Bin works incorrectly", String.valueOf(10000), calculator.getResult());
    }

    @Test
    public void testConvertDecToOct() {
        int a = 11;
        ProgrammerCalculator calculator = prepareOperation(a, "oct");
        Assert.assertFalse("The operator is set as binary", calculator.isBinaryOperator());
        calculator.calculate();
        Assert.assertEquals("Convert Dec to Oct works incorrectly", String.valueOf(13), calculator.getResult());
    }

    @Test
    public void testConvertDecToHex() {
        int a = 16;
        ProgrammerCalculator calculator = prepareOperation(a, "hex");
        Assert.assertFalse("The operator is set as binary", calculator.isBinaryOperator());
        calculator.calculate();
        Assert.assertEquals("Convert Dec to Hex works incorrectly", String.valueOf(10), calculator.getResult());
    }

    @Test
    public void testConvertBinToDec() {
        int a = 0b1100;
        ProgrammerCalculator calculator = prepareOperation(a, "dec");
        Assert.assertFalse("The operator is set as binary", calculator.isBinaryOperator());
        calculator.calculate();
        calculator.setNumeralSystem("bin");
        Assert.assertEquals("Convert Bin to Dec works incorrectly", String.valueOf(12), calculator.getResult());
    }

    @Test
    public void testConvertBinToOct() {
        int a = 0b10001;
        ProgrammerCalculator calculator = prepareOperation(a, "oct");
        Assert.assertFalse("The operator is set as binary", calculator.isBinaryOperator());
        calculator.calculate();
        calculator.setNumeralSystem("bin");
        Assert.assertEquals("Convert Bin to Oct works incorrectly", String.valueOf(21), calculator.getResult());
    }

    @Test
    public void testConvertBinToHex() {
        int a = 0b10011;
        ProgrammerCalculator calculator = prepareOperation(a, "hex");
        Assert.assertFalse("The operator is set as binary", calculator.isBinaryOperator());
        calculator.calculate();
        calculator.setNumeralSystem("bin");
        Assert.assertEquals("Convert Bin to Hex works incorrectly", String.valueOf(13), calculator.getResult());
    }

    @Test
    public void testConvertOctToBin() {
        int a = 015;
        ProgrammerCalculator calculator = prepareOperation(a, "bin");
        Assert.assertFalse("The operator is set as binary", calculator.isBinaryOperator());
        calculator.calculate();
        calculator.setNumeralSystem("oct");
        Assert.assertEquals("Convert Oct to Bin works incorrectly", String.valueOf(1101), calculator.getResult());
    }

    @Test
    public void testConvertOctToDec() {
        int a = 023;
        ProgrammerCalculator calculator = prepareOperation(a, "dec");
        Assert.assertFalse("The operator is set as binary", calculator.isBinaryOperator());
        calculator.calculate();
        calculator.setNumeralSystem("oct");
        Assert.assertEquals("Convert Oct to Dec works incorrectly", String.valueOf(19), calculator.getResult());
    }

    @Test
    public void testConvertOctToHex() {
        int a = 012;
        ProgrammerCalculator calculator = prepareOperation(a, "hex");
        Assert.assertFalse("The operator is set as binary", calculator.isBinaryOperator());
        calculator.calculate();
        calculator.setNumeralSystem("oct");
        Assert.assertEquals("Convert Oct to Hex works incorrectly", "A", calculator.getResult());
    }

    @Test
    public void testConvertHexToBin() {
        int a = 0xD;
        ProgrammerCalculator calculator = prepareOperation(a, "bin");
        Assert.assertFalse("The operator is set as binary", calculator.isBinaryOperator());
        calculator.calculate();
        calculator.setNumeralSystem("hex");
        Assert.assertEquals("Convert Oct to Bin works incorrectly", String.valueOf(1101), calculator.getResult());
    }

    @Test
    public void testConvertHexToOct() {
        int a = 0x10;
        ProgrammerCalculator calculator = prepareOperation(a, "oct");
        Assert.assertFalse("The operator is set as binary", calculator.isBinaryOperator());
        calculator.calculate();
        calculator.setNumeralSystem("hex");
        Assert.assertEquals("Convert Oct to Dec works incorrectly", String.valueOf(20), calculator.getResult());
    }

    @Test
    public void testConvertHexToDec() {
        int a = 0x13;
        ProgrammerCalculator calculator = prepareOperation(a, "dec");
        Assert.assertFalse("The operator is set as binary", calculator.isBinaryOperator());
        calculator.calculate();
        calculator.setNumeralSystem("hex");
        Assert.assertEquals("Convert Oct to Hex works incorrectly", String.valueOf(19), calculator.getResult());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUnknownOperator() {
        Calculator calculator = new ProgrammerCalculator();
        calculator.setOperator(".");
        calculator.isBinaryOperator();
    }
}
