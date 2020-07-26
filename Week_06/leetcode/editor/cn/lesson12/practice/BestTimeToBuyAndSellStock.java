//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。 
//
// 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。 
//
// 注意：你不能在买入股票前卖出股票。 
//
// 
//
// 示例 1: 
//
// 输入: [7,1,5,3,6,4]
//输出: 5
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
// 
//
// 示例 2: 
//
// 输入: [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
// 
// Related Topics 数组 动态规划

package leetcode.editor.cn.lesson12.practice;

//Java：买卖股票的最佳时机
public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStock().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 方法一：dp（不是套路）
//        public int maxProfit(int[] prices) {
//            if (prices == null || prices.length == 0 || prices.length == 1) return 0;
//            int[] dp = new int[prices.length];
//            int minPrince = prices[0];
//            for (int i = 1; i < prices.length; i++) {
//                dp[i] = Math.max(dp[i - 1], prices[i] - minPrince);
//                minPrince = Math.min(minPrince, prices[i]);
//            }
//            return dp[prices.length - 1];
//        }

        // 方法二：dp（套路dp）
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) return 0;
            int m = prices.length;
            int[][] dp = new int[m][2];
            for (int i = 0; i < m; i++) {
                /**
                 * dp[-1][0] = 0; // 没开始，没有持有股票，收益是0
                 * dp[-1][1] = Integer.MIN_VALUE; // 没开始，持有股票，不可能，收益负无穷
                 */
                if (i - 1 == -1) {
                    // dp[0][0] = Math.max(dp[-1][0], dp[-1][1] + prices[i]);
                    dp[i][0] = 0;
                    // dp[0][1] = Math.max(dp[-1][1], dp[-1][0] - prices[i]);
                    dp[i][1] = -prices[i];
                    continue;
                }
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                /**
                 * 为什么不是 (dp[i - 1][0] - prices[i]) 而是 -prices[i]
                 *
                 * 动态转移方程：i-天数 k-买入次数 0-没有持有股票 1-持有股票
                 * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
                 * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
                 *
                 * k = 1 则 dp[i-1][k-1][0] = 0
                 * 化简后的动态转移方程：
                 * dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
                 * dp[i][1] = max(dp[i-1][1], -prices[i])
                 */
                dp[i][1] = Math.max(dp[i - 1][1],  -prices[i]);
            }
            return dp[m - 1][0];
        }

        // 方法三：对方法二的优化 空间复杂度变为O(1)
//        public int maxProfit(int[] prices) {
//            if (prices == null || prices.length == 0) return 0;
//            int n = prices.length;
//            int dp_i_0 = 0;
//            int dp_i_1 = Integer.MIN_VALUE;
//            for (int i = 0; i < n; i++) {
//                dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
//                dp_i_1 = Math.max(dp_i_1,  -prices[i]);
//            }
//            return dp_i_0;
//        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}