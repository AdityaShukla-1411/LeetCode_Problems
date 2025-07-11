class Solution {
    boolean flag = false;
    public void dft(TreeNode curr, int target, int sum){
        if(curr==null){//Base condition
            return;
        }
        //l.add(curr.val);//process
        sum+=curr.val;
        if(curr.left==null && curr.right==null && sum==target){
            flag = true;
        }

        dft(curr.left,target, sum);// recursive call 1
        dft(curr.right,target, sum);//recursive call 2
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        dft(root,targetSum,0);
        return flag;
    }
}