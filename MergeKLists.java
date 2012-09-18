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
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (lists.size() == 0) {
			return null;
		}

		ListNode p = lists.get(0);
		//need to create a header for the list
		ListNode head = new ListNode(0);
		head.next = p;
		for (int i = 1; i < lists.size(); i++) {
			merge2Lists(head, lists.get(i));
		}

		return head.next;
	}
	public void merge2Lists(ListNode head, ListNode q){
		ListNode p = head.next;
		ListNode prev = head;

		if (p == null) {
			head.next = q;
		}

		while (p != null && q != null) {
			if (p.val < q.val) {
				if (p.next != null) {
					prev = p;
					p = p.next;
				}
				else {
					p.next = q;
					break;
				}
			}
			else { //insert q before p
				ListNode temp = q.next;
				prev.next = q;
				q.next = p;
				prev = q;
				q = temp;
			}
		}
	}
}