package ArraysPractice;

public class Boggle {
  
  
private static boolean findWordsUtil(String[][] w, String str, int a, int b, int idx,boolean[][] vis) {

if (idx == str.length())
return true;
vis[a][b] = true;
int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };
int m = w.length;
int n = w[0].length;
for (int k = 0; k < 8; k++) {
int x = a + dx[k];
int y = b + dy[k];
if (isValid1(x,y,m,n)  && !vis[x][y] && w[x][y].equals(str.substring(idx,idx+w[x][y].length()+1))) {
  if (findWordsUtil(w, str, x, y, idx + 1,vis))
    return true;
}
}
return false;

}


private static boolean isValid1(int x, int y, int m, int n) {   
return (x>=0 && y>=0 && x<m && y<n);
}

  public static void main(String[] args) {

    String[][] w = { { "ab", "cfd"} };

    String[] d = {  "aaa" };
    for (int i = 0; i < d.length; i++) {
      System.out.println(d[i] + "  is " + findWords(w, d[i], 0));
    }

  }

  private static boolean findWords(String[][] w, String str, int idx) {
    if (idx == str.length())
      return true;
    int m = w.length;
    int n = w[0].length;
    int i, j;
    for (i = 0; i < m; i++) {
      for (j = 0; j < n; j++) {
        if (w[i][j] == str.charAt(idx)) {
          return findWordsUtil(w, str, i, j, idx + 1);
        }
      }
    }
    return false;
  }

  private static boolean findWordsUtil(char[][] w, String str, int a, int b, int idx) {

    if (idx == str.length())
      return true;
    int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
    int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };
    int m = w.length;
    int n = w[0].length;
    for (int k = 0; k < 8; k++) {
      int x = a + dx[k];
      int y = b + dy[k];
      if (isValid1(x,y,m,n) && w[x][y] == str.charAt(idx)) {
        if (findWordsUtil(w, str, x, y, idx + 1))
          return true;
      }
    }
    return false;

  }

  private static boolean isValid(int x, int y, int m, int n) {   
    return (x>=0 && y>=0 && x<m && y<n);
  }

}
