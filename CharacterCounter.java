public class CharacterCounter {
    public static void main(String[] args) {
        String inputString = "programming";
        countCharacterOccurrences(inputString);
    }

    public static void countCharacterOccurrences(String str) {
        int[] frequency = new int[26];

        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) {
                int index = c - 'a';
                frequency[index]++;
            }
        }

        for (char c = 'a'; c <= 'z'; c++) {
            int index = c - 'a';
            if (frequency[index] > 0) {
                System.out.println(c + ": " + frequency[index] + " occurrences");
            }
        }
    }
}
