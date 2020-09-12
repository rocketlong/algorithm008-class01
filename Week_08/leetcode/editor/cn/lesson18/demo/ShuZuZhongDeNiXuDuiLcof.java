//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。 
//
// 
//
// 示例 1: 
//
// 输入: [7,5,6,4]
//输出: 5 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
// 👍 232 👎 0

package leetcode.editor.cn.lesson18.demo;

import java.util.Arrays;

//Java：数组中的逆序对
public class ShuZuZhongDeNiXuDuiLcof {
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongDeNiXuDuiLcof().new Solution();
        // TO TEST
        System.out.println(solution.reversePairs(new int[]{1, 2, 1, 2, 1}));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int num = 0;

        public int reversePairs(int[] nums) {
            mergeSort(nums, 0, nums.length - 1);
            System.out.println(Arrays.toString(nums));
            return num;
        }

        private void mergeSort(int[] nums, int left, int right) {
            if (right <= left) return;
            int mid = left + ((right - left) >> 1);
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }

        private void merge(int[] nums, int left, int mid, int right) {
            int[] temp = new int[right - left + 1];
            int i = left, j = mid + 1, k = 0;
            while (i <= mid && j <= right) {
                if (nums[i] <= nums[j]) {
                    temp[k++] = nums[i++];
                } else {
                    // 这里计算逆序对
                    num += mid - i + 1;
                    temp[k++] = nums[j++];
                }
            }
            while (i <= mid) temp[k++] = nums[i++];
            while (j <= right) temp[k++] = nums[j++];
            for (int l = 0; l < temp.length; l++) {
                nums[left + l] = temp[l];
            }
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}