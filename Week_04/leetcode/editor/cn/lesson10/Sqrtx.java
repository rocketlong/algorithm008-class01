//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找

package leetcode.editor.cn.lesson10;

//Java：x 的平方根
public class Sqrtx {
    public static void main(String[] args) {
        Solution solution = new Sqrtx().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
//        public int mySqrt(int x) {
//            // 1 二分查找 单调递增 上下界 上届x 下届0
//            long left = 0, right = x;
//            while (left <= right) {
//                long mid = left + (right - left) / 2;
//                if (mid * mid > x) {
//                    right = mid - 1;
//                } else {
//                    left = mid + 1;
//                }
//            }
//            return (int) right;
//        }

        public int mySqrt(int x) {
            // 2 牛顿迭代法
            long a = x;
            while (a * a > x) {
                a = (a + x / a) / 2;
            }
            return (int) a;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}