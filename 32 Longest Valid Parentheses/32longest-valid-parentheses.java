class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int[] st = new int[n+1];
        int max = 0;
        int top = 0;
        st[top] = -1;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='(') st[++top] = i;
            else{
                top--;
                if(top==-1) st[++top] = i;
                else{
                    int diff = i-st[top];
                    if(diff>max) max = diff;
                }
            }
        }
        return max;
    }
}