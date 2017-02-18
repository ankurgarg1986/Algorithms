package leetcode;

public class P173 {

  /**
   * Definition for binary tree public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode(int x) { val =
   * x; } }
   */

  public TreeNode root;
  public TreeNode nextElem;

  public P173(TreeNode r) {
    this.root = r;
    this.nextElem = null;
  }

  /** @return whether we have a next smallest number */
  public boolean hasNext() {
    if (root == null)
      return false;
    TreeNode curr = root;
    TreeNode parent = null;
    System.out.println(curr.val);
    if (nextElem == null) {
      while (curr.left != null) {
        curr = curr.left;
      }
      System.out.println("ABC");
      nextElem = curr;
      return true;
    }
    if (nextElem.right != null) {
      nextElem = nextElem.right;
      while (nextElem.left != null)
        nextElem = nextElem.left;
      return true;
    }

    while (curr != null) {
      if (nextElem.val < curr.val) {
        parent = curr;
        curr = curr.left;
      } else if (nextElem.val > curr.val) {
        curr = curr.right;
      } else {
        nextElem = parent;
        break;
      }
    }
    if (nextElem != null)
      return true;
    return false;
  }

  /** @return the next smallest number */
  public int next() {
    // System.out.println(this.nextElem.val);
    return this.nextElem.val;

  }
}

/**
 * Your BSTIterator will be called like this: BSTIterator i = new BSTIterator(root); while (i.hasNext()) v[f()] =
 * i.next();
 */

