public class countCharFrequency {
    public static void countCharFrequency(String str) {
        int[] frequency = new int[256]; // 256 adalah jumlah karakter ASCII
        for (char c : str.toCharArray()) {
            frequency[c]++;
        }
        for (int i = 0; i < 256; i++) {
            if (frequency[i] > 0) {
                System.out.println("Karakter '" + (char) i + "' muncul " + frequency[i] + " kali");
            }
        }
    }

    public static void main(String[] args) {
        String str = "hello world";
        countCharFrequency(str);
    }
}