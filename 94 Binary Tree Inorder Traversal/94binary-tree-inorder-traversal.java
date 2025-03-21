class Solution {
    List<Integer> list = new ArrayList<>();
    public void inorder(TreeNode curr){
        if(curr==null)return;//Base condition

        inorder(curr.left);//Recursive call
        list.add(curr.val);//Process
        inorder(curr.right);//recursive call
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return list;   
    }
}