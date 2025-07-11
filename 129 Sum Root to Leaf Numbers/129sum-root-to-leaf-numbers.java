class Solution {
    int sum = 0;
    public void dft(TreeNode curr, int num){
        if(curr==null)return;
        num = num*10+curr.val;
        if(curr.left==null && curr.right==null){
            sum+=num;
        }
        dft(curr.left,num);
        dft(curr.right, num);
    }
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        dft(root,0);
        return sum;
    }
}