class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode p1 = head;
        ListNode p2 = head;
        int count = 0;

        while (count < n) {
            p2 = p2.next;
            count++;
        }

        if (p2 == null) {
            return head.next;
        }

        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        p1.next = p1.next.next;

        return head;
    }
}
