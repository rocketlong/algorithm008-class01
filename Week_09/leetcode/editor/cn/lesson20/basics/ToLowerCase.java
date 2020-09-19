//实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入: "Hello"
//输出: "hello" 
//
// 示例 2： 
//
// 
//输入: "here"
//输出: "here" 
//
// 示例 3： 
//
// 
//输入: "LOVELY"
//输出: "lovely"
// 
// Related Topics 字符串 
// 👍 131 👎 0

package leetcode.editor.cn.lesson20.basics;

//Java：转换成小写字母
public class ToLowerCase {
    public static void main(String[] args) {
        Solution solution = new ToLowerCase().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String toLowerCase(String str) {
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] >= 58 && chars[i] <= 90) {
                    chars[i] = (char) (chars[i] + 32);
                }
            }
            return new String(chars);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}