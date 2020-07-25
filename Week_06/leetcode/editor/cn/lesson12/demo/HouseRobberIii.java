//在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“
//房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。 
//
// 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。 
//
// 示例 1: 
//
// 输入: [3,2,3,null,3,null,1]
//
//     3
//    / \
//   2   3
//    \   \ 
//     3   1
//
//输出: 7 
//解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7. 
//
// 示例 2: 
//
// 输入: [3,4,5,1,3,null,1]
//
//     3
//    / \
//   4   5
//  / \   \ 
// 1   3   1
//
//输出: 9
//解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
// 
// Related Topics 树 深度优先搜索 
// 👍 434 👎 0

package leetcode.editor.cn.lesson12.demo;

import java.util.HashMap;
import java.util.Map;

//Java：打家劫舍 III
public class HouseRobberIii {
    public static void main(String[] args) {
        Solution solution = new HouseRobberIii().new Solution();
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

        // 递归
//        public int rob(TreeNode root) {
//            if (root == null) return 0;
//            int money = root.val;
//            if (root.left != null) money += rob(root.left.left) + rob(root.left.right);
//            if (root.right != null) money += rob(root.right.left) + rob(root.right.right);
//            return Math.max(money, rob(root.left) + rob(root.right));
//        }

        // 记忆化递归
//        public int rob(TreeNode root) {
//            Map<TreeNode, Integer> map = new HashMap<>();
//            return recursive(root, map);
//        }
//
//        private int recursive(TreeNode root, Map<TreeNode, Integer> map) {
//            if (root == null) return 0;
//            if (map.containsKey(root)) return map.get(root);
//            int money = root.val;
//            if (root.left != null) money += recursive(root.left.left, map) + recursive(root.left.right, map);
//            if (root.right != null) money += recursive(root.right.left, map) + recursive(root.right.right, map);
//            int result = Math.max(money, recursive(root.left, map) + recursive(root.right, map));
//            map.put(root, result);
//            return result;
//        }

        // dp
        public int rob(TreeNode root) {
            // 1.偷当前节点 = 不偷左儿子最大能偷的钱 + 不偷右儿子最大能偷的钱 + 当前节点的钱
            // 2.不偷当前节点 = 偷左儿子最大能偷的钱 + 偷右儿子最大能偷的钱
            int[] result = recursive(root);
            return Math.max(result[0], result[1]);
        }

        private int[] recursive(TreeNode root) {
            if (root == null) return new int[2];
            int[] result = new int[2];
            int[] left = recursive(root.left);
            int[] right = recursive(root.right);
            result[1] = left[0] + right[0] + root.val;
            result[0] = Math.max(left[1], left[0]) + Math.max(right[1], right[0]);
            return result;
        }

    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}