//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1: 
//
// 输入:
//11110
//11010
//11000
//00000
//输出: 1
// 
//
// 示例 2: 
//
// 输入:
//11000
//11000
//00100
//00011
//输出: 3
//解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集

package leetcode.editor.cn.lesson9;

//Java：岛屿数量
public class NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new NumberOfIslands().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int n;
        int m;
        public int numIslands(char[][] grid) {
            if (grid == null) return 0;
            n = grid.length;
            if (n == 0) return 0;
            m = grid[0].length;
            int level = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == '1') {
                        dfs(i, j, grid);
                        level++;
                    }
                }
            }
            return level;
        }

        private void dfs(int i, int j, char[][] grid) {
            if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return;
            grid[i][j] = '0';
            dfs(i + 1, j, grid);
            dfs(i, j + 1, grid);
            dfs(i - 1, j, grid);
            dfs(i, j - 1, grid);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}