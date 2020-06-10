//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 
//
// 示例 1: 
//
// 输入: coins = [1, 2, 5], amount = 11
//输出: 3 
//解释: 11 = 5 + 5 + 1 
//
// 示例 2: 
//
// 输入: coins = [2], amount = 3
//输出: -1 
//
// 
//
// 说明: 
//你可以认为每种硬币的数量是无限的。 
// Related Topics 动态规划

package leetcode.editor.cn.lesson12.demo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//Java：零钱兑换
public class CoinChange {
    public static void main(String[] args) {
        Solution solution = new CoinChange().new Solution();
        // TO TEST
        int[] coins = {1, 2, 5};
        System.out.println(solution.coinChange(coins, 100));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 1.暴力：递归dfs
    // 2.bfs
    // 3.dp
    //  a. subProblem
    //  b. dp array
    //  c. dp方程 f(n) = min(f(n - k) for k in [1, 2, 5]) + 1
    class Solution {

        // 暴力：递归dfs
//        public int coinChange(int[] coins, int amount) {
//            return dfs(coins, amount, new int[amount]);
//        }
//
//        private int dfs(int[] coins, int rem, int[] count) {
//            if (rem < 0) return -1;
//            if (rem == 0) return 0;
//            if (count[rem - 1] != 0) return count[rem - 1];
//            int min = Integer.MAX_VALUE;
//            for (int coin : coins) {
//                int res = dfs(coins, rem - coin, count);
//                if (res >= 0 && res < min)
//                    min = res + 1;
//            }
//            count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
//            return count[rem - 1];
//        }

        // dp
        public int coinChange(int[] coins, int amount) {
            int max = amount + 1;
            int[] dp = new int[max];
            Arrays.fill(dp, max);
            dp[0] = 0;
            for (int i = 0; i < max; i++) {
                for (int j = 0; j < coins.length; j++) {
                    if (coins[j] <= i) {
                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                    }
                }
            }
            return dp[amount] > amount ? -1 : dp[amount];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}