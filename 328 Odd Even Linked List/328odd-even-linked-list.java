class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null || head.next.next==null){
            return head;
        }

        ListNode o = head;
        ListNode e = head.next;
        ListNode eh = head.next;

        while(e!=null && e.next!=null){
            o.next = o.next.next;
            e.next = e.next.next;
            o = o.next;
            e = e.next;
        }
        o.next = eh;
        return head;
    }
}