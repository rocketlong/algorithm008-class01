//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
//
//
//
// 示例 1:
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
//
//
// 示例 2:
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
// Related Topics 数组 动态规划

package leetcode.editor.cn.lesson12.practice;

import java.util.Arrays;

//Java：乘积最大子数组
public class MaximumProductSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumProductSubarray().new Solution();
        // TO TEST
        int[] nums = {-2,3,-4};
        System.out.println(solution.maxProduct(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 方法一
//        public int maxProduct(int[] nums) {
//            int[] min = Arrays.copyOf(nums, nums.length);
//            int[] max = Arrays.copyOf(nums, nums.length);
//            for (int i = 1; i < nums.length; i++) {
//                min[i] = Math.min(min[i - 1] * min[i], Math.min(min[i], max[i - 1] * nums[i]));
//                max[i] = Math.max(max[i - 1] * max[i], Math.max(max[i], min[i - 1] * nums[i]));
//            }
//            return Math.max(Arrays.stream(max).max().getAsInt(), Arrays.stream(min).max().getAsInt());
//        }

        // 方法二: 对方法一的优化
        // 思路: 由于第i个状态只和第i-1状态相关
        public int maxProduct(int[] nums) {
            int max = nums[0], min = nums[0], res = nums[0];
            for (int i = 1; i < nums.length; i++) {
                int mx = max, mn = min;
                max = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
                min = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));
                res = Math.max(res, max);
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}