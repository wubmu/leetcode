import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个升序链表
 */

// @lc code=start
// class ListNode {
//      int val;
//      ListNode next;
//      ListNode() {}
//      ListNode(final int val) {
//          this.val = val;
//      }

//      ListNode(final int val, final ListNode next) {
//          this.val = val;
//          this.next = next;
//      }
// }
 class Solution {
    public ListNode mergeKLists(final ListNode[] lists) {
        Queue<ListNode> pq = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);
        for (ListNode node: lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            tail.next = minNode;
            tail = minNode;
            if (minNode.next != null) {
                pq.offer(minNode.next);
            }
        }

        return dummyHead.next;

    }
}
// @lc code=end

