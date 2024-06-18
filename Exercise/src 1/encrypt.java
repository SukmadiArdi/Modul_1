public class encrypt {
    public static String encrypt(String plainText, int shift) {
        StringBuilder cipherText = new StringBuilder();
        for (char c : plainText.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                cipherText.append((char) ((c - base + shift) % 26 + base));
            } else {
                cipherText.append(c);
            }
        }
        return cipherText.toString();
    }

    public static void main(String[] args) {
        String plainText = "hello";
        int shift = 3;
        String cipherText = encrypt(plainText, shift);
        System.out.println("Plain text: " + plainText);
        System.out.println("Cipher text: " + cipherText);
    }
}