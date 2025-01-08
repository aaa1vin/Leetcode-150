package DailyQuestions;

import java.util.HashMap;
import java.util.Map;

public class CountWaysToBuildGoodStrings_2466 {
    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        int low = 2;
        int high = 3;
        int zero = 1;
        int one = 2;

        Map<Integer, Integer> memo = new HashMap<>();
        System.out.println(dfs(0, low, high, zero, one, memo));
    }

    private static int dfs(int currLen, int low, int high, int zero, int one, Map<Integer, Integer> memo) {
        if (memo.containsKey(currLen)) {
            return memo.get(currLen);
        }

        if (currLen > high) {
            return 0;
        }

        int count = (currLen >= low && currLen <= high) ? 1 : 0;

        count = (count + dfs(currLen + zero, low, high, zero, one, memo)) % MOD;
        count = (count + dfs(currLen + one, low, high, zero, one, memo)) % MOD;

        memo.put(currLen, count);
        return count;
    }
}
