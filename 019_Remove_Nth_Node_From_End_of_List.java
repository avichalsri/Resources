/*Given a linked list, remove the n-th node from the end of list and return its head.
Example:
Given linked list: 1->2->3->4->5, and n = 2.
After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Follow up:
Could you do this in one pass?*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /*public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        int ls = 0;
        while (curr != null) {
            curr = curr.next;
            ls++;
        }
        // n == len
        if (ls == n) {
            if (ls > 1) return head.next;
            return null;
        }
        curr = head;
        // Move to ls - n - 1
        for (int i = 0; i < ls - n - 1; i++) {
            curr = curr.next;
        }
        // Remove ls - n - 1
        curr.next = curr.next.next;
        return head;
    }*/

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow, fast, curr;
        slow = head; fast = head;
        for (int i = 0; i < n; i++)
            fast = fast.next;
        // n == len
        if (fast == null) {
            head = head.next;
            return head;
        }
        // Move both pointers, until reach tail
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        curr = slow.next;
        slow.next = curr.next;
        return head;
    }
}
