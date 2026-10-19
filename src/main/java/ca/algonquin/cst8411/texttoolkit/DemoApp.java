package ca.algonquin.cst8411.texttoolkit;

/**
 * Small executable demonstration for the Text Toolkit library.
 */
public final class DemoApp {

    private DemoApp() {
        // Prevent instantiation.
    }

    public static void main(String[] args) {
        String sample = "  Java   libraries are reusable. Java is portable.  ";

        System.out.println("Text Toolkit 1.0.0 Demo");
        System.out.println("Original: " + sample);
        System.out.println("Normalized: " + TextUtils.normalizeWhitespace(sample));
        System.out.println("Title Case: " + TextUtils.toTitleCase(sample));
        System.out.println("Word Count: " + TextStatistics.wordCount(sample));
        System.out.println("'Java' Occurrences: " + TextUtils.countOccurrences(sample, "Java", true));
        System.out.println("Palindrome check ('Never odd or even'): "
                + TextUtils.isPalindrome("Never odd or even"));
        System.out.println("Word Frequency: " + TextStatistics.wordFrequency(sample));
    }
}
