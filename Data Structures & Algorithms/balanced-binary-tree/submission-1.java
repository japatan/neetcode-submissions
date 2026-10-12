/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int left = dfs(root.left);
        int right = dfs(root.right);

        // “the tree is unbalanced if the heights differ by more than 1.” 
        // That’s a single check on the absolute difference
        if (Math.abs(left - right) > 1) return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }

    // searches depth (height)
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(dfs(root.left), dfs(root.right));
    }
}
