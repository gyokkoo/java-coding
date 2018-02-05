package _03_SumTimeIntervals;

import java.util.Scanner;

public class SumTimeIntervals {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstDate = scanner.nextLine().split(":+");
        String[] secondDate = scanner.nextLine().split(":+");

        long totalMinutes = getTotalMinutes(firstDate);
        totalMinutes += getTotalMinutes(secondDate);

        long days = totalMinutes / 1440;
        long hours = (totalMinutes - days * 1440) / 60;
        long minutes = totalMinutes % 60;
        if (days == 0) {
            System.out.printf("%s:%s%n", hours, minutes < 10 ? "0" + minutes : minutes);
        } else {
            System.out.printf("%s::%s:%s%n", days, hours, minutes < 10 ? "0" + minutes : minutes);
        }
    }

    private static long getTotalMinutes(String[] firstDate) {
        long totalMinutes = 0;
        if (firstDate.length == 2) {
            long hours = Long.parseLong(firstDate[0]);
            long minutes = Long.parseLong(firstDate[1]);
            totalMinutes += 60 * hours + minutes;
        } else {
            long days = Long.parseLong(firstDate[0]);
            long hours = Long.parseLong(firstDate[1]);
            long minutes = Long.parseLong(firstDate[2]);
            totalMinutes += 1440 * days + 60 * hours + minutes;
        }
        return totalMinutes;
    }
}
