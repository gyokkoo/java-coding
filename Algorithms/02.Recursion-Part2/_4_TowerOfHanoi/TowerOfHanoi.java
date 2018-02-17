package _4_TowerOfHanoi;

import java.util.Scanner;
import java.util.Stack;

public class TowerOfHanoi {

    private static int steps = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfDisks = Integer.parseInt(scanner.nextLine());
        Stack<Integer> source = new Stack<>();
        Stack<Integer> destination = new Stack<>();
        Stack<Integer> spare = new Stack<>();

        for (int i = numberOfDisks; i >= 1; i--) {
            source.add(i);
        }

        print(source, destination, spare);
        moveDisks(numberOfDisks, source, destination, spare);
    }

    private static void moveDisks(int bottom,
                                  Stack<Integer> source,
                                  Stack<Integer> destination,
                                  Stack<Integer> spare) {
        if (bottom == 1) {
            steps++;
            destination.push(source.pop());
            System.out.printf("Step #%d: Moved disk%n", steps);
            print(source, destination, spare);
        } else {
            moveDisks(bottom - 1, source, spare, destination);
            steps++;
            destination.push(source.pop());
            System.out.printf("Step #%d: Moved disk%n", steps);
            print(source, spare, destination);
            moveDisks(bottom - 1, spare, destination, source);
        }
    }

    private static void print(Stack<Integer> source, Stack<Integer> destination, Stack<Integer> spare) {
        System.out.println("Source: " + source.toString().replaceAll("[\\[\\]]", ""));
        System.out.println("Destination: " + destination.toString().replaceAll("[\\[\\]]", ""));
        System.out.println("Spare: " + spare.toString().replaceAll("[\\[\\]]", ""));
        System.out.println();
    }
}
