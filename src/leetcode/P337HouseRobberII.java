package leetcode;

import java.util.Stack;

public class P337HouseRobberII {

  public int rob(TreeNode root) {
    int[] res = robUtil(root);
    return Math.max(res[0],res[1]);
    
 }
 public int[] robUtil(TreeNode root){
    if(root == null) return new int[2];
    int[] left = robUtil(root.left);
    int[] right = robUtil(root.right);
    int[] res = new int[2];
    res[0] = root.val + left[1] + right[1];//1 for not robbed ,0 for robbed
    res[1] = Math.max(left[0] ,left[1]) + Math.max (right[0] ,right[1]);
    return res;
  }
}
