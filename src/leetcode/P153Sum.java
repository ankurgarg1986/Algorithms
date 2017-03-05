package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P153Sum {

  public static List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      int a = nums[i];
      if(i-1>=0 && nums[i-1] == nums[i]) continue;
      int sum = -a;
      int j = i + 1;
      int k = n - 1;
      while (j < k) {
        if (nums[j] + nums[k] == sum) {
          List<Integer> ans1 = new ArrayList<Integer>();
          ans1.add(nums[i]);
          ans1.add(nums[j]);
          ans1.add(nums[k]);
          ans.add(ans1);
          j++;
          k--;
          while (j < k && nums[j] == nums[j-1])
            j++;
          while(k > j && nums[k] == nums[k+1])
            k--;
        } else if (nums[j] + nums[k] > sum)
          k--;
        else
          j++;
      }
    }
    return ans;
  }
  
  public static void main(String[] args) {
    int[] a = {-2,0,0,2,2};
    System.out.println(threeSum(a));
  }
}
