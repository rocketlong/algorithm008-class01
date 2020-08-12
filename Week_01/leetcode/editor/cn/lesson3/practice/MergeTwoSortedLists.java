//将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表

package leetcode.editor.cn.lesson3.practice;

//Java：合并两个有序链表
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new Solution();
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
    static class Solution {

        // 递归
//        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//            if (l1 == null) return l2;
//            if (l2 == null) return l1;
//            if (l1.val < l2.val) {
//                l1.next = mergeTwoLists(l1.next, l2);
//                return l1;
//            } else {
//                l2.next = mergeTwoLists(l2.next, l1);
//                return l2;
//            }
//        }

        // 双指针
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            // 遍历
            ListNode listNode = new ListNode(-1);
            ListNode pre = listNode;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    pre.next = l1;
                    l1 = l1.next;
                } else {
                    pre.next = l2;
                    l2 = l2.next;
                }
                pre = pre.next;
            }
            pre.next = l1 == null ? l2 : l1;
            return listNode.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

}