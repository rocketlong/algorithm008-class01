//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。 
//
// 注意： 
//
// 答案中不可以包含重复的四元组。 
//
// 示例： 
//
// 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//
//满足要求的四元组集合为：
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
// 
// Related Topics 数组 哈希表 双指针

package leetcode.editor.cn.lesson3.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：四数之和
public class FourSum {
    public static void main(String[] args) {
        Solution solution = new FourSum().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            if (nums == null || nums.length < 4) return ans;
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 2; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                for (int h = i + 1; h < nums.length - 1; h++) {
                    if (i != h - 1 && nums[h] == nums[h - 1]) continue;
                    for (int head = h + 1, tail = nums.length - 1; head < tail; ) {
                        if (nums[i] + nums[h] + nums[head] + nums[tail] > target) {
                            tail--;
                        } else if (nums[i] + nums[h] + nums[head] + nums[tail] < target) {
                            head++;
                        } else {
                            while (head < tail && nums[head] == nums[head + 1]) head++;
                            while (head < tail && nums[tail] == nums[tail - 1]) tail--;
                            ans.add(Arrays.asList(nums[i], nums[h], nums[head], nums[tail]));
                            head++;
                            tail--;
                        }
                    }
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}