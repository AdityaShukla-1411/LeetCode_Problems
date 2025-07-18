class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies,1);

        //check from left to right(Assuming ascending order)
        for(int i=1;i<n;i++){
            if(ratings[i]>ratings[i-1]){
                candies[i] = candies[i-1]+1;
            }
        }

        //check from right to left(Assuming descending order)
        for(int i=n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                candies[i] = Math.max(candies[i],candies[i+1]+1);
            }
        }
        int res = 0;
        for(int i=0;i<n;i++){
            res+=candies[i];
        }
        return res;
    }
}