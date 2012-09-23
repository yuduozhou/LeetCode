public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head.next == null) return null;
        ListNode tail = head;
        for (int i = n; i > 0; i--){
            tail = tail.next;
        }

        ListNode sent = new ListNode(0);
        sent.next = head;
        ListNode prev = sent;
        ListNode target = head;
        while(tail != null){
            tail = tail.next;
            prev = prev.next;
            target = target.next;
        }
        prev.next = target.next;
        return sent.next;
    }
}