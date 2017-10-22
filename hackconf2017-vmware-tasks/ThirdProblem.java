import java.util.Arrays;

public class ThirdProblem {

    public static void main(String[] args) {
        System.out.println(sumNumbers("abc11b33"));
//        System.out.println(sumNumbers("abc123byx"));
//        System.out.println(sumNumbers("7 11"));
    }


    /**
     * Given a string, return the sum of the numbers appearing in the string,
     * ignoring all other characters.
     * A number is a series of 1 or more digit chars in a row.
     * @param str Given string
     * @return Sum of the numbers
     */
    public static int sumNumbers(String str) {
        str = str.replaceAll("[^0-9]+", " ").trim();
        int sum = Arrays
                .asList(str.split(" "))
                .stream()
                .mapToInt(Integer::parseInt)
                .sum();
        return sum;
    }

    public static int sumNumbersSecondWay(String str) {
        int sum = 0;
        String currentNumber = "";
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                currentNumber += str.charAt(i);
            } else {
                if (!currentNumber.equals("")) {
                    sum += Integer.parseInt(currentNumber);
                    currentNumber = "";
                }
            }
        }

        if (!currentNumber.equals("")) {
            sum += Integer.parseInt(currentNumber);
        }

        return sum;
    }
}
