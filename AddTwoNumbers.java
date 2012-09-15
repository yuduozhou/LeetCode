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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int carry = 0;
        ListNode dummy = new ListNode(0);
        while (l1 != null || l2 != null){
            int sum = carry + getVal(l1) + getVal(l2);
            carry = sum / 10;
            
            ListNode current = new ListNode(sum % 10);
            current.next = dummy.next;
            dummy.next = current;
            l1 = getNext(l1);
            l2 = getNext(l2);
        }
        if (carry != 0){
            ListNode head = new ListNode(carry);
            head.next = dummy.next;
            dummy.next = head;
        }
        return reverse(dummy.next);
    }
    
    public int getVal(ListNode node){
        if (node == null) return 0;
        return node.val;
        
    }
    
    public ListNode getNext(ListNode node){
        if (node == null) return null;
        return node.next;
    }
    
    public ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode newHead = null;
        while (current != null) {
            ListNode tmp = current;
            current = current.next;
            tmp.next = newHead;
            newHead = tmp;
        }
        return newHead;
    }
}