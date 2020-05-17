//给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。 
//
// 说明：不要使用任何内置的库函数，如 sqrt。 
//
// 示例 1： 
//
// 输入：16
//输出：True 
//
// 示例 2： 
//
// 输入：14
//输出：False
// 
// Related Topics 数学 二分查找

package leetcode.editor.cn.lesson10;

//Java：有效的完全平方数
public class ValidPerfectSquare {
    public static void main(String[] args) {
        Solution solution = new ValidPerfectSquare().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
//        public boolean isPerfectSquare(int num) {
//            long left = 0, right = num;
//            while (left <= right) {
//                long mid = left + (right - left) / 2;
//                if (mid * mid > num) {
//                    right = mid - 1;
//                } else {
//                    left = left + 1;
//                }
//            }
//            return (int) (right * right) == num;
//        }

        public boolean isPerfectSquare(int num) {
            // 牛顿迭代法
            long x = num;
            while (x * x > num) {
                x = (x + num / x) / 2;
            }
            return (int) (x * x) == num;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}