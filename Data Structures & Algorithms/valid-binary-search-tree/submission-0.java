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
    public boolean isValidBST(TreeNode root) {
        // if (root == null) return true;

        // boolean left = isValidBST(root.left);
        // boolean right = isValidBST(root.right);

        // return dfs(root, root.val);
        return valid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean valid(TreeNode leaf, int lowerBound, int upperBound) {
        if (leaf == null) return true;
        if (!((leaf.val < upperBound) && (leaf.val > lowerBound))) return false;
        return valid(leaf.left, lowerBound, leaf.val) && valid(leaf.right, leaf.val, upperBound);
    }
}
