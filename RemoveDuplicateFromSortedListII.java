/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode sent = new ListNode(0); //Sentinel to guard against the changed head node
        sent.next = head;
		ListNode cur = head, prev = sent;
		while (cur != null) {
			boolean dup = false;
			while (cur.next != null && cur.next.val == cur.val) {
				dup = true;
				cur = cur.next;
			}
			if (dup) {
				prev.next = cur.next;
			}
			else {
				prev = cur;
			}
			cur = cur.next;
		}
		return sent.next;
    }
}