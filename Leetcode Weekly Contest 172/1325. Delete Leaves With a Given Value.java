/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        TreeNode pseudoParent = new TreeNode(-1);
        pseudoParent.left = root;
        removeLeafNodes(pseudoParent, root, target, 0);
        return pseudoParent.left;
    }
    
    private boolean removeLeafNodes(TreeNode parent, TreeNode root, int target, int leftRight) {
        if(root == null) return false;
        if(root.val == target && root.left == null && root.right == null) {
            if(leftRight == 0) parent.left = null;
            if(leftRight == 1) parent.right = null;
            return true;
        }
        boolean left = removeLeafNodes(root,root.left, target, 0);
        boolean right = removeLeafNodes(root,root.right, target, 1);
        boolean res = left || right;
        if(res && root.left == null && root.right == null && root.val == target) {
            if(leftRight == 0) parent.left = null;
            if(leftRight == 1) parent.right = null;
            return true;
        }
        return false;
    }
}