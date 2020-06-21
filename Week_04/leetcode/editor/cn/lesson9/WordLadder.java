//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
// 
//
// 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典中的单词。 
// 
//
// 说明: 
//
// 
// 如果不存在这样的转换序列，返回 0。 
// 所有单词具有相同的长度。 
// 所有单词只由小写字母组成。 
// 字典中不存在重复的单词。 
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。 
// 
//
// 示例 1: 
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出: 5
//
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//     返回它的长度 5。
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: 0
//
//解释: endWord "cog" 不在字典中，所以无法进行转换。 
// Related Topics 广度优先搜索

package leetcode.editor.cn.lesson9;

import java.util.*;

//Java：单词接龙
public class WordLadder {
    public static void main(String[] args) {
        Solution solution = new WordLadder().new Solution();
        // TO TEST
        System.out.println(solution.ladderLength("hit", "cog", new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"))));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 单项bfs
//        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//            if (wordList == null || wordList.size() == 0 || !wordList.contains(endWord)) return 0;
//            Set<String> wordSet = new HashSet<>(wordList);
//            Queue<String> queue = new LinkedList<>();
//            queue.add(beginWord);
//            wordSet.remove(beginWord);
//            int level = 1;
//            while (!queue.isEmpty()) {
//                int size = queue.size();
//                for (int i = 0; i < size; i++) {
//                    String next = queue.poll();
//                    if (endWord.equals(next)) {
//                        return level;
//                    }
//                    char[] chars = next.toCharArray();
//                    for (int j = 0; j < chars.length; j++) {
//                        char old = chars[j];
//                        for (char c = 'a'; c <= 'z'; c++) {
//                            chars[j] = c;
//                            String temp = new String(chars);
//                            if (wordSet.contains(temp)) {
//                                queue.add(temp);
//                                wordSet.remove(temp);
//                            }
//                        }
//                        chars[j] = old;
//                    }
//                }
//                level++;
//            }
//            return 0;
//        }

        // 双向bfs
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            if (wordList == null || wordList.size() == 0 ||!wordList.contains(endWord)) return 0;
            Set<String> wordSet = new HashSet<>(wordList);
            Set<String> beginSet = new HashSet<>();
            Set<String> endSet = new HashSet<>();
            beginSet.add(beginWord);
            endSet.add(endWord);
            int len = 1;
            Set<String> visited = new HashSet<>();
            while (!beginSet.isEmpty() && !endSet.isEmpty()) {
                if (beginSet.size() > endSet.size()) {
                    Set<String> temp = beginSet;
                    beginSet = endSet;
                    endSet = temp;
                }
                Set<String> temp = new HashSet<>();
                for (String word : beginSet) {
                    char[] ch = word.toCharArray();
                    for (int i = 0; i < ch.length; i++) {
                        for (char c = 'a'; c <= 'z'; c++) {
                            char old = ch[i];
                            ch[i] = c;
                            String target = String.valueOf(ch);
                            if (endSet.contains(target)) {
                                return len + 1;
                            }
                            if (!visited.contains(target) && wordSet.contains(target)) {
                                visited.add(target);
                                temp.add(target);
                            }
                            ch[i] = old;
                        }
                    }
                }
                beginSet = temp;
                len++;
            }
            return 0;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}