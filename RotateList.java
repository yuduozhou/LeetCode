public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if ( head == null) return null;
        ListNode a = head;
        int len = 0;
        while (a .next != null){
            a = a.next;
            len ++;
        }
        n = n % (len + 1);
        a.next = head;
        for (int i = 0; i < len - n + 1; i++){
            a = a.next;
        }
        head = a.next;
        a.next = null;
        return head;
    }
}