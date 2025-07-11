class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = i+1;
        }
        List<Integer> temp = new ArrayList<>();
        boolean[] used = new boolean[n];
        combination(temp,nums,used,k,0);
        return res;
    }
    public void combination(List<Integer> temp, int[] nums, boolean[] used, int k, int index){
        //Goal state
        if(temp.size()==k){
            res.add(new ArrayList<>(temp));
            return;
        }
        //Exploration
        for(int i=index;i<nums.length;i++){
            if(used[i]==false){
                //Action
                used[i] = true;
                temp.add(nums[i]);
                //recursive call
                combination(temp,nums,used,k,i+1);
                //Undo or backtrack
                used[i] = false;
                temp.remove(temp.size()-1);
            }
        }        
    }
}