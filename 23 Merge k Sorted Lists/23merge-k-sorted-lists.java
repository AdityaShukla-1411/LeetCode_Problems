class Solution {
    class ListNodeComparator implements Comparator<ListNode>{
        
        public int compare(ListNode a, ListNode b){
            return a.val-b.val;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0) return null;
        //PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new ListNodeComparator());
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        ListNode tail = dummy;

        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null){
                pq.add(lists[i]);
            }
            
        }

        while(!pq.isEmpty()){
            ListNode n = pq.poll();
            tail.next = n;
            tail = tail.next;

            if(n.next!=null){
                pq.add(n.next);
            }
        }
        head = dummy.next;
        return head;
    }
}