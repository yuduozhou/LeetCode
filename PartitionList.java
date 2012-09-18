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
    public ListNode partition(ListNode head, int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode headSmall = new ListNode(0);
        ListNode headLarge = new ListNode(0);
        ListNode small = headSmall, large = headLarge;
        while (head != null){
            if (head.val < x){
                small.next = head;
                small = small.next;
            }
            else{
                large.next = head;
                large = large.next;
            }
            head = head.next;
            small.next = null;
            large.next = null;
        }
        small.next = headLarge.next;
        return headSmall.next;
    }
}

public class Solution {
    public ListNode partition(ListNode head, int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode smaller = new ListNode(0);
        ListNode larger = new ListNode(0);
        ListNode h1 = smaller;
        ListNode h2 = larger;
        while(head != null){
            if (head.val < x){
                smaller.next = new ListNode(head.val);
                smaller = smaller.next;
            }
            else{
                larger.next = new ListNode(head.val);
                larger= larger.next;
            }
            head = head.next;
        }
        
        smaller.next = h2.next;
        return h1.next;
    }
}