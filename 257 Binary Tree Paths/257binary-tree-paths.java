import java.util.*;

class Solution {
    List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        StringBuilder temp = new StringBuilder();
        allpaths(root, temp);
        return res;
    }

    public void allpaths(TreeNode curr, StringBuilder temp) {
        int len = temp.length();

        // Action: Add current node value
        temp.append(curr.val);

        // Goal state: If it's a leaf node, add the path to the result
        if (curr.left == null && curr.right == null) {
            res.add(temp.toString());
        } else {
            // Continue exploring
            temp.append("->"); // Add arrow before recursion
            if (curr.left != null) allpaths(curr.left, temp);
            if (curr.right != null) allpaths(curr.right, temp);
        }

        // Undo state: Restore `temp` to previous state before backtracking
        temp.setLength(len);
    }
}