public class CountWords {
    public static int countWords(String sentence) {
        String[] words = sentence.split("\\s+");
        return words.length;
    }

    public static void main(String[] args) {
        String sentence = "This is a sample sentence";
        System.out.println("Jumlah kata: " + countWords(sentence));
    }
}