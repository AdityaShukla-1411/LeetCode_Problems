class Solution {
    List<Integer> list = new ArrayList<>();
    public void preorder(TreeNode curr){
        if(curr==null)return;//Base condition

        list.add(curr.val);//Process
        preorder(curr.left);//Recursive call
        preorder(curr.right);//recursive call
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        preorder(root);
        return list;
    }
}