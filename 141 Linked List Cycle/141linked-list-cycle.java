//Run time: 0 ms
//Time complexity: O(N)
//Space complexity: O(1)

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;

        while(fast!=null && fast.next!=null){
           fast = fast.next.next;
           slow = slow.next;

           if(fast==slow){
              return true;
           }
        }
        
        return false;
    }
}

//Steps: 