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
    void testAdd() {
        Complex expected = new Complex(6,6);
        Complex actual = c1.add(c2);
        Assert.assertEquals((int)expected.getReal(),(int)actual.getReal());
        Assert.assertEquals((int)expected.getImaginary(),(int)actual.getImaginary());
    }

    @Test
    void testSubtract() {
        Complex expected = new Complex(2,-4);
        Complex actual = c1.subtract(c2);
        Assert.assertEquals((int)expected.getReal(),(int)actual.getReal());
        Assert.assertEquals((int)expected.getImaginary(),(int)actual.getImaginary());
    }

    @Test
    void testEquals() {
        boolean expected = false;
        boolean actual = c1.equals(c2);
        Assert.assertEquals(expected,actual);
    }
}
