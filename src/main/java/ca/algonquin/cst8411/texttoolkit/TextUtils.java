package ca.algonquin.cst8411.texttoolkit;

/**
 * Reusable text utility methods for common string operations.
 *
 * <p>This class is not intended to be instantiated.</p>
 */
public final class TextUtils {

    private TextUtils() {
        // Utility class.
    }

    /**
     * Returns true when the supplied text is null, empty, or contains only whitespace.
     *
     * @param text input text
     * @return true when the text is blank
     */
    public static boolean isBlank(String text) {
        return text == null || text.trim().isEmpty();
    }

    /**
     * Removes leading/trailing whitespace and replaces consecutive whitespace with one space.
     * A null input is returned as null.
     *
     * @param text input text
     * @return normalized text, or null when the input is null
     */
    public static String normalizeWhitespace(String text) {
        if (text == null) {
            return null;
        }
        return text.trim().replaceAll("\\s+", " ");
    }

    /**
     * Reverses the supplied text. A null input is returned as null.
     *
     * @param text input text
     * @return reversed text, or null when the input is null
     */
    public static String reverse(String text) {
        if (text == null) {
            return null;
        }
        return new StringBuilder(text).reverse().toString();
    }

    /**
     * Checks whether the supplied text is a palindrome while ignoring case and
     * non-alphanumeric characters.
     *
     * @param text input text
     * @return true when the normalized text is a palindrome; false for null or blank input
     */
    public static boolean isPalindrome(String text) {
        if (isBlank(text)) {
            return false;
        }
        String normalized = text.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        return !normalized.isEmpty() && normalized.equals(reverse(normalized));
    }

    /**
     * Converts the first letter of each whitespace-delimited word to upper case and
     * all remaining letters to lower case.
     *
     * @param text input text
     * @return title-cased text, or null when the input is null
     */
    public static String toTitleCase(String text) {
        if (text == null) {
            return null;
        }
        String normalized = normalizeWhitespace(text);
        if (normalized.isEmpty()) {
            return normalized;
        }

        String[] words = normalized.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (result.length() > 0) {
                result.append(' ');
            }
            result.append(Character.toUpperCase(word.charAt(0)));
            if (word.length() > 1) {
                result.append(word.substring(1).toLowerCase());
            }
        }
        return result.toString();
    }

    /**
     * Truncates text to the requested maximum length. When truncation is required
     * and maxLength is at least 3, the last three characters are replaced by an ellipsis.
     *
     * @param text input text
     * @param maxLength maximum output length; must be zero or greater
     * @return truncated text, or null when the input is null
     * @throws IllegalArgumentException when maxLength is negative
     */
    public static String truncate(String text, int maxLength) {
        if (maxLength < 0) {
            throw new IllegalArgumentException("maxLength must be zero or greater");
        }
        if (text == null || text.length() <= maxLength) {
            return text;
        }
        if (maxLength < 3) {
            return text.substring(0, maxLength);
        }
        return text.substring(0, maxLength - 3) + "...";
    }

    /**
     * Counts non-overlapping occurrences of a substring.
     *
     * @param text text to search
     * @param target substring to count
     * @param ignoreCase true to perform a case-insensitive search
     * @return number of occurrences
     */
    public static int countOccurrences(String text, String target, boolean ignoreCase) {
        if (text == null || target == null || target.isEmpty()) {
            return 0;
        }

        String source = ignoreCase ? text.toLowerCase() : text;
        String search = ignoreCase ? target.toLowerCase() : target;
        int count = 0;
        int index = 0;
        while ((index = source.indexOf(search, index)) >= 0) {
            count++;
            index += search.length();
        }
        return count;
    }
}
