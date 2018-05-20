package stringMakingAnagrams;

import java.util.Scanner;

public class Solution {

    private static int LETTERS_COUNT = 26;

    private static int numberNeeded(String first, String second) {
        int[] charCount1 = getCharCounts(first);
        int[] charCount2 = getCharCounts(second);
        return getDelta(charCount1, charCount2);
    }

    private static int getDelta(int[] firstArr, int[] secondArr) {
        if (firstArr.length != secondArr.length) {
            throw new IllegalArgumentException("Arrays length must be equal");
        }
        int delta = 0;
        for (int i = 0; i < firstArr.length; i++) {
            int difference = Math.abs(firstArr[i] - secondArr[i]);
            delta += difference;
        }

        return delta;
    }

    private static int[] getCharCounts(String str) {
        int[] charCounts = new int[LETTERS_COUNT];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int code = c - (int) 'a';
            charCounts[code]++;
        }
        return charCounts;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String first = scanner.nextLine();
        String second = scanner.nextLine();

        try {
            int count = numberNeeded(first, second);
            System.out.println(count);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }
}
