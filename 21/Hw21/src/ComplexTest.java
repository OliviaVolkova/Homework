import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ComplexTest {
    Complex c1;
    Complex c2;

    @BeforeEach
    void setUp() {
        double real1 = 4;
        double image1 = 1;
        double real2 = 2;
        double image2 = 5;
        c1 = new Complex(real1,image1);
        c2 = new Complex(real2,image2);
    }

    @Test
    void testAddnotNull() {
        Complex expected = new Complex(6,6);
        Complex actual = c1.add(c2);
        Assert.assertEquals((int)expected.getReal(),(int)actual.getReal());
        Assert.assertEquals((int)expected.getImaginary(),(int)actual.getImaginary());
    }

    @Test
    void testSubtractTrue() {
        Complex expected = new Complex(2,-4);
        Complex actual = c1.subtract(c2);
        Assert.assertTrue(expected.getReal() == actual.getReal() && expected.getImaginary() == actual.getImaginary());
    }

    @Test
    void testEquals() {
        Complex c3 = new Complex(4,1);
        boolean expected = true;
        boolean actual = c1.equals(c3);
        Assert.assertTrue(expected == actual);
    }

    @Test
    void testAddNegative() {
        Complex c3 = new Complex(-3,-5);
        Complex expected = new Complex(1,-4);
        Complex actual = c1.add(c3);
        Assert.assertTrue(expected.getReal() == actual.getReal() && expected.getImaginary() == actual.getImaginary());
    }

    @Test
    void testNotEquals() {
        boolean expected = false;
        boolean actual = c1.equals(c2);
        Assert.assertEquals(expected,actual);
    }

    @Test
    void testMultiplyTrue() {
        Complex expected = new Complex(3,22);
        Complex actual = c1.multiply(c2);
        Assert.assertTrue(expected.getReal() == actual.getReal() && expected.getImaginary() == actual.getImaginary());
    }

    @Test
    void testMultiplyFalse() {
        Complex expected = new Complex(1,22);
        Complex actual = c1.multiply(c2);
        Assert.assertFalse(expected.getReal() == actual.getReal() && expected.getImaginary() == actual.getImaginary());
    }

    @Test
    void testDivideTrue() {
        Complex expected = new Complex(0.4482758620689655, - 0.6206896551724138);
        Complex actual = c1.divide(c2);
        Assert.assertTrue(expected.getReal() == actual.getReal() && expected.getImaginary() == actual.getImaginary());
    }

    @Test
    void testDivideFalse() {
        Complex expected = new Complex(0.4, - 0.6);
        Complex actual = c1.divide(c2);
        Assert.assertFalse(expected.getReal() == actual.getReal() && expected.getImaginary() == actual.getImaginary());
    }

    @Test
    void testSubstractFalse() {
        Complex expected = new Complex(3,-5);
        Complex actual = c1.subtract(c2);
        Assert.assertFalse(expected.getReal() == actual.getReal() && expected.getImaginary() == actual.getImaginary());
    }
}
