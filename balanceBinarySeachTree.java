import java.util.*;


/*************************************************************************************** */










/********************************************************************************************* */



public class balanceBinarySeachTree {
  public class TreeNode {
     int val;
    TreeNode left;
      TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
       this.val = val;
        this.left = left;
        this.right = right;
     }




          
     class Solution {
   private List<Integer> values = new ArrayList<>();
    // Perform in-order traversal to collect node values
    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        values.add(root.val);
        inorder(root.right);
    }
    // Build a balanced BST from sorted values
    private TreeNode buildBalancedBST(List<Integer> values, int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(values.get(mid));
        root.left = buildBalancedBST(values, start, mid - 1);
        root.right = buildBalancedBST(values, mid + 1, end);
        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
        // Collect node values in sorted order
        values.clear(); // Clear the list before collecting new values
        inorder(root);
        // Build a balanced BST from the sorted values
        return buildBalancedBST(values, 0, values.size() - 1);
    }
}

  }

 public static void main(String[] args) {
  
 }
}
/*************************************************************************************************** */
