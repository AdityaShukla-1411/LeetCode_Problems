class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        if(n%2!=0) return false;
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch=='(' || ch=='{' || ch=='['){
                st.push(ch);
            }
            else if((!st.empty())&&((ch==')' && st.peek()=='(')||
                   (ch=='}' && st.peek()=='{')||
                   (ch==']' && st.peek()=='['))){
                    st.pop();
                   }
            else{
                st.push(ch);
            }
        }
        if(st.empty()){
            return true;
        }
        else{
            return false;
        }
    }
}