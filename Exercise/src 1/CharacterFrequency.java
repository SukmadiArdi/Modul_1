import java.util.HashMap;

public class CharacterFrequency {
    public static HashMap<Character, Integer> countFrequency(String str) {
        HashMap<Character, Integer> frequencyMap = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        return frequencyMap;
    }

    public static void main(String[] args) {
        String str = "hello world";
        HashMap<Character, Integer> frequencyMap = countFrequency(str);

        for (char c : frequencyMap.keySet()) {
            System.out.println(c + ": " + frequencyMap.get(c));
        }
    }
}
