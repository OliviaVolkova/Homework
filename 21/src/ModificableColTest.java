import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModificableColTest extends ModificableCol {
    ModificableCol<Integer> col = new ModificableCol<>();

    @BeforeEach
    void setUp() {
        col.add(0);
        col.add(1);
        col.add(2);
    }

    @Test
    void testIsEmpty() {
        boolean expected = false;
        boolean actual = col.isEmpty();
        Assert.assertTrue(actual == expected);
    }

    @Test
    void testRemove() {
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
}