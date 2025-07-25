class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> p = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        permutation(nums,used,p);
        return res;
    }
    public void permutation(int[] nums, boolean[] used, List<Integer> p){
        //Goal state
        if(nums.length==p.size()){
            res.add(new ArrayList<>(p));
            return;
        }
        //Exploration state
        for(int i=0;i<nums.length;i++){
            if(used[i]==false){
                //Action state
                p.add(nums[i]);
                used[i] = true;
                //Recursive call
                permutation(nums,used,p);
                //Undo
                p.remove(p.size()-1);
                used[i] = false;
            }
        }
    }
}