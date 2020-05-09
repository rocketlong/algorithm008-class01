//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法

package leetcode.editor.cn.lesson7;

import java.util.ArrayList;
import java.util.List;

//Java：括号生成
public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        // TO TEST
        System.out.println(solution.generateParenthesis(3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> ans = new ArrayList<>();
            _generate(ans, "", 0, 0, n);
            return ans;
        }

        private void _generate(List<String> ans, String s, int left, int right, int n) {
            if (s.length() == n * 2) {
                ans.add(s);
                return;
            }
            if (left < n) {
                _generate(ans, s + "(", left + 1, right, n);
            }
            if (right < left) {
                _generate(ans, s + ")", left, right + 1, n);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}