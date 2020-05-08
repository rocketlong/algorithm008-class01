//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 
//
// 示例： 
//
// 给你这个链表：1->2->3->4->5 
//
// 当 k = 2 时，应当返回: 2->1->4->3->5 
//
// 当 k = 3 时，应当返回: 3->2->1->4->5 
//
// 
//
// 说明： 
//
// 
// 你的算法只能使用常数的额外空间。 
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
// 
// Related Topics 链表

package leetcode.editor.cn.lesson3.practice;

//Java：K 个一组翻转链表
public class ReverseNodesInKGroup {

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Reverse a link list between begin and end exclusively
     * an example:
     * a linked list:
     * 0->1->2->3->4->5->6
     * |           |
     * begin       end
     * after call begin = reverse(begin, end)
     *
     * 0->3->2->1->4->5->6
     *          |  |
     *      begin end
     * @return the reversed list's 'begin' node, which is the precedence of node end
     */
    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null || head.next == null || k == 1) return head;
            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;
            ListNode begin = dummyHead;
            int i = 0;
            while (head != null) {
                i++;
                if (i % k == 0) {
                    begin = reverse(begin, head.next);
                    head = begin.next;
                } else {
                    head = head.next;
                }
            }
            return dummyHead.next;
        }
    }

    public ListNode reverse(ListNode begin, ListNode end) {
        ListNode curr = begin.next;
        ListNode prev = begin;
        ListNode first = curr;
        ListNode next;
        while (curr != end) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        begin.next = prev;
        first.next = curr;
        return first;
    }

    class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}