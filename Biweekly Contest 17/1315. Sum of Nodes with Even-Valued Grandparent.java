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
    int sum;
    public int sumEvenGrandparent(TreeNode root) {
        sum = 0;
        sumEvenGrandparent(root, null, null);
        return sum;
    }
    private void sumEvenGrandparent(TreeNode root, TreeNode parent, TreeNode grandparent) {
        if(root == null) return;
        if(grandparent != null && grandparent.val % 2 == 0) sum += root.val;
        sumEvenGrandparent(root.left, root, parent);
        sumEvenGrandparent(root.right, root, parent);
    }
}