public class Solution {
    public boolean isValidBST(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return isValidBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public boolean isValidBSTHelper(TreeNode root, int min, int max){
        if (root == null) return true;
        return root.val < max && root.val > min &&
            isValidBSTHelper(root.left, min, root.val) &&
            isValidBSTHelper(root.right, root.val, max);
    }
}