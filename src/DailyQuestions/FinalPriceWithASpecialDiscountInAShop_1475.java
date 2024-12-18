package DailyQuestions;

import java.util.Arrays;

public class FinalPriceWithASpecialDiscountInAShop_1475 {
    public static void main(String[] args) {
        int[] prices = {8,7,4,2,8,1,7,7,10,1};

        int idx = 0;
        while (idx < prices.length - 1) {
            int px = prices[idx];
            for (int i=idx+1 ; i<prices.length ; i++) {
                if (px >= prices[i]) {
                    prices[idx] -=prices[i];
                    break;
                }
            }
            idx++;
        }
        System.out.println(Arrays.toString(prices));
    }
}