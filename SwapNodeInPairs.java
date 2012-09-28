public class Solution {
    public ListNode swapPairs(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null) return head;
        ListNode pointer = head;
        while(pointer != null && pointer.next != null){
            int temp = pointer.next.val;
            pointer.next.val = pointer.val;
            pointer.val = temp;
            pointer = pointer.next.next;
        }
        return head;
    }
}