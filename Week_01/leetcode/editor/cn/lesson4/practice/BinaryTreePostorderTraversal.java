//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树

package leetcode.editor.cn.lesson4.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//Java：二叉树的后序遍历
public class BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePostorderTraversal().new Solution();
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
        public List<Integer> postorderTraversal(TreeNode root) {
            // 法一: 容易记忆
            List<Integer> ans = new ArrayList<>();
            if (root == null) return ans;
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (node != null) {
                    stack.push(node);
                    stack.push(null);
                    if (node.right != null) stack.push(node.right);
                    if (node.left != null) stack.push(node.left);
                } else {
                    ans.add(stack.pop().val);
                }
            }
            return ans;
        }

//        public List<Integer> postorderTraversal(TreeNode root) {
//            // 法二: 速度与法一差不多，运用了LinkedList
//            LinkedList<Integer> ans = new LinkedList<>();
//            if (root == null) return ans;
//            Stack<TreeNode> stack = new Stack<>();
//            stack.push(root);
//            while (!stack.isEmpty()) {
//                TreeNode node = stack.pop();
//                ans.addFirst(node.val);
//                if (node.left != null) stack.push(node.left);
//                if (node.right != null) stack.push(node.right);
//            }
//            return ans;
//        }
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