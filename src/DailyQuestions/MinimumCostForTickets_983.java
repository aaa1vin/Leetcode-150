package DailyQuestions;

import java.util.Arrays;

public class MinimumCostForTickets_983 {
    public static void main(String[] args) {
        int[] days = {1,4,6,7,8,15,18,30};
        int[] costs = {2,7,15};

        int tLen = days[days.length-1];
        boolean[] tDays = new boolean[tLen+1];

        for (int day: days){
            tDays[day] = true;
        }

        int[] dp = new int[tLen+1];
        for (int i=1; i<=tLen ; i++) {
            if (!tDays[i]) {
                // if !true, copy previous amount
                dp[i] = dp[i-1];
            } else {
                // update the best price
                dp[i] = Math.min(
                        dp[i-1] + costs[0],
                        Math.min(
                                dp[Math.max(0,i-7)] + costs[1],
                                dp[Math.max(0,i-30)] + costs[2]));
            }
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(dp[tLen]);
    }
}