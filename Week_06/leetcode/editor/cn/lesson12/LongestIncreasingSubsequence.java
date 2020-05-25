//给定一个无序的整数数组，找到其中最长上升子序列的长度。 
//
// 示例: 
//
// 输入: [10,9,2,5,3,7,101,18]
//输出: 4 
//解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。 
//
// 说明: 
//
// 
// 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。 
// 你算法的时间复杂度应该为 O(n2) 。 
// 
//
// 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗? 
// Related Topics 二分查找 动态规划

package leetcode.editor.cn.lesson12;

import java.util.Arrays;
import java.util.OptionalInt;

//Java：最长上升子序列
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new LongestIncreasingSubsequence().new Solution();
        // TO TEST
        int[] nums = {10,9,2,5,3,7,101,18,3};
//        int[] nums = {1,3,6,7,9,4,10,5,6};
        System.out.println(solution.lengthOfLIS(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
//        public int lengthOfLIS(int[] nums) {
//            // dp1:时间复杂度 O(N²) 这个动态规划需要考虑之前所有小于nums[i]的情况
//            if (nums.length < 2) return nums.length;
//            int[] dp = new int[nums.length];
//            Arrays.fill(dp, 1);
//            for (int i = 1; i < nums.length; i++) {
//                for (int j = 0; j < i; j++) {
//                    if (nums[i] > nums[j]) {
//                        dp[i] = Math.max(dp[i], dp[j] + 1);
//                    }
//                }
//            }
//            return Arrays.stream(dp).max().getAsInt();
//        }

        public int lengthOfLIS(int[] nums) {
            // dp2:时间复杂度O(N logN)
            if (nums.length < 2) return nums.length;
            int[] tail = new int[nums.length];
            tail[0] = nums[0];
            int end = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > tail[end]) {
                    tail[++end] = nums[i];
                } else {
                    int left = 0;
                    int right = end;
                    while (left <= right) {
                        int mid = left + (right - left) / 2;
                        if (tail[mid] > nums[i]) {
                            right = mid - 1;
                        } else if (tail[mid] < nums[i]) {
                            left = mid + 1;
                        } else {
                            left = mid;
                            break;
                        }
                    }
                    tail[left] = nums[i];
                }
            }
            return ++end;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}