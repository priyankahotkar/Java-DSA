
public class SuccessorInorder {
    static class TreeNode {
      int val;
      TreeNode left, right;
  
      TreeNode(int val) {
          this.val = val;
          this.left = this.right = null;
      }
  }
      public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
          TreeNode successor = null;
          
          // Step 1: Search for the node `p`
          while (root != null) {
              if (p.val < root.val) {
                  // Step 2: If `p` is smaller than current node, this node can be a potential successor
                  successor = root;
                  root = root.left;  // Move to left subtree to search for a smaller successor
              } else if (p.val > root.val) {
                  // Step 3: If `p` is greater than current node, move to right subtree
                  root = root.right;
              } else {
                  // Step 4: Found the node `p`
                  break;
              }
          }
  
          // Step 5: Case 1: If `p` has a right subtree, the successor is the leftmost node in right subtree
          if (p.right != null) {
              TreeNode curr = p.right;
              while (curr.left != null) {
                  curr = curr.left;
              }
              return curr;  // Return the leftmost node in the right subtree
          }
  
          // Step 6: Case 2: If `p` does not have a right subtree, return the most recent ancestor
          return successor;  // This is the closest ancestor where `p` is in its left subtree
      }
  }
  