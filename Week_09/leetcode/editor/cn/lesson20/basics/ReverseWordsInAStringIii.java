//给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。 
//
// 
//
// 示例： 
//
// 输入："Let's take LeetCode contest"
//输出："s'teL ekat edoCteeL tsetnoc"
// 
//
// 
//
// 提示： 
//
// 
// 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。 
// 
// Related Topics 字符串 
// 👍 243 👎 0

package leetcode.editor.cn.lesson20.basics;

import java.util.ArrayList;
import java.util.List;

//Java：反转字符串中的单词 III
public class ReverseWordsInAStringIii {
    public static void main(String[] args) {
        Solution solution = new ReverseWordsInAStringIii().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            String[] wordList = s.split("\\s");
            List<String> res = new ArrayList<>();
            for (String str : wordList) {
                char[] chars = str.toCharArray();
                for (int i = 0, j = chars.length - 1; i <= j; i++, j--) {
                    char temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                }
                res.add(new String(chars));
            }
            return String.join(" ", res);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}