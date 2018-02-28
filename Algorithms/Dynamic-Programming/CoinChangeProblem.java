import java.util.HashMap;
import java.util.Scanner;

public class CoinChangeProblem {

    private static long getWays(long[] coins, int money, int index, HashMap<String, Long> memo) {
        if (money == 0) {
            return 1;
        }
        if (index >= coins.length) {
            return 0;
        }

        String key = money + "-" + index;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int amountWithCoin = 0;
        long ways = 0;
        while(amountWithCoin <= money) {
            int remaining = money - amountWithCoin;
            ways += getWays(coins, remaining, index + 1, memo);
            amountWithCoin += coins[index];
        }
        memo.put(key, ways);
        return ways;
    }

    private static long getWays(long[] coins, int amount) {
        return getWays(coins, amount,0, new HashMap<>());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long[] c = new long[m];
        for(int index = 0; index < m; index++){
            c[index] = in.nextLong();
        }

        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'
        long ways = getWays(c, n);
        System.out.println(ways);
    }
}
