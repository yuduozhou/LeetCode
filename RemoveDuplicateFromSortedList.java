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
        if (head == null)  return null;
        ListNode p1 = head, p2 = p1.next;
        while(p2 != null){
            if(p2.val != p1.val){
                p1 = p2;
                p2 = p2.next;
            }
            else{
                p2 = p2.next;
                p1.next = p2;
            }
        }
        return head;
    }
}