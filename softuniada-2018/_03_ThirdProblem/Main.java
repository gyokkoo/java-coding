package _03_ThirdProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());
        int firstNumber = (number / 1000) * 10+ number / 10 % 10 ;
        int secondNumber = (number / 100) % 10 * 10 + number % 10;
        int roof = firstNumber + secondNumber;
        int startElement = firstNumber * 100 + secondNumber;


        List<Integer> twelves = new ArrayList<>();
        List<Integer> fiftheens = new ArrayList<>();
        for (int i = startElement; i <= 9999; i++) {
            int firstHalf = i / 100;
            String x_str = Integer.toString(i);
            int secondHalf = Integer.parseInt(x_str.substring(2));
            if ((firstHalf >= firstNumber &&
                secondHalf >= secondNumber)|| roof >= 99 ) {
                if (firstHalf <= roof && secondHalf <= roof) {
                    if (i % 12 == 0) {
                        twelves.add(i);
                    }
                    if (i % 15 == 0) {
                        fiftheens.add(i);
                    }
                }
            }
        }


        System.out.print("Dividing on 12: ");
        for (Integer num : twelves) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.print("Dividing on 15: ");
        for (Integer num : fiftheens) {
            System.out.print(num + " ");
        }

        System.out.println();
        if (twelves.size() == fiftheens.size()) {
            System.out.println("!!!BINGO!!!");
        } else {
            System.out.println("NO BINGO!");
        }
    }
}
