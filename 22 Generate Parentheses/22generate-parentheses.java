class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        parentheses(new StringBuilder(),n,n,n);
        return res;
    }
    public void parentheses(StringBuilder s, int open, int close, int n){
        //Goal state
        if(s.length()==n*2){
            res.add(s.toString());
            return;
        }
        //Exploration state for '('
        if(open>0){
            //Action state
            s.append('(');
            //Recursive call
            parentheses(s,open-1,close,n);
            //Backtracking or Undo state
            s.deleteCharAt(s.length()-1);
        }

        //Exploration state for ')'
        if(close>0 && close>open){
            //Action state
            s.append(')');
            //Recursive call
            parentheses(s,open,close-1,n);
            //Backtracking or Undo state
            s.deleteCharAt(s.length()-1);
        }
    }
}