//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。 
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 示例: 
//
// 输入: 4
//输出: [
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
// 
//
// 
//
// 提示： 
//
// 
// 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一或七步
//，可进可退。（引用自 百度百科 - 皇后 ） 
// 
// Related Topics 回溯算法

package leetcode.editor.cn.lesson16.demo;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

//Java：N皇后
public class NQueens {
    public static void main(String[] args) {
        Solution solution = new NQueens().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // dfs
        LinkedHashSet<Integer> cols = new LinkedHashSet<>();
        LinkedHashSet<Integer> pie = new LinkedHashSet<>();
        LinkedHashSet<Integer> na = new LinkedHashSet<>();
        public List<List<String>> solveNQueens(int n) {
            List<List<String>> result = new ArrayList<>();
            dfs(result, n, 0);
            return result;
        }

        private void dfs(List<List<String>> result, int n, int row) {
            if (row == n) {
                printResult(result, n);
                return;
            }
            for (int col = 0; col < n; col++) {
                if (cols.contains(col) || pie.contains(col + row) || na.contains(col - row)) continue;
                cols.add(col);
                pie.add(col + row);
                na.add(col - row);
                dfs(result, n, row + 1);
                cols.remove(col);
                pie.remove(col + row);
                na.remove(col - row);
            }
        }

        private void printResult(List<List<String>> result, int n) {
            List<String> ans = new ArrayList<>();
            for (Integer col : cols) {
                StringBuilder s = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    if (col == i) s.append("Q");
                    else s.append(".");
                }
                ans.add(s.toString());
            }
            result.add(ans);
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}