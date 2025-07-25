class Solution {
    public int jump(int[] nums) {
        int low = 0, high = 0, count=0;
        while(high<nums.length-1){
            int reach = 0;
            for(int i=low;i<=high;i++){
                reach = Math.max(reach,i+nums[i]);
            }
            low = high+1;
            high = reach;
            count++;
        }
        return count;
    }
}