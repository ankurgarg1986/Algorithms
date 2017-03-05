package leetcodeContest;

public class Contest22P3 {

  public static int findBlackPixel(char[][] p, int N) {
    int m = p.length;
    int n = p[0].length;
    int[] rowCount = new int[m];
    int[] colCount = new int[n];
    int i, j;
    int ans = 0;
    for (i = 0; i < m; i++) {
      for (j = 0; j < n; j++) {
        if (p[i][j] == 'B') {
          // row i,column j
          rowCount[i]++;
          colCount[j]++;
        }
      }
    }
    boolean match = false;
    for (i = 0; i < m; i++) {
      for (j = 0; j < n; j++) {
        if (p[i][j] == 'B') {
          if (rowCount[i] == N && colCount[j] == N) {
            match = false;
            for (int k = 0; k < m; k++) {
              if (k != i) {
                if (p[k][j] == 'B' && !rowMatch(k,i,p,n)) {
                  match = true;
                  break;
                }
              }

            }
            if ( !match)
              ans++;
          }
        }
      }
    }
    return ans;
  }

  private static boolean rowMatch(int x, int y , char[][] p,int n) {
      for(int i=0;i<n;i++){
        if(p[x][i] != p[y][i]) return false;
      }
      return true;
  }

  public static void main(String[] args) {
    char[][] p = { { 'W', 'B', 'B', 'W', 'W', 'B', 'W', 'W', 'W', 'W', 'W', 'B', 'B', 'W', 'W' },
                  { 'W', 'B', 'B', 'W', 'W', 'B', 'W', 'W', 'W', 'W', 'W', 'B', 'B', 'W', 'W' },
                  { 'W', 'W', 'W', 'W', 'W', 'B', 'B', 'B', 'W', 'B', 'W', 'W', 'W', 'W', 'B' },
                  { 'W', 'W', 'B', 'W', 'B', 'W', 'W', 'W', 'W', 'B', 'B', 'W', 'B', 'W', 'W' },
                  { 'W', 'B', 'B', 'W', 'W', 'B', 'W', 'W', 'W', 'W', 'W', 'B', 'B', 'W', 'W' },
                  { 'W', 'W', 'B', 'W', 'B', 'W', 'W', 'W', 'W', 'B', 'B', 'W', 'B', 'W', 'W' },
                  { 'W', 'W', 'B', 'W', 'B', 'W', 'W', 'W', 'W', 'B', 'B', 'W', 'B', 'W', 'W' },
                  { 'W', 'W', 'B', 'W', 'B', 'W', 'W', 'W', 'W', 'B', 'B', 'W', 'B', 'W', 'W' }

    };
    System.out.println(findBlackPixel( p, 5));
  }
}