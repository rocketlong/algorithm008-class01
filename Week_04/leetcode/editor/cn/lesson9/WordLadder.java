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
        System.out.println(solution.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            if (wordList == null || wordList.size() <= 0) {
                return 0;
            }
            Set<Character> characterSet = new HashSet<>();
            for (String s : wordList) {
                for (int i = 0; i < s.toCharArray().length; i++) {
                    characterSet.add(s.toCharArray()[i]);
                }
            }
            Queue<String> queue = new LinkedList<>();
            Set<String> visited = new HashSet<>();
            queue.add(beginWord);
            visited.add(beginWord);
            int level = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    String next = queue.poll();
                    if (next.equals(endWord)) {
                        return level;
                    }
                    char[] chars = next.toCharArray();
                    for (int j = 0; j < chars.length; j++) {
                        char old = chars[j];
                        for (Character character : characterSet) {
                            chars[j] = character;
                            String temp = new String(chars);
                            if (wordList.contains(temp) && !visited.contains(temp)) {
                                queue.add(temp);
                                visited.add(temp);
                            }
                        }
                        chars[j] = old;
                    }
                    level++;
                }
            }
            return 0;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}