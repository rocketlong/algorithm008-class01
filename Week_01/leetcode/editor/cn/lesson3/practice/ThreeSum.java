//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针

package leetcode.editor.cn.lesson3.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：三数之和
public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        // TO TEST
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(solution.threeSum(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            if (nums == null || nums.length == 0) return ans;
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 2; i++) {
                if ((i > 0 && nums[i] == nums[i - 1]) || nums[i] > 0) continue;
                for (int head = i + 1, tail = nums.length - 1; head < tail; ) {
                    if (nums[i] + nums[head] + nums[tail] > 0) {
                        tail--;
                    } else if (nums[i] + nums[head] + nums[tail] < 0) {
                        head++;
                    } else {
                        while (head < tail && nums[head] == nums[head + 1]) head++;
                        while (head < tail && nums[tail] == nums[tail - 1]) tail--;
                        ans.add(Arrays.asList(nums[i], nums[head], nums[tail]));
                        head++;
                        tail--;
                    }
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}