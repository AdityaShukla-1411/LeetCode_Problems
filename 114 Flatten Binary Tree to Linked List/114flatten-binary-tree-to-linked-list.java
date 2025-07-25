class Solution {
    TreeNode comp = null;
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = comp;
        root.left = null;
        comp = root;
    }
}