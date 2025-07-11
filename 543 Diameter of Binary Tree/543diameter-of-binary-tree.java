class Solution {
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter(root);
        return res;
    }
    public int diameter(TreeNode curr){
        if(curr==null) return 0;

        int l = diameter(curr.left);
        int r = diameter(curr.right);
        res = Math.max(res,l+r);

        return Math.max(l,r)+1;
    }
}