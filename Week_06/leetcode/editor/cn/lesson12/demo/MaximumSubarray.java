//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4],
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划

package leetcode.editor.cn.lesson12.demo;

import java.util.Arrays;

//Java：最大子序和
public class MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumSubarray().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 1. 暴力：n^2 枚举所有的起点和所有的终点
        // 2. DP:
        //  a. 分治（子问题）max_sum(i) = Max(max_sum(i - 1) + a[i], a[i])
        //  b. 状态数组定义 f[i]
        //  c. DP方程 f[i] = Max(f(i - 1) + a[i], a[i])
        public int maxSubArray(int[] nums) {
            // 这里直接使用nums作为dp
            for (int i = 1; i < nums.length; i++) {
                nums[i] = Math.max(nums[i - 1] + nums[i], nums[i]);
            }
            return Arrays.stream(nums).max().getAsInt();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}