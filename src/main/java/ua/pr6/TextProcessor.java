package ua.pr6;

public class TextProcessor {

    public String normalize(String text) {
        String lowered = text.toLowerCase();
        String[] words = lowered.split("\\s+");
        StringBuilder normalized = new StringBuilder();

        boolean firstWord = true;

        for(String word : words) {
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

    public String capitalize(String text) {
        String[] words = text.split("\\s+");
        StringBuilder capitalized = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.isEmpty()) continue;
            capitalized.append(word.substring(0, 1).toUpperCase()).append(word.substring(1));
            if(i != words.length - 1) {
                capitalized.append(" ");
            }
        }
        return capitalized.toString();
    }

    public String reverseOrder(String text) {
        String[] words = text.trim().split("\\s+");
        StringBuilder reversed = new StringBuilder();

        boolean firstWord = true;

        for (int i = words.length - 1; i >= 0; i--) {
            String word = words[i];
            if (word.isEmpty()) continue;
            if (!firstWord) {
                reversed.append(" ");
            }
            reversed.append(word);
            firstWord = false;
        }
        return reversed.toString();
    }
}