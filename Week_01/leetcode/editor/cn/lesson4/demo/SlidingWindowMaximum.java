//给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。 
//
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 进阶： 
//
// 你能在线性时间复杂度内解决此题吗？ 
//
// 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10^5 
// -10^4 <= nums[i] <= 10^4 
// 1 <= k <= nums.length 
// 
// Related Topics 堆 Sliding Window

package leetcode.editor.cn.lesson4.demo;

import java.util.Arrays;
import java.util.LinkedList;

//Java：滑动窗口最大值
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        int[] array = {1,-1};
//        int[] array = {1,3,-1,-3,5,3,6,7};
//        int[] array = {3,-1,-1,-3};
        System.out.println(Arrays.toString(solution.maxSlidingWindow(array, 1)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
//        public int[] maxSlidingWindow(int[] nums, int k) {
//            // 1 暴力
//            int[] result = new int[nums.length - k + 1];
//            for (int i = 0; i < nums.length - k + 1; i++) {
//                int max = Integer.MIN_VALUE;
//                for (int j = 0; j < k; j++) {
//                    max = Math.max(nums[i + j], max);
//                }
//                result[i] = max;
//            }
//            return result;
//        }

        public int[] maxSlidingWindow(int[] nums, int k) {
            // 2 单调队列 注：队列维护的数组下标
            LinkedList<Integer> list = new LinkedList<>();
            int[] result = new int[nums.length - k + 1];
            for (int i = 0; i < k - 1; i++) {
                while (!list.isEmpty() && nums[i] > nums[list.peekLast()]) {
                    list.pollLast();
                }
                list.offerLast(i);
            }
            for (int i = k - 1; i < nums.length; i++) {
                if (!list.isEmpty() && list.peekFirst() <= i - k) {
                    list.pollFirst();
                }
                while (!list.isEmpty() && nums[i] > nums[list.peekLast()]) {
                    list.pollLast();
                }
                list.offerLast(i);
                result[i - k + 1] = nums[list.peekFirst()];
            }
            return result;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}