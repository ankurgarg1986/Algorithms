package trees;

class BNode {

  public BNode(int i) {
    this.data = i;
    this.left = null;
    this.right = null;
  }

  int data;
  BNode left;
  BNode right;
}

public class MaxConsecutiveIncreasingPath {

  BNode root;

  public static void main(String[] args) {

    BNode root = new BNode(10);// root Node with pLen 0
    MaxConsecutiveIncreasingPath ms = new MaxConsecutiveIncreasingPath();
    ms.root = root;
    ms.root.left = new BNode(11);
    ms.root.right = new BNode(9);
    ms.root.left.right = new BNode(12);
    ms.root.left.left = new BNode(13);
    // ms.root.left.left.left = new Node(3);
    ms.root.right.left = new BNode(13);
    ms.root.right.right = new BNode(8);
    int ans = maxLen(root);
    System.out.println(ans);

  }

  private static int maxLen(BNode root) {
    if (root == null)
      return 0;
   return maxLenUtil(root, root.data - 1, 0);
   // return 0;
  }

  private static int maxLenUtil(BNode root, int val, int prevLen) {
    if (root == null)
      return prevLen;
    int curr_val = root.data;
    if (curr_val == val + 1) {
      return Math.max(maxLenUtil(root.left, curr_val, prevLen + 1), maxLenUtil(root.right, curr_val, prevLen + 1));
    }
    int res = Math.max(maxLenUtil(root.left, curr_val, 1), maxLenUtil(root.right, curr_val, 1));

    return Math.max(res, prevLen);
  }

}
