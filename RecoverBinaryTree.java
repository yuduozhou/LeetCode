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
    public void recoverTree(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<TreeNode> inOrder = new ArrayList<TreeNode>();
        int error1 = 0;
        int error2 = 0;
        inOrderTrav(root, inOrder);
        int prev = 0;
        for (int i = 1; i < inOrder.size(); i++){
            // Value is in ascening order.
            if (inOrder.get(i).val > inOrder.get(prev).val){
                prev = i;
            }
            // Previous node is bigger.
            else {
                error1 = prev;
                break;
            }
        }
        // Find the smallest node afterwards.
        error2 = prev + 1;
        for (int i = error2 + 1; i < inOrder.size(); i++){
            if (inOrder.get(i).val < inOrder.get(error2).val){
                error2 = i;
            }
        }
        int temp = inOrder.get(error1).val;
        inOrder.get(error1).val = inOrder.get(error2).val;
        inOrder.get(error2).val = temp;
    }
    public void inOrderTrav(TreeNode root, ArrayList<TreeNode> inOrder){
        if(root == null) return;
        inOrderTrav(root.left, inOrder);
        inOrder.add(root);
        inOrderTrav(root.right, inOrder);
    }
}