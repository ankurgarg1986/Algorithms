package matrix;

public class RotateInplace {

  public static void main(String[] args) {
    int[][] m = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
                 { 21, 22, 23, 24, 25 } };

    System.out.println(m[4][4]);
    int n = m.length;
    rotateInplace(m, n);
    int i, j;
    for (i = 0; i < n; i++) {
      for (j = 0; j < n; j++) {
        System.out.print(m[i][j] + " ");
      }
      System.out.println("");
    }

  }

  private static void rotateInplace(int[][] a, int n) {
    int i, j;
    int temp;
    for (i = 0; i < n / 2; i++) {
      for (j = i; j < n - i - 1; j++) {
        temp = a[i][j];
        a[i][j] = a[n - 1 - j][i];
        a[n - 1 - j][i] = a[n - 1 - i][n - 1 - j];
        a[n - 1 - i][n - 1 - j] = a[j][n - 1 - i];
        a[j][n - 1 - i] = temp;
      }
    }

  }

}
