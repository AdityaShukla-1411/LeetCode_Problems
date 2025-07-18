class Solution {
    public boolean sym(TreeNode l, TreeNode r){
        if(l==null && r==null) return true;
        if(l==null || r==null){
            return false;
        }
        return (l.val==r.val) && (sym(l.left, r.right)) && (sym(l.right, r.left));
    }
    public boolean isSymmetric(TreeNode root) {
        return sym(root.left,root.right);
    }
}