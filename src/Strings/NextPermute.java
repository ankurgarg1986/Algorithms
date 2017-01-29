package Strings;

import java.util.Arrays;

public class NextPermute {

  public static void main(String[] args) {
    String sb = "abcd";
    StringBuilder s = new StringBuilder(sb);
    int n = s.length();
    int i, idx2, idx;
    for (i = 1; i < fact(s.length()); i++) {
      idx = findFirst(s, n);
      if (idx == -1)
        return;
      else {
        idx2 = findSecond(s, idx, n);
      }
      String ch = s.substring(idx, idx + 1);
      s.replace(idx, idx + 1, s.substring(idx2, idx2 + 1));
      s.replace(idx2, idx2 + 1, ch);
      String pre = s.substring(0,idx + 1);
      String sub = s.substring(idx + 1);
      char[] c = sub.toCharArray();
      Arrays.sort(c);
      sub = pre + new String(c);
      System.out.println(sub);
      s = new StringBuilder(sub);

    }

  }

  private static int findSecond(StringBuilder s, int idx, int n) {
    if (idx + 1 >= n)
      return idx;
    int ans = -1;
    int diff = 999;
    for (int i = idx; i < n - 1; i++) {
      if (s.charAt(i+1) > s.charAt(idx) && s.charAt(i + 1) - s.charAt(idx) < diff) {
        diff = s.charAt(i + 1) - s.charAt(idx);
        ans = i + 1;
      }
    }
    return ans;
  }

  private static int findFirst(StringBuilder s, int n) {
    for (int i = n - 1; i > 0; i--) {
      if (s.charAt(i) > s.charAt(i - 1)) {
        return i-1;
      }

    }
    return -1;
  }

  private static int fact(int n) {
    // TODO Auto-generated method stub
    int prod = n;
    while (--n > 0) {
      prod = n * prod;
    }
    return prod;
  }

}
