//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法

package leetcode.editor.cn.lesson8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Java：电话号码的字母组合
public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> letterCombinations(String digits) {
            List<String> ans = new ArrayList<>();
            if (digits == null || digits.length() == 0) return ans;
            Map<Character, String> map = new HashMap<>();
            map.put('2', "abc");
            map.put('3', "def");
            map.put('4', "ghi");
            map.put('5', "jkl");
            map.put('6', "mno");
            map.put('7', "pqrs");
            map.put('8', "tuv");
            map.put('9', "wxyz");
            dfs(map, ans, "", digits, 0);
            return ans;
        }

        private void dfs(Map<Character, String> map, List<String> ans, String s, String digits, int index) {
            if (digits.length() == index) {
                ans.add(s);
                return;
            }
            String s1 = map.get(digits.charAt(index));
            for (int i = 0; i < s1.length(); i++) {
                dfs(map, ans, s + s1.charAt(i), digits, index + 1);
            }
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}