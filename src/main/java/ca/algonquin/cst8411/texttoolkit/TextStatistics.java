package ca.algonquin.cst8411.texttoolkit;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Provides simple statistics for text content.
 */
public final class TextStatistics {

    private TextStatistics() {
        // Utility class.
    }

    /**
     * Counts words separated by whitespace.
     *
     * @param text input text
     * @return word count, or 0 for null/blank input
     */
    public static int wordCount(String text) {
        if (TextUtils.isBlank(text)) {
            return 0;
        }
        return TextUtils.normalizeWhitespace(text).split(" ").length;
    }

    /**
     * Counts alphabetic characters.
     *
     * @param text input text
     * @return number of alphabetic characters
     */
    public static int letterCount(String text) {
        if (text == null) {
            return 0;
        }
        int count = 0;
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Counts numeric characters.
     *
     * @param text input text
     * @return number of digit characters
     */
    public static int digitCount(String text) {
        if (text == null) {
            return 0;
        }
        int count = 0;
        for (char c : text.toCharArray()) {
            if (Character.isDigit(c)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Builds a case-insensitive word-frequency map. Punctuation is treated as a separator.
     * Insertion order follows the first appearance of each word.
     *
     * @param text input text
     * @return word-frequency map; never null
     */
    public static Map<String, Integer> wordFrequency(String text) {
        Map<String, Integer> frequencies = new LinkedHashMap<>();
        if (TextUtils.isBlank(text)) {
            return frequencies;
        }

        String cleaned = text.toLowerCase(Locale.ROOT)
                .replaceAll("[^\\p{L}\\p{N}]+", " ")
                .trim();
        if (cleaned.isEmpty()) {
            return frequencies;
        }

        for (String word : cleaned.split("\\s+")) {
            frequencies.merge(word, 1, Integer::sum);
        }
        return frequencies;
    }
}
