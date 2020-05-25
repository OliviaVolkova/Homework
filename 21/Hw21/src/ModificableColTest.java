import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ModificableColTest extends ModificableCol {
    ModificableCol<Integer> col = new ModificableCol<>();

    @BeforeEach
    void setUp() {
        col.add(0);
        col.add(1);
        col.add(2);
        col.add(5);
    }

    @Test
    void testIsEmptyFalse() {
        boolean expected = false;
        boolean actual = col.isEmpty();
        Assert.assertTrue(actual == expected);
    }

    @Test
    void testRemoveFalse() {
        boolean expected = false;
        boolean actual = col.remove(3);
        Assert.assertTrue(expected == actual);
    }

    @Test
    void testSize() {
        int expected = 3;
        int actual = col.size();
        Assert.assertEquals(expected,actual);
    }

    @Test
    void testHasNext() {
        boolean expected = true;
        boolean actual = col.iterator().hasNext();
        Assert.assertEquals(expected, actual);
    }

    @Test
    void testRemoveTrue() {
        boolean expected = true;
        boolean actual = col.remove(0);
        Assert.assertTrue(expected == actual);

    }

    @Test
    void testSizeFalse() {
        int expected = 10;
        int actual = col.size();
        Assert.assertFalse(actual == expected);
    }

    @Test
    void testAddNull() {
        boolean expected = false;
        boolean actual = col.add(null);
        Assert.assertFalse(expected == actual);

    }

    @Test
    void testSizeAfterClearTrue() {
        int expected = 0;
        col.clear();
        int actual = col.size();
        Assert.assertTrue(expected == actual);
    }


    @Test
    void testAddNegative() {
        boolean expected = true;
        boolean actual = col.add(-6);
        Assert.assertEquals(expected,actual);
    }

    @Test
    void testEqualsTrue() {
        ModificableCol<Integer> col2 = new ModificableCol<>();
        boolean expected = false;
        boolean actual = col.equals(col2);
        Assert.assertEquals(expected,actual);
    }

    @Test
    void testEqualsFalse() {
        ModificableCol<Integer> col2 = new ModificableCol<>();
        boolean expected = true;
        boolean actual = col.equals(col2);
        Assert.assertFalse(expected == actual);
    }

    @Test
    void testHashCodeEqualsTrue() {
        ModificableCol<Integer> col2 = new ModificableCol<>();
        col2.add(0);
        col2.add(1);
        col2.add(2);
        col2.add(5);
        int expected = col2.hashCode();
        int actual = col.hashCode();
        Assert.assertEquals(expected,actual);
    }

    @Test
    void testHashCodeFalse() {
        int expected = 123456778;
        int actual = col.hashCode();
        Assert.assertFalse(expected == actual);
    }

    @Test
    void testHashCodeTrue() {
        int expected = -189258814;
        int actual = col.hashCode();
        Assert.assertEquals(expected,actual);
    }

    @Test
    void testHashCodeEqualsFalse() {
        ModificableCol<Integer> col2 = new ModificableCol<>();
        col2.add(0);
        col2.add(1);
        col2.add(2);
        int expected = col2.hashCode();
        int actual = col.hashCode();
        Assert.assertFalse(expected == actual);
    }

    @Test
    void testIsEmptyTrue() {
        col.clear();
        boolean expected = true;
        boolean actual = col.isEmpty();
        Assert.assertEquals(expected,actual);
    }

    @Test
    void testSizeAfterClearFalse() {
        col.clear();;
        int expected = 3;
        int actual = col.size();
        Assert.assertFalse(expected == actual);

    }

    @Test
    void testAddNotNull() {
        boolean expected = true;
        boolean actual = col.add(6);
        Assert.assertEquals(expected,actual);
    }


}