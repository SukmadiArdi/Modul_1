public class removeDuplicates {
    public static String removeDuplicates(String str) {
        StringBuilder result = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (result.indexOf(String.valueOf(c)) == -1) {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String str = "hello world";
        System.out.println("Original: " + str);
        System.out.println("Without duplicates: " + removeDuplicates(str));
    }
}