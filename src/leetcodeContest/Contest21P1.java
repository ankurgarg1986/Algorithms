package leetcodeContest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.tree.TreeNode;


public class Contest21P1 {

  List<Integer> val = new ArrayList<Integer>();
  public int getMinimumDifference(TreeNode root) {
    int ans = Integer.MAX_VALUE;
    if(root == null) return 0;
    List<Integer> list = new ArrayList<Integer>();
    getMinimumDifferenceHelper(root,list);
    Iterator<Integer> it = list.listIterator();
    int prev = Integer.MAX_VALUE;
    while(it.hasNext()){
      int elem1= it.next();
      ans  = Math.min(ans, Math.abs(elem1 - prev));
      prev =elem1;
    }
    return ans;
  }
  private void getMinimumDifferenceHelper(TreeNode root, List<Integer> list) {
    if(root == null) return ;
    getMinimumDifference( root.left,list);
    list.add(root.val);
    getMinimumDifference( root.right,list);
    
    
  }
}
