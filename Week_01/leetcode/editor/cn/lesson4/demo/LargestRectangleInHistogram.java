//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 
//
// 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。 
//
// 
//
// 
//
// 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。 
//
// 
//
// 示例: 
//
// 输入: [2,1,5,6,2,3]
//输出: 10 
// Related Topics 栈 数组

package leetcode.editor.cn.lesson4.demo;

import java.util.Stack;

//Java：柱状图中最大的矩形
public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        int[] heights = {1, 1, 1};
        solution.largestRectangleArea(heights);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        public int largestRectangleArea(int[] heights) {
            Stack<Integer> stack = new Stack<>();
            stack.add(-1);
            int max = 0;
            for (int i = 0; i < heights.length; i++) {
                while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                    max = Math.max(heights[stack.pop()] * (i - stack.peek() - 1), max);
                }
                stack.push(i);
            }
            while (stack.peek() != -1) {
                // 若是相同高度，永远只会剩下最后一个
                max = Math.max(heights[stack.pop()] * (heights.length - stack.peek() -1), max);
//                 Integer pop = stack.pop();
//                 max = Math.max(heights[pop] * (pop - stack.peek()), max);
            }
            return max;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}