/**
 * 309. 最佳买卖股票时机含冷冻期
 */
public class BestTimeToBuyAndSellStockWithCoolDown_309 {
    /**
     * 动态规划，三种状态
     *
     * 只关注卖出，
     * 那么状态就是可以分为：
     * 1. 卖出（前一天持股）；
     * 2. 不持股；
     * 3. 持股（可以是前一天就持股，或当天买入）。
     * 因为有冷冻期所以才要记录前一天不持股状态。
     *
     * 关键在于哪一天卖出，只要在今天想买入的时候判断一下前一天是不是刚卖出，
     * 即可，所以关键的一天其实是卖出的那一天，而不是卖出的后一天。
     *
     * 因为当天卖出股票实际上也是属于“不持有”的状态，那么第i天如果不持有，
     * 那这个“不持有”就有了两种状态：
     * 1.本来就不持有，指不是因为当天卖出了才不持有的；
     * 2.第i天因为卖出了股票才变得不持有；
     * 而持有股票依旧只有一种状态。
     *
     * 所以对于每一天i，都有可能是三种状态：
     * 0. 不持股且当天没卖出,定义其最大收益 dp[i][0]；
     * 1. 持股,定义其最大收益 dp[i][1]；
     * 2. 不持股且当天卖出了，定义其最大收益dp[i][2]。
     *
     * 初始化：
     * dp[0][0]=0;  //本来就不持有，啥也没干
     * dp[0][1]=-1*prices[0];  //第0天只买入
     * dp[0][2]=0;  //可以理解成第0天买入又卖出，
     * 那么第0天就是“不持股且当天卖出了”这个状态了，
     * 其收益为0，所以初始化为0是合理的
     */
    public int maxProfit(int[] prices) {
        if (prices == null) return 0;
        int len = prices.length;
        if (len <= 1) return 0;

        int[][] dp = new int[len][3];
        dp[0][0] = 0;
        dp[0][1] = -1 * prices[0];
        dp[0][2] = 0;
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = dp[i - 1][1] + prices[i];
        }
        return Math.max(dp[len - 1][0], dp[len - 1][2]);
    }

    /**
     * 记住三个状态，卖、持股和不持股，
     * 跟着感觉写，就能写对
     */
    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int len = prices.length;
        int[][] dp = new int[len][3];
        dp[0][0] = 0;          // 卖
        dp[0][1] = -prices[0]; // 持股
        dp[0][2] = 0;          // 不持股

        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][0], dp[i - 1][2]);
        }
        return Math.max(dp[len - 1][0], dp[len - 1][2]);
    }
}
