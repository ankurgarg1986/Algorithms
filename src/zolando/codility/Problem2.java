package zolando.codility;

// 1b 2c,2d 4d
class Solution2 {

  public String solution(int d, String s, String t) {
    int[][] a = new int[d][d];
    int i, j;
    for (i = 0; i < d; i++) {
      for (j = 0; j < d; j++)
        a[i][j] = -1;
    }
    int sunk = 0;
    int hit = 0;
    String[] sB = t.split(" ");
    for (j = 0; j < sB.length; j++) {
      String s1 = sB[j];
      if (s1.length() == 2) {
        int r1 = s1.charAt(0) - '0' - 1;
        int c1 = s1.charAt(1) - 'A';
        a[r1][c1] = 1;
      } else {
        int r1 = (s1.charAt(0) - '0' ) * 10 + s1.charAt(1) - '0' - 1;
        int c1 = s1.charAt(2) - 'A';
        a[r1][c1] = 1;
      }
    }
    int r1 = 0, c1 = 0, r2 = 0, c2 = 0;
    String[] sA = s.split(",");
    for (j = 0; j < sA.length; j++) {
      String s1 = sA[j];
      String[] s2 = s1.split(" ");
      String sx = s2[0];
      String sy = s2[1];
      if (sx.length() > 2) {
        r1 = (sx.charAt(0) - '0' )*10 + (sx.charAt(1) - '0' - 1) ;
        c1 = sx.charAt(2) - 'A';
      }else{
        r1 = sy.charAt(0) - '0' - 1;
        c1 = sy.charAt(1) - 'A';
      }
      if (sy.length() > 2) {
        r2 = (sy.charAt(0) - '0' )*10 + (sy.charAt(1) - '0' - 1) ;
        c2 = sy.charAt(2) - 'A';
      }else{
        r2 = sy.charAt(0) - '0' - 1;
        c2 = sy.charAt(1) - 'A';
      }
      int x, y;
      int chit = 0;
      for (x = r1; x <= r2; x++) {
        for (y = c1; y <= c2; y++) {
          if (a[x][y] == 1) {
            chit++;
          }
          a[x][y] = 0;
        }
      }
      if (chit == (r2 - r1 + 1) * (c2 - c1 + 1))
        sunk++;
      else if (chit > 0)
        hit++;

    }
    String ans = sunk + "," + hit;
    System.out.println(ans);
    return ans;
  }
}

public class Problem2 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Solution2 s = new Solution2();
    s.solution(26, "26A 26A", "26A");
  }

}
