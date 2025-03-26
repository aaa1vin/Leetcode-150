package ArrayString;

public class BestTimeToSellStock_121 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int buyPrice = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            buyPrice = Math.min(buyPrice, prices[i]);
            profit = Math.max(profit, prices[i] - buyPrice);
        }
        return profit;
    }
}
