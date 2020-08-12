//合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。 
//
// 示例: 
//
// 输入:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//输出: 1->1->2->3->4->4->5->6 
// Related Topics 堆 链表 分治算法 
// 👍 841 👎 0

package leetcode.editor.cn.lesson3.practice;

import leetcode.editor.cn.lesson3.practice.MergeTwoSortedLists;

import java.util.PriorityQueue;

//Java：合并K个排序链表
public class MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {

        // 优先队列
//        public ListNode mergeKLists(ListNode[] lists) {
//            if (lists == null || lists.length == 0) return null;
//            PriorityQueue<ListNode> queue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
//            for (ListNode node : lists) {
//                if (node != null) queue.add(node);
//            }
//            ListNode prev = new ListNode(-1);
//            ListNode curr = prev;
//            while (!queue.isEmpty()) {
//                ListNode node = queue.poll();
//                curr.next = node;
//                curr = curr.next;
//                if (node.next != null) queue.add(node.next);
//            }
//            return prev.next;
//        }

        // 分治
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) return null;
            return merge(lists, 0, lists.length - 1);
        }

        private ListNode merge(ListNode[] lists, int left, int right) {
            if (left == right) return lists[left];
            int mid = left + (right - left) / 2;
            ListNode l1 = merge(lists, left, mid);
            ListNode l2 = merge(lists, mid + 1, right);
            return mergeTwoLists(l1, l2);
        }

        private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) return l2;
            if (l2 == null) return l1;
            if (l1.val < l2.val) {
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            } else {
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            }
        }
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}