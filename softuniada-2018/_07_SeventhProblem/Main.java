package _07_SeventhProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static Integer[] changes;
    private static Integer maxSpeed;
    private static Integer initialSpeed;
    private static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int c = Integer.parseInt(reader.readLine());
        String[] lineArgs = reader.readLine().split(" ");
        changes = new Integer[c];
        Integer n = c;
        for (int i = 0; i < c; i++) {
            changes[i] = Integer.parseInt(lineArgs[i]);
        }

        initialSpeed = Integer.parseInt(reader.readLine());
        maxSpeed = Integer.parseInt(reader.readLine());

        print01PermutationsUpToLength("", 3);
        if (!flag) {
            System.out.println(-1);
        }
    }

    private static void drive() {
        int speed = initialSpeed;
        for (Integer change : changes) {
            speed += change;
            if (speed <= 0 || speed > maxSpeed) {
                return;
            }
        }

        flag = true;
        System.out.println(speed);
    }

    public static void print01PermutationsUpToLength(String currentString, final int upTo) {
        if (upTo == 0 || flag) {
            for (int j = 0; j < currentString.length(); j++) {
                Character bit = currentString.charAt(j);
                if (bit == '0') {
                    changes[j] = -changes[j];
                }
            }
            drive();
            return;
        }
        print01PermutationsUpToLength(currentString + "0", upTo - 1);
        print01PermutationsUpToLength(currentString + "1", upTo - 1);
    }
}
