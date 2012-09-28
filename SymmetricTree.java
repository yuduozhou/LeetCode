public class Solution {
    public boolean isSymmetric(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null) return true;
        TreeNode pointer = root;
        return sameTree(root.left, mirrorTree(root.right));
    }
    private boolean sameTree(TreeNode t1, TreeNode t2){
        if(t1 == null || t2 == null) return t1 == null && t2 == null;
        return t1.val == t2.val && sameTree(t1.left, t2.left) && sameTree(t1.right, t2.right);
    }
    private TreeNode mirrorTree(TreeNode root){
        if (root == null) return root;
        TreeNode temp = mirrorTree(root.left);
        root.left = mirrorTree(root.right);
        root.right = temp;
        return root;
    }
}