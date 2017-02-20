package leetcode;

public class P33 {

  public static int search(int[] a, int t) {
    if (a.length == 0)
      return -1;
    int n = a.length;
    int l = 0, h = n - 1;
    int m = h + (h - l) / 2;
    while (l <= h) {
      m = l + (h - l) / 2;
      if (a[m] == t)
        return m;
      if (t > a[m]) {
        if (a[l] <= a[m]) {
          // sorted portion
          l = m + 1;
        } else {
          if (a[l] <= t) {
            h = m - 1;
          } else {
            l = m + 1;
          }
        }
      } else if (t < a[m]) {
        if (a[l] > a[m])
          h = m - 1;
        else{
          l = m+1;
        }
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int[] a = {3,1};
    System.out.println(search(a,1));

  }

}
