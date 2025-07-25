class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public void push(int x) {
        if(q1.isEmpty()){
            q1.offer(x);
        }
        else{
            while(!q1.isEmpty()){
                int val = q1.poll();
                q2.offer(val);
            }
            q1.offer(x);
            while(!q2.isEmpty()){
                int val = q2.poll();
                q1.offer(val);
            }
        }
    }
    
    public int pop() {
        return q1.poll();
    }
    
    public int top() {
        return q1.peek();
    }
    
    public boolean empty() {
        if(q1.isEmpty()) return true;
        else return false;
    }
}