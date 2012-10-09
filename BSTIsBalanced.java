/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) return true;
        return (Math.abs(getMaxHeight(root.left)  - getMaxHeight(root.right)) <= 1) &&
            isBalanced(root.left) && isBalanced(root.right);
    }
    
    public int getMaxHeight(TreeNode root){
        if (root == null) return 0;
        return Math.max(getMaxHeight(root.left), getMaxHeight(root.right)) + 1;
    }
}