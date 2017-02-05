package leetcode;

public class P121 {

  public static int maxProfit(int[] p) {
    if (p.length == 0 || p.length == 1)
      return 0;
    int n = p.length;
    int i = 0, j = 1;
    int ans = 0;
    while (i < n && j < n) {
      if (p[i] < p[j]) {
        // i++;
        ans = Math.max(ans, p[j] - p[i]);

      } else {
        i=j;
      }
      j++;
    }
    return ans;

  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int[] a = { 1, 2, 4, 2, 5, 7, 2, 4, 9, 0, 9 };
    System.out.println(maxProfit(a));
  }

}
