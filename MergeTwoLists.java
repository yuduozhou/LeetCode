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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        //if (l1 == null) return l2;
        //if (l2 == null) return l1;
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                current.next = l1;
                current = current.next;
                l1 = l1.next;
            }
            else{
                current.next = l2;
                current = current.next;
                l2 = l2.next;
            }
        }
        current.next = (l1 == null) ? l2 : l1;
        return dummy.next;
    }   
}