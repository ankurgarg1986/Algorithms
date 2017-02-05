package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;



class TreeNode {

  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}

public class P508 {

  TreeNode root;
  //static int mfSum;
  static int maxF;

  public static int[] findFrequentTreeSum(TreeNode root) {
     maxF = 0;
     HashMap<Integer,Integer> sumMap = new HashMap<Integer,Integer>();
     findSumTree(root,sumMap);
     ArrayList<Integer> ans =  new ArrayList<Integer>();
     for(Entry<Integer,Integer> e : sumMap.entrySet()){
        int key =  e.getKey();
        int val = e.getValue();
        if(val == maxF){
          ans.add(key);
        }
     }
     int[] ans1 = new int[ans.size()];
     for(int i=0;i<ans.size();i++)
        ans1[i] = ans.get(i);
     return ans1;
  }

  private static int findSumTree(TreeNode root,HashMap<Integer,Integer> sumMap) {
    if(root == null) return 0;
    int lSum =  findSumTree(root.left ,sumMap);
     int rSum = findSumTree(root.right ,sumMap);
     int sum = lSum + rSum + root.val;
     if(sumMap.get(sum) != null){
       int currF = sumMap.get(sum);
       sumMap.put(sum,currF+1 );
       if(currF+1 >= maxF){
        // mfSum = sum;
         maxF = currF + 1;
       }
     }else{
       sumMap.put(sum, 1);
       if(maxF < 1) maxF = 1;
     }
     return sum;
  }

  public static void main(String[] args) {
    P508 p = new P508();
    p.root = new TreeNode(1);
//    p.root.left = new TreeNode(2);
//    p.root.right = new TreeNode(-5);
//    p.root.left.left = new TreeNode(8);
//    p.root.left.right = new TreeNode(10);
//    p.root.right.left = new TreeNode(11);
//    p.root.right.right = new TreeNode(16);
    int[] ans  = findFrequentTreeSum(p.root);
    for(int i=0;i<ans.length;i++)
      System.out.println(ans[i]);

  }

}
