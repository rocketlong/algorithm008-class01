//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回 n 皇后不同的解决方案的数量。 
//
// 示例: 
//
// 输入: 4
//输出: 2
//解释: 4 皇后问题存在如下两个不同的解法。
//[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
// 
//
// 
//
// 提示： 
//
// 
// 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一或 N
//-1 步，可进可退。（引用自 百度百科 - 皇后 ） 
// 
// Related Topics 回溯算法 
// 👍 140 👎 0

package leetcode.editor.cn.lesson16.demo;

//Java：N皇后 II
public class NQueensIi {
    public static void main(String[] args) {
        Solution solution = new NQueensIi().new Solution();
        // TO TEST
//        solution.totalNQueens(4);
        System.out.println(1 & -1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // dsf
//        Set<Integer> cols = new HashSet<>();
//        Set<Integer> pie = new HashSet<>();
//        Set<Integer> na = new HashSet<>();
//        int count = 0;
//        public int totalNQueens(int n) {
//            dfs(n, 0);
//            return count;
//        }
//
//        private void dfs(int n, int row) {
//            if (n == row) {
//                count++;
//                return;
//            }
//            for (int col = 0; col < n; col++) {
//                if (cols.contains(col) || pie.contains(col + row) || na.contains(col - row)) continue;
//                cols.add(col);
//                pie.add(col + row);
//                na.add(col - row);
//                dfs(n, row + 1);
//                cols.remove(col);
//                pie.remove(col + row);
//                na.remove(col - row);
//            }
//        }

        // 位运算
        int count = 0;
        public int totalNQueens(int n) {
            dfs(n, 0, 0, 0, 0);
            return count;
        }

        private void dfs(int n, int row, int cols, int pie, int na) {
            if (n == row) {
                count++;
                return;
            }
            int bits = (~(cols | pie | na)) & ((1 << n) - 1); // 被攻击的位置置为0，没有被攻击置为1
            while (bits != 0) {
                int p = bits & -bits; // 去最低位的1
                bits = bits & (bits - 1); // 在p位置放入皇后
                dfs(n, row + 1, cols | p, (pie | p) << 1, (na | p) >> 1);
            }
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}