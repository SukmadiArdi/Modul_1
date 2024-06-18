public class countVowels {
    public static int countVowels(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String str = "hello world";
        System.out.println("Jumlah huruf vokal: " + countVowels(str));
    }
}