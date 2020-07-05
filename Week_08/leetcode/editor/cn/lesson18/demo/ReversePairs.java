//给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。 
//
// 你需要返回给定数组中的重要翻转对的数量。 
//
// 示例 1: 
//
// 
//输入: [1,3,2,3,1]
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: [2,4,3,5,1]
//输出: 3
// 
//
// 注意: 
//
// 
// 给定数组的长度不会超过50000。 
// 输入数组中的所有数字都在32位整数的表示范围内。 
// 
// Related Topics 排序 树状数组 线段树 二分查找 分治算法

package leetcode.editor.cn.lesson18.demo;

import java.util.Arrays;

//Java：翻转对
public class ReversePairs {
    public static void main(String[] args) {
        Solution solution = new ReversePairs().new Solution();
        // TO TEST
        int[] arr = {2,4,3,5,1};
        System.out.println(solution.reversePairs(arr));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int reversePairs(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            return mergeSort(nums, 0, nums.length - 1);
        }

        private int mergeSort(int[] nums, int left, int right) {
            if (right <= left) return 0;
            int mid = left + ((right - left) >> 1);
            int count = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);
            int[] temp = new int[right - left + 1];
            int i = left, t = left, k = 0;
            for (int j = mid + 1; j <= right; j++, k++) {
                while (i <= mid && nums[i] <= 2 * (long)nums[j]) i++;
                while (t <= mid && nums[t] < nums[j]) temp[k++] = nums[t++];
                temp[k] = nums[j];
                count += mid - i + 1;
            }
            while (t <= mid) temp[k++] = nums[t++];
            System.arraycopy(temp, 0, nums, left, temp.length);
            return count;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}