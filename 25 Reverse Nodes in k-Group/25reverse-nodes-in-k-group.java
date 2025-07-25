class Solution {
    public boolean exists(ListNode curr, int k){
        int c = 0;
        while(curr!=null){
            c++;
            if(c==k){
                return true;
            }
            curr = curr.next;
        }
        return false;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prev = null, curr = head;
        int count = 0;
        while(curr!=null && count!=k){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            count++;
        }
        if(exists(curr,k)){
            head.next = reverseKGroup(curr,k);
        }
        else{
            head.next=curr;
        }
        
        return prev;
    }
}