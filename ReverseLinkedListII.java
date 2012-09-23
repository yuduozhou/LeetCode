public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int count = 1;
		ListNode g = new ListNode(0);
		g.next = head;
		ListNode end = head, prev = head, cur = head.next, next = null, x = g;
		while (true) {
			if (count >= m && count < n) {
				next = cur.next;
				cur.next = prev;
				prev = cur;
				cur = next;
			}
			else if (count < m){
				x = prev;
				prev = cur;
				cur = cur.next;
			}
			else if (count == n) {
				x.next.next = cur;
				x.next = prev;
				break;
			}
			count++;
		}
		return g.next;
	}
}