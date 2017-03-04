package leetcode;

import java.util.ArrayList;
import java.util.List;



public class P501 {

  TreeNode root;

  public int[] findMode(TreeNode root) {
    List<Integer> ans = new ArrayList<Integer>();
    int maxFrequency = 1;
    int maxElement = root.val;
    findModeHelper(root, ans, maxFrequency, maxElement, 1, root.val);
    return null;

  }

  private void findModeHelper(TreeNode root, List<Integer> ans, int maxF, int elem, int currF, int pVal) {
    if (root == null)
      return;
    if (root.val == elem) {
      currF++;
      if (currF >= maxF)
        ans.add(root.val);
    }
    findModeHelper(root.left, ans, maxF, root.val, currF, pVal);
    findModeHelper(root.right, ans, maxF, root.val, 1, root.val);

  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    P501 p = new P501();
    p.root = new TreeNode(10);
    p.root.left = new TreeNode(10);
    p.root.right = new TreeNode(12);
    p.root.left.left = new TreeNode(8);
    p.root.left.right = new TreeNode(10);
    p.root.right.left = new TreeNode(11);
    p.root.right.right = new TreeNode(16);

  }

}
