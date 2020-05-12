//您需要在二叉树的每一行中找到最大的值。 
//
// 示例： 
//
// 
//输入: 
//
//          1
//         / \
//        3   2
//       / \   \  
//      5   3   9 
//
//输出: [1, 3, 9]
// 
// Related Topics 树 深度优先搜索 广度优先搜索

package leetcode.editor.cn.lesson9;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Java：在每个树行中找最大值
public class FindLargestValueInEachTreeRow {
    public static void main(String[] args) {
        Solution solution = new FindLargestValueInEachTreeRow().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public List<Integer> largestValues(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            if (root == null) return ans;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                int max = Integer.MIN_VALUE;
                for (int i = 0; i < size; i++) {
                    TreeNode next = queue.poll();
                    max = Math.max(next.val, max);
                    if (next.left != null) queue.add(next.left);
                    if (next.right != null) queue.add(next.right);
                }
                ans.add(max);
            }
            return ans;
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}