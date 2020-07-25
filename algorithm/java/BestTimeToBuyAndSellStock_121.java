import java.util.Arrays;

/**
 * 121. 买卖股票的最佳时机
 */
public class BestTimeToBuyAndSellStock_121 {
    /**
     * 遍历一遍，
     * 如果利润为负，那就从当前那一天买，
     * 因为前面没有比今天更低的价格了。
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;

        int max = 0, buy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - buy;

            if (profit < 0) buy = prices[i];
            else max = Math.max(max, profit);
        }
        return max;
    }
}
