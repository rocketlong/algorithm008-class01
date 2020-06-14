//班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 
//的朋友。所谓的朋友圈，是指所有朋友的集合。 
//
// 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你
//必须输出所有学生中的已知的朋友圈总数。 
//
// 示例 1: 
//
// 
//输入: 
//[[1,1,0],
// [1,1,0],
// [0,0,1]]
//输出: 2 
//说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
//第2个学生自己在一个朋友圈。所以返回2。
// 
//
// 示例 2: 
//
// 
//输入: 
//[[1,1,0],
// [1,1,1],
// [0,1,1]]
//输出: 1
//说明：已知学生0和学生1互为朋友，学生1和学生2互为朋友，所以学生0和学生2也是朋友，所以他们三个在一个朋友圈，返回1。
// 
//
// 注意： 
//
// 
// N 在[1,200]的范围内。 
// 对于所有学生，有M[i][i] = 1。 
// 如果有M[i][j] = 1，则有M[j][i] = 1。 
// 
// Related Topics 深度优先搜索 并查集

package leetcode.editor.cn.lesson13.demo;

//Java：朋友圈
public class FriendCircles {
    public static void main(String[] args) {
        Solution solution = new FriendCircles().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 方法一:dfs
//        public int findCircleNum(int[][] M) {
//            if (M == null || M.length == 0 || M[0] == null || M[0].length == 0) return 0;
//            boolean[] visited = new boolean[M.length];
//            int count = 0;
//            for (int i = 0; i < M.length; i++) {
//                if (!visited[i]) {
//                    dfs(M, visited, i);
//                    count++;
//                }
//            }
//            return count;
//        }
//
//        private void dfs(int[][] M, boolean[] visited, int i) {
//            for (int j = 0; j < M[0].length; j++) {
//                if (M[i][j] == 1 && !visited[j]) {
//                    visited[j] = true;
//                    dfs(M, visited, j);
//                }
//            }
//        }

        // 方法二:并查集
        public int findCircleNum(int[][] M) {
            if (M == null || M.length == 0 || M[0] == null || M[0].length == 0) return 0;
            int n = M.length;
            UnionFind unionFind = new UnionFind(n);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (M[i][j] == 1) unionFind.union(i, j);
                }
            }
            return unionFind.count;
        }

        class UnionFind {

            private int count;
            private int[] parent;

            public UnionFind(int n) {
                count = n;
                parent = new int[n];
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                }
            }

            public int findParent(int p) {
                int root = p;
                // 找到root
                while (parent[root] != root) {
                    root = parent[root];
                }
                // 路径压缩
                while (parent[p] != p) {
                    int temp = p;
                    p = parent[p];
                    parent[temp] = root;
                }
                return root;
            }

            public void union(int p, int q) {
                int rootP = findParent(p);
                int rootQ = findParent(q);
                if (rootP == rootQ) return;
                parent[rootP] = rootQ;
                count--;
            }

        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}