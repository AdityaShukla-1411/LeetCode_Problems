class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        if(n==0){
            if(amount==0)return 1;
            else return 0;
        }
        int[] dp = new int[amount+1];
        dp[0] = 1;// for amount zero no. of combinations=1

        for(int i=0;i<n;i++){
            for(int j=coins[i];j<=amount;j++){
                dp[j] = dp[j]+dp[j-coins[i]];
            }
        }
        return dp[amount];
    }
}