import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This JUnit class represents a very partial test class for Ex1.
 * Make sure you complete all the needed JUnits
 */
public class Ex1Test {
    @Test
    void computeNumberTest() {
        String s2 = "1011b2";
        int v = Ex1.number2Int(s2);
        assertEquals(v, 11);
        String s10 = "1011bA";
        v = Ex1.number2Int(s10);
        s2 = Ex1.int2Number(v, 2);
        int v2 = Ex1.number2Int(s2);
        assertEquals(v, v2);
        assertTrue(Ex1.equals(s10, s2));
    }

    @Test
    void isBasisNumberTest() {
        String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA"};
        for (int i = 0; i < good.length; i = i + 1) {
            boolean ok = Ex1.isNumber(good[i]);
            assertTrue(ok);
        }
        String[] not_good = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2", "b", " ", "5b", "4b "};
        for (int i = 0; i < not_good.length; i = i + 1) {
            boolean not_ok = Ex1.isNumber(not_good[i]);
            assertFalse(not_ok);
        }
    }

    /**
     * need to make and check
     */
    @Test
    void int2NumberTest() {
        assertEquals("1000b2", Ex1.int2Number(8, 2));
        assertEquals("54", Ex1.int2Number(54, 10));
        assertEquals("2A0bG", Ex1.int2Number(672, 16));
        assertEquals("3b5", Ex1.int2Number(3, 5));
        assertEquals("1186b9", Ex1.int2Number(888, 9));
        assertEquals("CbD", Ex1.int2Number(12, 13));
        assertEquals("1012133b4", Ex1.int2Number(4511, 4));
        assertEquals("0b5", Ex1.int2Number(0, 5));
        assertEquals("98443", Ex1.int2Number(98443, 10));
        assertEquals("", Ex1.int2Number(-8976, 7));
        assertEquals("", Ex1.int2Number(3509, 23));
        assertEquals("", Ex1.int2Number(1, 283));

    }

    @Test
    void equalsTest() {
        assertTrue(Ex1.equals("11b2", "3bA"));
        assertTrue(Ex1.equals("14bA", "EbG"));
        assertTrue(Ex1.equals("123b6", "63b8"));
        assertTrue(Ex1.equals("1100000b2", "341b5"));
        assertTrue(Ex1.equals("29B20bC", "40062bB"));

        assertFalse(Ex1.equals("123bD", "30bA"));
        assertFalse(Ex1.equals("567b ", "12b2"));
        assertFalse(Ex1.equals(" ", " bA"));
        assertFalse(Ex1.equals("542bbbb6", "67"));
        assertFalse(Ex1.equals("35627bG", "null"));
    }


    @Test
    void maxIndexTest() {
        String[] arr1 = {"123b6", "10101b2", "30bA"};
        assertEquals(0, Ex1.maxIndex(arr1));

        String[] arr2 = {"45bD", "8349bE", "124b5"};
        assertEquals(1, Ex1.maxIndex(arr2));

        String[] arr3 = {"-4b5", "37b ", " b2"};
        assertEquals(-1, Ex1.maxIndex(arr3));

        String[] arr4 = {" ", "8bB", "1D3bG"};
        assertEquals(2, Ex1.maxIndex(arr4));

        String[] arr5 = {};
        assertEquals(-1, Ex1.maxIndex(arr5));

        assertEquals(-1, Ex1.maxIndex(null));
    }

    @Test
    void convertBaseStringToNumTest() {
        assertEquals(2, Ex1.convertBaseStringToNum("2"));
        assertEquals(3, Ex1.convertBaseStringToNum("3"));
        assertEquals(4, Ex1.convertBaseStringToNum("4"));
        assertEquals(5, Ex1.convertBaseStringToNum("5"));
        assertEquals(6, Ex1.convertBaseStringToNum("6"));
        assertEquals(7, Ex1.convertBaseStringToNum("7"));
        assertEquals(8, Ex1.convertBaseStringToNum("8"));
        assertEquals(9, Ex1.convertBaseStringToNum("9"));
        assertEquals(10, Ex1.convertBaseStringToNum("A"));
        assertEquals(11, Ex1.convertBaseStringToNum("B"));
        assertEquals(12, Ex1.convertBaseStringToNum("C"));
        assertEquals(13, Ex1.convertBaseStringToNum("D"));
        assertEquals(14, Ex1.convertBaseStringToNum("E"));
        assertEquals(15, Ex1.convertBaseStringToNum("F"));
        assertEquals(16, Ex1.convertBaseStringToNum("G"));
    }

    @Test
    void convertBaseIntToStringTest() {
        assertEquals("2", Ex1.convertBaseIntToString(2));
        assertEquals("3", Ex1.convertBaseIntToString(3));
        assertEquals("4", Ex1.convertBaseIntToString(4));
        assertEquals("5", Ex1.convertBaseIntToString(5));
        assertEquals("6", Ex1.convertBaseIntToString(6));
        assertEquals("7", Ex1.convertBaseIntToString(7));
        assertEquals("8", Ex1.convertBaseIntToString(8));
        assertEquals("9", Ex1.convertBaseIntToString(9));
        assertEquals("A", Ex1.convertBaseIntToString(10));
        assertEquals("B", Ex1.convertBaseIntToString(11));
        assertEquals("C", Ex1.convertBaseIntToString(12));
        assertEquals("D", Ex1.convertBaseIntToString(13));
        assertEquals("E", Ex1.convertBaseIntToString(14));
        assertEquals("F", Ex1.convertBaseIntToString(15));
        assertEquals("G", Ex1.convertBaseIntToString(16));
    }

    @Test
    void checkIfValidBaseTest() {
        int[] good = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        for (int i = 0; i < good.length; i = i + 1) {
            boolean ok = Ex1.checkIfValidBase(good[i]);
            assertTrue(ok);
        }
        int[] not_good = {0, 1, -1, 17, -567, 32, 54, 8890};
        for (int i = 0; i < not_good.length; i = i + 1) {
            boolean not_ok = Ex1.checkIfValidBase(not_good[i]);
            assertFalse(not_ok);
        }
    }

    @Test
    void isValidNumTest() {
        assertTrue(Ex1.isValidNum("11", 2));
        assertTrue(Ex1.isValidNum("14", 10));
        assertTrue(Ex1.isValidNum("D24E", 16));
        assertTrue(Ex1.isValidNum("1100000", 5));
        assertTrue(Ex1.isValidNum("29B20", 14));

        assertFalse(Ex1.isValidNum("123bD", 4));
        assertFalse(Ex1.isValidNum("567 ", 9));
        assertFalse(Ex1.isValidNum(" ", 10));
        assertFalse(Ex1.isValidNum("542bbbb6", 16));
        assertFalse(Ex1.isValidNum("356t7bG", 3));
        assertFalse(Ex1.isValidNum("3Y6tO0", 11));

    }

}