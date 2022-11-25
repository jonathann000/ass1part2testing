import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SetTest {
    Set s;

    public SetTest() {
        s = new Set();
    }

    @BeforeEach
    void setUp() {
        s = new Set();
    }

    @AfterEach
    void tearDown() {
        Set s = new Set();
    }

    @Test
    void toArray() {
        s.insert(1);
        s.insert(2);
        s.insert(3);
        int[] a = s.toArray();
        assertEquals(3, a.length);
        assertEquals(1, a[0]);
        assertEquals(2, a[1]);
        assertEquals(3, a[2]);
    }

    @Test
    void insert() {
        s.insert(1);
        s.insert(2);
        s.insert(3);
        s.insert(0);
        s.insert(2);
        s.insert(-1);
        int[] a = s.toArray();
        assertEquals(5, a.length);
        assertEquals(-1, a[0]);
        assertEquals(0, a[1]);
        assertEquals(1, a[2]);
        assertEquals(2, a[3]);
        assertEquals(3, a[4]);
    }

    @Test
    void member() {
        s.insert(1);
        s.insert(2);
        s.insert(3);
        assertTrue(s.member(1));
        assertTrue(s.member(2));
        assertTrue(s.member(3));
        assertFalse(s.member(0));
        assertFalse(s.member(4));
        assertFalse(s.member(0));
    }

    @Test
    void intersect() {
        s.insert(1);
        s.insert(2);
        s.insert(3);
        s.insert(5);
        Set s2 = new Set();
        s2.insert(2);
        s2.insert(3);
        s2.insert(4);
        s.intersect(s2);
        int[] a = s.toArray();
        assertEquals(2, a.length);
        assertEquals(2, a[0]);
        assertEquals(3, a[1]);
    }


    @Test
    void distinctClosed() {
        s.insert(1);
        s.insert(2);
        s.insert(3);
        assertFalse(s.distinctClosed((a, b) -> a + b));
        assertFalse(s.distinctClosed((a, b) -> a - b));

        Set s2 = new Set();
        s2.insert(1);
        s2.insert(2);
        s2.insert(-1);
        assertFalse(s2.distinctClosed((a, b) -> a + b));
        assertFalse(s2.distinctClosed((a, b) -> a - b));

        Set s3 = new Set();
        s3.insert(0);
        s3.insert(1);
        assertTrue(s3.distinctClosed((a,b) -> a+b));
        assertTrue(s3.distinctClosed((a,b) -> a*b));
        assertFalse(s3.distinctClosed((a,b) -> a-b));

        Set s4 = new Set();
        s4.insert(-1);
        s4.insert(0);
        s4.insert(1);
        assertTrue(s4.distinctClosed((a,b) -> a+b));
        assertFalse(s4.distinctClosed((a,b) -> a-b));

        Set s5 = new Set();
        s5.insert(-5);
        s5.insert(-2);
        s5.insert(-3);
        s5.insert(10);
        assertFalse(s5.distinctClosed((a,b) -> a+b));
        assertFalse(s5.distinctClosed((a,b) -> a-b));

        Set s6 = new Set();
        s6.insert(1);
        assertFalse(s6.distinctClosed((a,b) -> a+b));
        assertFalse(s6.distinctClosed((a,b) -> a-b));
        assertFalse(s6.distinctClosed((a,b) -> a*b));

        Set s7 = new Set();
        assertFalse(s7.distinctClosed((a,b) -> a+b));
        assertFalse(s7.distinctClosed((a,b) -> a-b));

    }




}