package ca.algonquin.cst8411.texttoolkit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TextUtilsTest {

    @Test
    void normalizeWhitespaceRemovesExtraSpaces() {
        assertEquals("hello world", TextUtils.normalizeWhitespace("  hello   world  "));
    }

    @Test
    void reverseHandlesNull() {
        assertNull(TextUtils.reverse(null));
    }

    @Test
    void palindromeIgnoresCaseAndPunctuation() {
        assertTrue(TextUtils.isPalindrome("A man, a plan, a canal: Panama!"));
        assertFalse(TextUtils.isPalindrome("Java"));
    }

    @Test
    void titleCaseFormatsWords() {
        assertEquals("Hello World", TextUtils.toTitleCase("hELLO   wORLD"));
    }

    @Test
    void truncateAddsEllipsis() {
        assertEquals("abcdefg...", TextUtils.truncate("abcdefghijkl", 10));
    }

    @Test
    void truncateRejectsNegativeLength() {
        assertThrows(IllegalArgumentException.class, () -> TextUtils.truncate("abc", -1));
    }

    @Test
    void countOccurrencesCanIgnoreCase() {
        assertEquals(3, TextUtils.countOccurrences("Java JAVA java", "java", true));
        assertEquals(1, TextUtils.countOccurrences("Java JAVA java", "Java", false));
    }
}
