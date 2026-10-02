class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        int minStock = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; ++i) {
            if (minStock < prices[i]) {
                result = Math.max(prices[i] - minStock, result);
            } else if (minStock > prices[i]) {
                minStock = prices[i];
            }
        }
        return result;
    }
}
