import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class named Solution. If you need more classes, simply define
 * them inline.
 */

public class Solution {

  public static void main(String[] args) {

    int sampleArray[][] = { { 1, 2, 3, 4 }, 
                           { 5, 6, 7, 8 }, 
                           { 9, 10, 11, 12 }, 
                           { 13, 14, 15, 16 }, 
                           { 17, 18, 19, 20 } };

    printSpiral(sampleArray, false, 3);
    // 1= LT, 2 = RT, 3 = RB, 4=LB.

    // Your code come here
    // Spiral: 1,2,3,4,8,12,16,20,19,18,17,13,9,5,6,7,11,15,14,10
    // Anticlockwise: 1,5,9,13,17,18,....
  }

  public static void printSpiral(int[][] a, boolean clockwise, int position) {
    
    int m = a.length;
    int n = a[0].length;

    int i = 0, j = 0, k = 0;
    int r, c;
    if ( !clockwise) {
      while (j < m && k < n) {
        for (i = k; i < m; i++)
          System.out.print(a[i][j] + " ");
        j++;
        for (i = j; i < n; i++) {
          System.out.print(a[m - 1][i] + " ");
        }
        m--;
        if (k < n) {
          for (i = m - 1; i >= k; i--)
            System.out.print(a[i][n-1] + " ");
          n--;
        }
        if (j < m)
          for (i = n - 1; i >= j; i--)
            System.out.print(a[k][i] + " ");
          k++;
      }
    } else {
      while (j < m && k < n) {
        for (i = k; i < n; i++) {
          System.out.print(a[j][i] + " ");

        }
        j++;
        for (i = j; i < m; i++) {
          System.out.print(a[i][n - 1] + " ");

        }
        n--;
        if (j < m) {

          for (i = n - 1; i >= k; i--) {
            System.out.print(a[m - 1][i] + " ");

            m--;
          }

          if (k < n) {
            for (i = m - 1; i >= j; i--) {
              System.out.print(a[i][k] + " ");

              k++;
            }

          }
        }
      }
    }
  }
}