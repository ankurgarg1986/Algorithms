package facebook.hackercup;

import java.util.Arrays;
import java.util.PriorityQueue;

import codeforces.FastReader2;

public class Round1P1 {

  public static void main(String[] args) {
    FastReader2 sc = new FastReader2(System.in);
    int t = sc.nextInt();
    int count = 1;
    while (t > 0) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
      int i, j;
      int ans = 0;
      int[][] c = new int[n][m];
      for (i = 0; i < n; i++) {
        for (j = 0; j < m; j++)
          c[i][j] = sc.nextInt();
        Arrays.sort(c[i]);
      }
      int k;
      for (i = 0; i < n; i++) {
        k = 1;
        for (j = 0; j < m; j++) {
          c[i][j] += k * k - (k - 1) * (k - 1);
          k++;
        }
      }
      for (i = 0; i < n; i++) {
        for (j = 0; j < m; j++) {
          pq.add(c[i][j]);
        }
       ans += pq.poll();
      }
      System.out.println("Case #" + count + ": " + ans);
      count++;
      t--;
    }
  }
}


