package codeforces;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.InputMismatchException;

public class C367P3 {

  public static void main(String[] args) {
    FastReader2 sc = new FastReader2(System.in);
    int n = sc.nextInt();
    int[] c = new int[n];
    int i;
    for (i = 0; i < n; i++)
      c[i] = sc.nextInt();
    String[] s = new String[n];
    for (i = 0; i < n; i++)
      s[i] = sc.nextString();
    int c1 = 0, c2 = 0, c12 = 0;
    int ans = 0;
    for (i = 0; i < n - 1; i++) {
      if (s[i].compareTo(s[i + 1]) > 0) {
        // s[i] is greater than s[i+1]
        StringBuilder input1 = new StringBuilder();
        input1.append(s[i]);
        input1 = input1.reverse();
        String s1 = input1.toString();
        c1 = c[i];
        StringBuilder input2 = new StringBuilder();
        input2.append(s[i + 1]);
        input2 = input2.reverse();
        String s2 = input2.toString();
        c2 = c[i + 1];
        c12 = c[i] + c[i + 1];
        if (s1.compareTo(s[i + 1]) <= 0 && (s[i].compareTo(s2) <= 0)) {
          ans += Math.min(c1, c2);
          if (c1 < c2) {
            s[i] = s1;
          } else {
            s[i + 1] = s2;
          }
        } else if (s1.compareTo(s[i + 1]) <= 0) {
          ans += c1;
          s[i] = s1;
        } else if (s[i].compareTo(s2) <= 0) {
          ans += c2;
          s[i + 1] = s2;
        } else if (s1.compareTo(s2) <= 0) {
          // reverse both
         
          ans += c12;
          s[i] = s1;
          s[i + 1] = s2;
        }
        if (s[i].compareTo(s[i + 1]) > 0) {
          System.out.println( -1);
          return;
        }

      }
    }
    System.out.println(ans);

  }

}
