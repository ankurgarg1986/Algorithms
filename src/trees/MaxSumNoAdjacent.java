package trees;


public class MaxSumNoAdjacent {

  public static void main(String[] args) {
        TNode root = new TNode(1);
        root.left = new TNode(2);
        root.right = new TNode(3);
        root.right.left = new TNode(4);
        root.right.right = new TNode(5);
        root.left.left = new TNode(1);
     
        System.out.println(getMaxSum(root));

  }

  private static int getMaxSum(TNode root) {
    int ans = 0;
    if(root == null) return 0;
    if(root.left == null  && root.right == null) return 0;
    
    return ans;
    
  }

}
