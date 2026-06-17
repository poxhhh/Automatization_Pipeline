/**
 * Word processing package.
 */
package ua.pr6;

/**
 * Class for processing text: normalization, capitalization, and reversing words.
 */
public class TextProcessor {

    /**
     * Normalizes text by removing extra symbols and extra spaces.
     * @param text input text
     * @return normalized text
     */
    public String normalize(final String text) {
        String lowered = text.toLowerCase();
        String[] words = lowered.split("\\s+");
        StringBuilder normalized = new StringBuilder();

        boolean firstWord = true;

        for (String word : words) {
            word = word.replaceAll("[^a-zA-Z']", "");
            word = word.replaceAll("^'+", "");
            word = word.replaceAll("'+$", "");

            if (!word.isEmpty()) {
                if (!firstWord) {
                    normalized.append(" ");
                }
                normalized.append(word);
                firstWord = false;
            }
        }
        return normalized.toString();
    }

    /**
     * Capitalizes the first letter of each word.
     * @param text input text
     * @return text with capitalized words
     */
    public String capitalize(final String text) {
        String[] words = text.split("\\s+");
        StringBuilder capitalized = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.isEmpty()) {
                continue;
            }
            capitalized.append(word.substring(0, 1).toUpperCase())
                    .append(word.substring(1));
            if (i != words.length - 1) {
                capitalized.append(" ");
            }
        }
        return capitalized.toString();
    }

    /**
     * Reverses the order of words in the text.
     * @param text input text
     * @return text with reversed word order
     */
    public String reverseOrder(final String text) {
        String[] words = text.trim().split("\\s+");
        StringBuilder reversed = new StringBuilder();

        boolean firstWord = true;

        for (int i = words.length - 1; i >= 0; i--) {
            String word = words[i];
            if (word.isEmpty()) {
                continue;
            }
            if (!firstWord) {
                reversed.append(" ");
            }
            reversed.append(word);
            firstWord = false;
        }
        return reversed.toString();
    }
}
