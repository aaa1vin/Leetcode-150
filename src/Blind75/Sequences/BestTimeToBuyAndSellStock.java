package Blind75.Sequences;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;
        int buyPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (buyPrice > prices[i]) {
                buyPrice = prices[i];// set the price globally for best time to buy
            }

            profit = Math.max(profit, prices[i] - buyPrice);// compare best time to sell
        }
        return profit;
    }
}