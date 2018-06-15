package ransomNote;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    private static boolean checkMagazine(String[] magazine, String[] note) {
        HashMap<String, Integer> magazineFreq = getStringFrequency(magazine);
        HashMap<String, Integer> noteFreq = getStringFrequency(note);

        for (Map.Entry<String, Integer> entry : noteFreq.entrySet()) {
            String word = entry.getKey();
            if (!magazineFreq.containsKey(word) || magazineFreq.get(word) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    private static HashMap<String, Integer> getStringFrequency(String[] str) {
        HashMap<String, Integer> frequencies = new HashMap<>();
        for (String word : str) {
            if (!frequencies.containsKey(word)) {
                frequencies.put(word, 0);
            }

            frequencies.put(word, frequencies.get(word) + 1);
        }

        return frequencies;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        boolean result = checkMagazine(magazine, note);
        System.out.println(result ? "Yes" : "No");

        scanner.close();
    }
}
