//给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。 
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
//
// 
// 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
// 
//
// 示例: 
//
// 输入: [1,2,3,0,2]
//输出: 3 
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
// Related Topics 动态规划 
// 👍 490 👎 0

package leetcode.editor.cn.lesson12.practice;

//Java：最佳买卖股票时机含冷冻期
public class BestTimeToBuyAndSellStockWithCooldown {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockWithCooldown().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // dp
//        public int maxProfit(int[] prices) {
//            if (prices == null || prices.length == 0) return 0;
//            int n = prices.length;
//            int[][] dp = new int[n][2]; // 0-没有持有 1-持有股票
//            dp[0][1] = -prices[0];
//            for (int i = 1; i < n; i++) {
//                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
//                if (i > 1) {
//                    dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
//                } else {
//                    dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
//                }
//            }
//            return dp[n - 1][0];
//        }

        // 优化
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) return 0;
            int n = prices.length;
            int dp_i_0 = 0;
            int dp_i_1 = Integer.MIN_VALUE;
            int dp_pre_0 = 0;
            for (int i = 0; i < n; i++) {
                int temp = dp_i_0;
                dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
                dp_i_1 = Math.max(dp_i_1, dp_pre_0 - prices[i]);
                dp_pre_0 = temp;
            }
            return dp_i_0;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}