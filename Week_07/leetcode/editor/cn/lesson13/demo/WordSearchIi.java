//给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
// 
//
// 示例: 
//
// 输入: 
//words = ["oath","pea","eat","rain"] and board =
//[
//  ['o','a','a','n'],
//  ['e','t','a','e'],
//  ['i','h','k','r'],
//  ['i','f','l','v']
//]
//
//输出: ["eat","oath"] 
//
// 说明: 
//你可以假设所有输入都由小写字母 a-z 组成。 
//
// 提示: 
//
// 
// 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？ 
// 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何
//实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。 
// 
// Related Topics 字典树 回溯算法

package leetcode.editor.cn.lesson13.demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Java：单词搜索 II
public class WordSearchIi {
    public static void main(String[] args) {
        Solution solution = new WordSearchIi().new Solution();
        // TO TEST
        String[] words = {"oath", "pea", "eat", "rain"};
        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        System.out.println(solution.findWords(board, words));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int m;
        int n;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        public List<String> findWords(char[][] board, String[] words) {
            if (board == null || board[0].length == 0 || words == null || words.length == 0) return new ArrayList<>();
            Set<String> result = new HashSet<>();
            Trie trie = new Trie();
            for (String word : words) {
                trie.insert(word);
            }
            m = board.length;
            n = board[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    dfs(board, i, j, "", trie, result);
                }
            }
            return new ArrayList<>(result);
        }

        private void dfs(char[][] board, int i, int j, String s, Trie trie, Set<String> result) {
            if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] == '@') return;
            String word = s + board[i][j];
            TrieNode node = trie.searchPrefix(word);
            if (node != null) {
                if (node.isEnd()) {
                    result.add(word);
                }
                char tem = board[i][j];
                board[i][j] = '@';
                for (int k = 0; k < 4; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];
                    dfs(board, x, y, word, trie, result);
                }
                board[i][j] = tem;
            }
        }
    }

    class Trie {

        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char curr = word.charAt(i);
                if (!node.containsKey(curr)) {
                    node.put(curr, new TrieNode());
                }
                node = node.get(curr);
            }
            node.setEnd();
        }

        public TrieNode searchPrefix(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char curr = word.charAt(i);
                if (node.containsKey(curr)) {
                    node = node.get(curr);
                } else {
                    return null;
                }
            }
            return node;
        }

    }

    class TrieNode {

        private TrieNode[] links;

        private final int R = 26;

        private boolean isEnd = false;

        public TrieNode() {
            links = new TrieNode[R];
        }

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public void put(char ch, TrieNode trieNode) {
            links[ch - 'a'] = trieNode;
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
}