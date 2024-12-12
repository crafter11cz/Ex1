package assignments.ex1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Ex1Test {

    @Test
    void computeNumberTest() {
        String s2 = "1011b2";
        int v = Ex1.number2Int(s2);
        assertEquals(11, v); // 1011b2 is 11 in decimal

        String s10 = "1011bA";
        v = Ex1.number2Int(s10);

        // Convert back to base 2 string
        s2 = Ex1.int2Number(v, 2);

        // Convert it back to decimal
        int v2 = Ex1.number2Int(s2);
        assertEquals(v, v2); // Ensure that we got back the same value

        assertTrue(Ex1.equals(s10, s2)); // Check if both numbers are equal
    }

    @Test
    void isBasisNumberTest() {
        String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA"};
        for (int i = 0; i < good.length; i++) {
            boolean ok = Ex1.isNumber(good[i]);
            assertTrue(ok);
        }

        String[] notGood = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"};
        for (int i = 0; i < notGood.length; i++) {
            boolean notOk = Ex1.isNumber(notGood[i]);
            assertFalse(notOk);
        }
    }

    @Test
    void int2NumberTest() {
        // Valid number to base conversion tests
        assertEquals("1011", Ex1.int2Number(11, 2)); // 11 in decimal = 1011 in binary
        assertEquals("A", Ex1.int2Number(10, 16)); // 10 in decimal = A in hexadecimal
        assertEquals("101", Ex1.int2Number(5, 2)); // 5 in decimal = 101 in binary

        // Invalid tests
        assertEquals("", Ex1.int2Number(-5, 2)); // Negative number should return empty string
        assertEquals("", Ex1.int2Number(5, 17)); // Base 17 is out of the allowed range
        assertEquals("", Ex1.int2Number(5, 1)); // Base 1 is out of the allowed range
    }

    @Test
    void maxIndexTest() {
        String[] arr1 = {"1b2", "1011b2", "123bA", "11bA"};
        // Test case with valid numbers and expected index of the largest number
        assertEquals(2, Ex1.maxIndex(arr1)); // "123bA" is the largest number, corresponding to decimal 83

        String[] arr2 = {"1b2", "0bA", "1b2"};
        // Test case with equal numbers, should return the first one with max value (i.e., the first "1b2")
        assertEquals(0, Ex1.maxIndex(arr2));

        // Test case where all numbers are invalid (resulting in -1 values)
        String[] arr3 = {"!@b2", "abB", "1bb2"};
        assertEquals(0, Ex1.maxIndex(arr3)); // The result should be 0 because all numbers are invalid and -1
    }

    // Additional tests to further cover edge cases and various inputs
    @Test
    void edgeCasesTest() {
        // Test empty or invalid inputs
        assertFalse(Ex1.isNumber(null)); // null should return false
        assertFalse(Ex1.isNumber("")); // Empty string should return false

        // Test numbers with leading zeros
        assertTrue(Ex1.isNumber("01b2")); // Leading zero is allowed
        assertEquals(1, Ex1.number2Int("01b2")); // "01b2" should be valid and return decimal 1

        // Base 16 valid input
        assertTrue(Ex1.isNumber("A2b16")); // "A2b16" should be valid
        assertEquals(162, Ex1.number2Int("A2b16")); // "A2b16" should convert to decimal 162

        // Test large numbers
        assertEquals("1000000000", Ex1.int2Number(1000000000, 2)); // Large decimal number in binary
        assertEquals("3B9ACA00", Ex1.int2Number(1000000000, 16)); // Large decimal number in hexadecimal
    }
}
