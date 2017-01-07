package codeforces;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.InputMismatchException;


public class C381P2 {

  public static void main(String[] args) {
    FastReader sc = new FastReader(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int i,j;
    int[] a = new int[n];
    for(i=0;i<n;i++){
      a[i] = sc.nextInt();
    }
    i = 0;
    int ans = 0;
    while(i<m){
      int sIndex = sc.nextInt();
      int eIndex = sc.nextInt();
      int sum = 0;
      for(j=sIndex-1;j<eIndex;j++){
          sum += a[j];
          ans = ans + a[j];
      }
      if(sum < 0){
         ans = ans - sum; 
      }
      i++;
    }
    System.out.println(ans);
  }

}


