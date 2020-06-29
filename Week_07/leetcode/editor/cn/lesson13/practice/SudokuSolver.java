//编写一个程序，通过已填充的空格来解决数独问题。 
//
// 一个数独的解法需遵循如下规则： 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 
// 
//
// 空白格用 '.' 表示。 
//
// 
//
// 一个数独。 
//
// 
//
// 答案被标成红色。 
//
// Note: 
//
// 
// 给定的数独序列只包含数字 1-9 和字符 '.' 。 
// 你可以假设给定的数独只有唯一解。 
// 给定数独永远是 9x9 形式的。 
// 
// Related Topics 哈希表 回溯算法

package leetcode.editor.cn.lesson13.practice;

import java.util.Arrays;

//Java：解数独
public class SudokuSolver {
    public static void main(String[] args) {
        Solution solution = new SudokuSolver().new Solution();
        // TO TEST
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        solution.solveSudoku(board);
        System.out.println(Arrays.deepToString(board));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public void solveSudoku(char[][] board) {
            if (board == null || board.length == 0 || board[0].length == 0) return;
            dfs(board, 0);
        }

        private boolean dfs(char[][] board, int cur) {
            while (cur < 81 && board[cur / 9][cur % 9] != '.') cur++;
            if (cur == 81) return true;
            int i = cur / 9;
            int j = cur % 9;
            for (char c = '1'; c <= '9'; c++) {
                if (isValid(board, i, j, c)) {
                    board[i][j] = c;
                    if (dfs(board, cur + 1)) return true;
                    board[i][j] = '.';
                }
            }
            return false;
        }

        private boolean isValid(char[][] board, int row, int col, char ch) {
            for (int i = 0; i < 9; i++) {
                if (board[i][col] != '.' && board[i][col] == ch) return false;
                if (board[row][i] != '.' && board[row][i] == ch) return false;
                int r = (row / 3) * 3 + i / 3;
                int c = (col / 3) * 3 + i % 3;
                if (board[r][c] != '.' && board[r][c] == ch) return false;
            }
            return true;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}