//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表

package leetcode.editor.cn.lesson3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Java：两数之和
public class TwoSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
//        public int[] twoSum(int[] nums, int target) {
//            for (int i = 0; i < nums.length - 1; i++) {
//                for (int j = i + 1; j < nums.length; j++) {
//                    if (nums[i] + nums[j] == target) {
//                        return new int[]{i, j};
//                    }
//                }
//            }
//            return null;
//        }

        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int temp = target - nums[i];
                if (map.containsKey(temp)) {
                    return new int[]{map.get(temp), i};
                }
                map.put(nums[i], i);
            }
            return null;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}