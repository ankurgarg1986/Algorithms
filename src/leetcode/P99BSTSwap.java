package leetcode;

public class P99BSTSwap {

  static TreeNode node1 = null;
  static TreeNode node2 = null;
  static TreeNode node3 = null;

  public static void recoverTree(TreeNode root) {
    
    if (root == null)
      return;
    int minm = Integer.MIN_VALUE;
    int maxm = Integer.MAX_VALUE;
    recoverTreeUtil(root,null, minm, maxm);
    if (node3 == null){
      int temp = node1.val;
      node1.val = node2.val;
      node2.val = temp;
    }
    else{
      int temp = node1.val;
      node1.val = node3.val;
      node3.val = temp;
    }
    
    

  }

  private static void recoverTreeUtil(TreeNode root, TreeNode prev , int minm, int maxm) {
    if (root == null)
      return;
    if ( !(root.val > minm && root.val < maxm)) {
      // incorrect node
      if (node1 == null && node2 == null){
        node1 = prev;
        node2 = root;
      }
      else{
        //node2 = prev;
        node3 = root;
      }
     
        
    }
    recoverTreeUtil(root.left,root, minm, root.val);
    recoverTreeUtil(root.right, root,root.val, maxm);

  }
  
  public static void main(String[] args) {
     TreeNode troot = new TreeNode(2);
     troot.right = new TreeNode(1);
     troot.left = new TreeNode(3);
//     troot.right.right.right = new TreeNode(7);
     recoverTree(troot);
     System.out.println("a");
  }
}
