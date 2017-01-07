package codeforces;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;


public class C388P1 {

  public static void main(String[] args) {
    FastReader sc = new FastReader(System.in);
    int k = sc.nextInt();
    List<Integer> s = new ArrayList<Integer>();
    int n = k;
    int c = 0;
    int i = 0;
    if (k % 2 == 0) {
      System.out.println(k / 2);
      while (k>0) {
        System.out.print(2 + " ");
        k = k-2;
        i++;
      }
    } else {
      i = 0;
      System.out.println(k / 2);
      k = k - 2;
      while (k>1) {
        System.out.print(2 + " ");
        k = k-2;
      }
      System.out.println(3);
    }
  }
}


