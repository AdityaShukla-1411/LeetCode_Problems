class Solution {
    public boolean checkPerfectNumber(int num) {
        if(num<=1) return false;
        int sum = 1;
        for(int i=2;i*i<=num;i++){
            if(num%i==0){
                sum+=i;//adding divisor
                //add quotient also if its not equal to divisor
                if(i!=num/i)sum+=num/i;//adding quotient
            }
        }
        if(sum==num)
        return true;
        else return false;
    }
}