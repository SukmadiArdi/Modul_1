public class TrueFormatterWord {
    public static void main(String[] args) {
        String a = "aPaKaH AnDa mEnYiMaK sUaRa aNgIn dI mAlAm hArI?";
        System.out.println("Kalimat Awal : " + a);

        // Pisahkan kalimat menjadi kata-kata
        String[] words = a.split(" ");

        // Proses setiap kata
        StringBuilder formattedSentence = new StringBuilder();
        for (String word : words) {
            String firstLetter = word.substring(0, 1).toUpperCase();
            String restOfWord = word.substring(1).toLowerCase();
            formattedSentence.append(firstLetter).append(restOfWord).append(" ");
        }

        // Hapus spasi berlebih di akhir
        String finalSentence = formattedSentence.toString().trim();

        System.out.println("Kalimat Akhir : " + finalSentence);
    }
}
