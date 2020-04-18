//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。 
//
// 示例 1: 
//
// 输入: [1,2,3,4,5,6,7] 和 k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
// 
//
// 示例 2: 
//
// 输入: [-1,-100,3,99] 和 k = 2
//输出: [3,99,-1,-100]
//解释: 
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100] 
//
// 说明: 
//
// 
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。 
// 要求使用空间复杂度为 O(1) 的 原地 算法。 
// 
// Related Topics 数组

package leetcode.editor.cn.lesson3;

//Java：旋转数组
public class RotateArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
//        public void rotate1(int[] nums, int k) {
//            // 暴力法
//            int pre;
//            for (int i = 0; i < k; i++) {
//                pre = nums[nums.length - 1];
//                for (int j = 0; j < nums.length; j++) {
//                    int temp = nums[j];
//                    nums[j] = pre;
//                    pre = temp;
//                }
//            }
//        }

//        public void rotate2(int[] nums, int k) {
//            // 数组复制法
//            int[] a = new int[nums.length];
//            for (int i = 0; i < nums.length; i++) {
//                a[(i + k) % nums.length] = nums[i];
//            }
//            for (int j = 0; j < nums.length; j++) {
//                nums[j] = a[j];
//            }
//        }

        public void rotate(int[] nums, int k) {
            // 反转法
            k %= nums.length;
            reverse(nums, 0, nums.length - 1);
            reverse(nums, 0,  k - 1);
            reverse(nums, k, nums.length - 1);
        }

        private void reverse(int[] nums, int start, int end) {
            while (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}