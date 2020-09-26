//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划 
// 👍 2730 👎 0

package leetcode.editor.cn.lesson12.demo;

//Java：最长回文子串
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 1.嵌套循环，枚举i，j（起点和终点）得到全部子串，判断该子串是否会问
        // 2.枚举中心，同时向两边扩张，可看题解 详细通俗的思路分析
        // 3.动态规划 dp[i][j] 分别表示起点和终点

        // 2.枚举中心
//        private int lo, maxLen;
//        public String longestPalindrome(String s) {
//            int len = s.length();
//            if (len < 2) return s;
//            for (int i = 0; i < len - 1; i++) {
//                extendPalindrome(s, i, i); // 奇数长度
//                extendPalindrome(s, i, i + 1); // 偶数长度
//            }
//            return s.substring(lo, lo + maxLen);
//        }
//
//        private void extendPalindrome(String s, int j, int k) {
//            while (j >= 0 && k <s.length() && s.charAt(j) == s.charAt(k)) {
//                j--;
//                k++;
//            }
//            if (maxLen < k - j - 1) {
//                lo = j + 1;
//                maxLen = k - j - 1;
//            }
//        }

        // 3.动态规划
        public String longestPalindrome(String s) {
            int n = s.length();
            String res = "";
            boolean[][] dp = new boolean[n][n];
            for (int i = n - 1; i >= 0 ; i--) {
                for (int j = i; j < n; j++) {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1]);
                    if (dp[i][j] && j - i + 1 > res.length()) {
                        res = s.substring(i, j + 1);
                    }
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}