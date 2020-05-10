//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics 位运算 数组 回溯算法

package leetcode.editor.cn.lesson8;

import java.util.ArrayList;
import java.util.List;

//Java：子集
public class Subsets {
    public static void main(String[] args) {
        Solution solution = new Subsets().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            if (nums.length == 0) {
                return ans;
            }
            dfs(ans, nums, new ArrayList<>(), 0);
            return ans;
        }

        private void dfs(List<List<Integer>> ans, int[] nums, List<Integer> list, int index) {
            if (nums.length == index) {
                ans.add(new ArrayList<>(list));
                return;
            }
            dfs(ans, nums, list, index + 1);
            list.add(nums[index]);
            dfs(ans, nums, list, index + 1);

            list.remove(list.size() - 1);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}