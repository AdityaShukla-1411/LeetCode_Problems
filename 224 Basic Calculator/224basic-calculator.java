class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int sum=0, sign=1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>='0' && s.charAt(i)<='9'){
                int num = 0;
                while(i<s.length() && s.charAt(i)>='0' && s.charAt(i)<='9'){
                    num = num*10 +(s.charAt(i)-'0');
                    i++;
                }
                sum+=(num*sign);
                i--;
            }
            else if(s.charAt(i)=='-'){
                sign = -1;
            }
            else if(s.charAt(i)=='+'){
                sign = 1;
            }
            else if(s.charAt(i)=='('){
                st.push(sum);
                st.push(sign);
                sum=0;
                sign=1;
            }
            else if(s.charAt(i)==')'){
                sum = sum*st.pop();//multiply top sign with current sum
                sum = st.pop()+sum;// add current sum with sum on hold
            }
        }
        return sum;
    }
}