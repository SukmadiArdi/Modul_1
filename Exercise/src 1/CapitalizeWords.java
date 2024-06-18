public class CapitalizeWords {
    public static String capitalize(String sentence) {
        String[] words = sentence.split(" ");
        String capitalizedSentence = "";

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            capitalizedSentence += Character.toUpperCase(word.charAt(0)) + word.substring(1) + " ";
        }
        return capitalizedSentence.trim();
    }

    public static void main(String[] args) {
        String sentence = "the quick brown fox jumps over the lazy dog";
        System.out.println("Capitalized sentence: " + capitalize(sentence));
    }
}
