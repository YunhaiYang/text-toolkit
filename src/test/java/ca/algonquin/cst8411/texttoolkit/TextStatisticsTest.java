package ca.algonquin.cst8411.texttoolkit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;
import org.junit.jupiter.api.Test;

class TextStatisticsTest {

    @Test
    void wordCountHandlesWhitespace() {
        assertEquals(3, TextStatistics.wordCount(" one   two\nthree "));
        assertEquals(0, TextStatistics.wordCount("   "));
    }

    @Test
    void letterAndDigitCountWork() {
        assertEquals(3, TextStatistics.letterCount("abc-123"));
        assertEquals(3, TextStatistics.digitCount("abc-123"));
    }

    @Test
    void wordFrequencyIsCaseInsensitive() {
        Map<String, Integer> result = TextStatistics.wordFrequency("Java java JAR");
        assertEquals(2, result.get("java"));
        assertEquals(1, result.get("jar"));
    }
}
