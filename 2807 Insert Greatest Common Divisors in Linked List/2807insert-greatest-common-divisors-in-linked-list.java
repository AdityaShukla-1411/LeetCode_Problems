class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode curr = head;
        ListNode temp = head.next;
        while(temp!=null){
            int gcd = GCD(curr.val,temp.val);
            ListNode n = new ListNode(gcd);
            n.next = temp;
            curr.next = n;
            curr = temp;
            temp = temp.next;
        }
        return head;
    }
    public static int GCD(int a, int b){
        //base condition
        if(b==0){
            return a;
        }
        //recursive call
        return GCD(b,a%b);
    }
}