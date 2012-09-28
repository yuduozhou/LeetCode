public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return getTrees(1, n);
    }
    public ArrayList<TreeNode> getTrees(int min, int max){
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        if (min > max){
            result.add(null);
            return result;
        }
        for (int root = min; root <= max; root ++){
            ArrayList<TreeNode> lefts = getTrees(min, root - 1);
            ArrayList<TreeNode> rights = getTrees(root + 1, max);
            for (int i = 0; i < lefts.size(); i++ ){
                for (int j = 0; j < rights.size(); j ++){
                    TreeNode rootNode = new TreeNode(root);
                    rootNode.right = rights.get(j);
                    rootNode.left = lefts.get(i);
                    result.add(rootNode); 
                }
            }
        }
        return result;
    }
}