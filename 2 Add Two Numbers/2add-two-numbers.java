class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Initialize a dummy node and a pointer to build the result list
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        
        int carry = 0;  // To store carry from the previous sum

        // Traverse both lists until both are fully processed
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;  // Get value from l1, or 0 if l1 is finished
            int y = (l2 != null) ? l2.val : 0;  // Get value from l2, or 0 if l2 is finished
            
            // Calculate sum of the two digits and the carry
            int sum = x + y + carry;
            carry = sum / 10;  // Calculate new carry
            current.next = new ListNode(sum % 10);  // Create new node with the sum modulo 10
            
            current = current.next;  // Move the current pointer to the next node
            
            // Move to the next nodes in the input lists
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        
        // If there's a carry left, create a new node with the carry value
        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        
        // Return the next node of the dummyHead (which is the actual result)
        return dummyHead.next;
    }
}
