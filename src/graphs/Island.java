package graphs;

public class Island {

  // Driver method
  public static void main(String[] args) throws java.lang.Exception {
    int M[][] = new int[][] { { 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1 }, { 1, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0 },
                             { 1, 1, 1, 1, 1 } };
    String s1 = "ab" + "c";
    String s2 = "a" + "bc";
    System.out.println(s1 ==s2);
    s1.equals(s2);
    Island I = new Island();
    System.out.println("Number of islands is: " + I.countIslands(M));
  }

  private int countIslands(int[][] a) {
    int i, j;
    int m = a.length;
    int n = a[0].length;
    int ans = 0;
    boolean[][] vis = new boolean[m][n];
    for (i = 0; i < m; i++) {
      for (j = 0; j < n; j++) {
        vis[i][j] = false;
      }
    }
    for (i = 0; i < m; i++) {
      for (j = 0; j < n; j++) {
        if (vis[i][j] == false && a[i][j] == 1) {
          vis[i][j] = true;
          ans++;
          countIslandsUtil(a, vis, m, n, i, j);
        }
      }
    }
    return ans;
  }

  private void countIslandsUtil(int[][] a, boolean[][] vis, int m, int n, int i, int j) {
    // int i, j;
    //int c = 0;
    int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
    int[] dy = { 0, -1, 1, 1, -1, 0, -1, 1 };
    for (int k = 0; k < 8; k++) {
      int x = dx[k] + i;
      int y = dy[k] + j;
      if (valid(x, y, m, n) && vis[x][y] == false) {
        vis[x][y] = true;
        if (a[x][y] == 1) {
          countIslandsUtil(a, vis, m, n, x, y);
        }
      }
    }
    // return 1;
  }

  private boolean valid(int x, int y, int m, int n) {
    if (x < 0 || x >= m || y < 0 || y >= n)
      return false;
    return true;
  }
}
