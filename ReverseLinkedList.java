public class Solution {
    public ListNode reverse(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	ListNode end = head;
		ListNode prev = head, cur = head.next, next = null;
		while (cur != null) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}

		end.next = null;
		return prev;
	}
}