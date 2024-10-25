class Solution {
    public int maxProfit(final int[] prices) {
        int profit = 0;
        int buy = prices[0];
        for (final int price : prices) {
            buy = Math.min(buy, price);
            profit = Math.max(price - buy, profit);
        }
        return profit;
    }
}