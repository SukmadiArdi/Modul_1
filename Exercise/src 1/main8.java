public class main8 {
    public static String uppercaseFirstLetter(String sentence) {
        String[] words = sentence.split("\\s+");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(word.substring(0, 1).toUpperCase() + word.substring(1) + " ");
        }
        return result.toString().trim();
    }

    public static void main(String[] args) {
        String sentence = "this is a sample sentence";
        System.out.println("Original: " + sentence);
        System.out.println("With first letter uppercase: " + uppercaseFirstLetter(sentence));
    }
}