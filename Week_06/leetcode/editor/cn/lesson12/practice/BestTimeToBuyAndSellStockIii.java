//给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。 
//
// 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 示例 1: 
//
// 输入: [3,3,5,0,0,3,1,4]
//输出: 6
//解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
//     随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。 
//
// 示例 2: 
//
// 输入: [1,2,3,4,5]
//输出: 4
//解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。   
//     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。   
//     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
// 
//
// 示例 3: 
//
// 输入: [7,6,4,3,1] 
//输出: 0 
//解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。 
// Related Topics 数组 动态规划

package leetcode.editor.cn.lesson12.practice;

import com.sun.org.apache.regexp.internal.RE;

//Java：买卖股票的最佳时机 III
public class BestTimeToBuyAndSellStockIii {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockIii().new Solution();
        int[] prices = {3,3,5,0,0,3,1,4};
        System.out.println(solution.maxProfit(prices));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
//        public int maxProfit(int[] prices) {
//            if (prices == null || prices.length == 0) return 0;
//            int[][][] dp = new int[prices.length][3][2];
//            dp[0][0][0] = 0;
//            dp[0][1][0] = Integer.MIN_VALUE;
//            dp[0][2][0] = Integer.MIN_VALUE;
//            dp[0][0][1] = -prices[0];
//            dp[0][1][1] = Integer.MIN_VALUE;
//            dp[0][2][1] = Integer.MIN_VALUE;
//            for (int i = 1; i < prices.length; i++) {
//                dp[i][0][0] = dp[i - 1][0][0];
//                dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][0][0] - prices[i]);
//                dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][0][1] + prices[i]);
//                dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][1][0] == Integer.MIN_VALUE ? Integer.MIN_VALUE : dp[i - 1][1][0] - prices[i]);
//                dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][1][1] + prices[i]);
//            }
//            return Math.max(Math.max(dp[prices.length - 1][0][0], dp[prices.length - 1][1][0]), dp[prices.length - 1][2][0]);
//        }

        /**
         * 第j天购买了股票，第i天卖出，那么j=[0...i-1]
         * 那么最高的利润为: prices[i] - prices[j] + dp[j - 1][k - 1] = prices[i] - (prices[j] - dp[j - 1][k - 1])
         * @param prices
         * @return
         */
//        public int maxProfit(int[] prices) {
//            if (prices.length == 0) return 0;
//            int n = prices.length;
//            int[][] dp = new int[n][3];
//            for (int k = 1; k <= 2; k++) {
//                for (int i = 1; i < n; i++) {
//                    int min = prices[0];
//                    for (int j = 1; j <= i; j++) {
//                        min = Math.min(min, prices[j] - dp[j - 1][k - 1]);
//                    }
//                    dp[i][k] = Math.max(dp[i - 1][k], prices[i] - min);
//                }
//            }
//            return dp[n - 1][2];
//        }

        /**
         * 优化
         * @param prices
         * @return
         */
//        public int maxProfit(int[] prices) {
//            if (prices.length == 0) return 0;
//            int n = prices.length;
//            int[][] dp = new int[n][3];
//            for (int k = 1; k <= 2; k++) {
//                int min = prices[0];
//                for (int i = 1; i < n; i++) {
//                    min = Math.min(min, prices[i] - dp[i - 1][k - 1]);
//                    dp[i][k] = Math.max(dp[i - 1][k], prices[i] - min);
//                }
//            }
//            return dp[n - 1][2];
//        }

        /**
         * 每天，我们都以尽可能低的价格购买股票，并以尽可能高的价格出售股票。
         * 对于第二笔交易，我们将第一笔交易的利润整合到第二笔购买的成本中，然后第二笔出售的利润将成为两笔交易的总利润。
         * @param prices
         * @return
         */
        public int maxProfit(int[] prices)  {
            int buy1 = Integer.MAX_VALUE, buy2 = Integer.MAX_VALUE;
            int sell1 = 0, sell2 = 0;
            for (int i = 0; i < prices.length; i++) {
                buy1 = Math.min(buy1, prices[i]);
                sell1 = Math.max(sell1, prices[i] - buy1);
                buy2 = Math.min(buy2, prices[i] - sell1);
                sell2 = Math.max(sell2, prices[i] - buy2);
            }
            return sell2;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}