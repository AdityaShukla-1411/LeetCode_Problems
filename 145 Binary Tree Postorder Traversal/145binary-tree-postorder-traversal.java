class Solution {
    List<Integer> list = new ArrayList<>();
    public void postorder(TreeNode root){
        if(root==null) return;
        postorder(root.left);
        postorder(root.right);
        list.add(root.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        postorder(root);
        return list;
    }
}