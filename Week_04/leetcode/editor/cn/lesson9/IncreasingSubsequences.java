//给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。 
//
// 示例: 
//
// 
//输入: [4, 6, 7, 7]
//输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7
//]] 
//
// 说明: 
//
// 
// 给定数组的长度不会超过15。 
// 数组中的整数范围是 [-100,100]。 
// 给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。 
// 
// Related Topics 深度优先搜索 
// 👍 177 👎 0

package leetcode.editor.cn.lesson9;

import java.util.ArrayList;
import java.util.List;

//Java：递增子序列
public class IncreasingSubsequences {
    public static void main(String[] args) {
        Solution solution = new IncreasingSubsequences().new Solution();
        // TO TEST
        int[] nums = {4, 6, 7, 7};
        System.out.println(solution.findSubsequences(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<Integer>> res = new ArrayList<>();
        public List<List<Integer>> findSubsequences(int[] nums) {
            dfs(nums, 0, Integer.MIN_VALUE, new ArrayList<>());
            return res;
        }

        private void dfs(int[] nums, int level, int last, List<Integer> ans) {
            if (level == nums.length) {
                if (ans.size() > 1) {
                    res.add(new ArrayList<>(ans));
                }
                return;
            }
            if (nums[level] >= last) {
                ans.add(nums[level]);
                dfs(nums, level + 1, nums[level], ans);
                ans.remove(ans.size() - 1);
            }
            if (nums[level] != last) {
                dfs(nums, level + 1, last, ans);
            }
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}