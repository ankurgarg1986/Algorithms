package ArraysPractice;

/*
 * To execute Java, please define "static void main" on a class named Solution. If you need more classes, simply define
 * them inline.
 */

public class Solution {

  public static void main(String[] args) {

    int sampleArray[][] = { { 1 }, { 2 }, { 3 }, { 4 } };
    int sampleArray2[][] = { { 1, 2, 3, 4 } };
    int sampleArray3[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 }, { 17, 18, 19, 20 } };
    // printSpiral(sampleArray, true, 1);
    // System.out.println();
    // printSpiral(sampleArray2, false, 1);
    // System.out.println();
    printSpiral(sampleArray3, true, 4);
    // 1= LT, 2 = RT, 3 = RB, 4=LB.

    // Your code come here
    // Spiral: 1,2,3,4,8,12,16,20,19,18,17,13,9,5,6,7,11,15,14,10
    // Anticlockwise: 1,5,9,13,17,18,....
  }

  public static void printSpiral(int[][] a, boolean clockwise, int pos) {

    int m = a.length;
    int n = a[0].length;
    String dir = "";
    int t = m * n;
    int c = 0;
    int i = 0, j = 0, k = 0;
    if (clockwise) {
      if (pos == 1)
        dir = "right";
      if (pos == 2)
        dir = "down";
      if (pos == 3)
        dir = "left";
      if (pos == 4)
        dir = "up";
    } else {
      if (pos == 1)
        dir = "down";
      if (pos == 2)
        dir = "left";
      if (pos == 3)
        dir = "up";
      if (pos == 4)
        dir = "right";
    }
    
    while (c < t) {
      if (dir.equals("down")) {
        for (i = k; i < m; i++) {
          if ( !clockwise)
            System.out.print(a[i][j] + " ");
          else
            System.out.print(a[i][n - 1] + " ");
          c++;
        }
        if (clockwise) {
          dir = "left";
          n--;
        } else {
          dir = "right";
          j++;
        }
      } else if (dir.equals("right")) {
        for (i = j; i < n; i++) {
          if ( !clockwise)
            System.out.print(a[m - 1][i] + " ");
          else
            System.out.print(a[k][i] + " ");
          c++;
        }
       
        if (clockwise) {
          dir = "down";
          k++;
        } else {
          dir = "up";
          m--;
        }

      } else if (dir.equals("up")) {
        if (j < n) {
          for (i = m - 1; i >= k; i--) {
            if ( !clockwise)
              System.out.print(a[i][n - 1] + " ");
            else
              System.out.print(a[i][j] + " ");
            c++;
          }
          if (clockwise) {
            dir = "right";
            j++;
          } else {
            dir = "left";
            n--;
          }
        }
      } else if (dir.equals("left")) {
        if (k < m) {
          for (i = n - 1; i >= j; i--) {
            if ( !clockwise)
              System.out.print(a[k][i] + " ");
            else
              System.out.print(a[m - 1][i] + " ");
            c++;
          }
          if (clockwise) {
            dir = "up";
            m--;
          } else {
            dir = "down";
            k++;
          }
        }

      }

    }
  }
}
