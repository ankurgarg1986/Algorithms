package codeforces;


import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.InputMismatchException;

public class C379P3 {

  public static void main(String[] args) {
    FastReader sc = new FastReader(System.in);
    
    long n = sc.nextLong();
    int m = sc.nextInt();
    int k = sc.nextInt();
    long x = sc.nextLong();
    long t = sc.nextLong();
    int i, j;
    long c;
    long ans = n * x;// using 0 potions
    long[] t1 = new long[m];
    long[] p1 = new long[m];
    for (i = 0; i < m; i++) {
      t1[i] = sc.nextLong();
    }
    for (i = 0; i < m; i++) {
      p1[i] = sc.nextLong();
      if (t - p1[i] >= 0) {
        ans = Math.min(ans, n * t1[i]);
      }
    }
    long[] c2 = new long[k+1];
    for (i = 1; i < k+1; i++) {
      c2[i] = sc.nextLong();
    }
    long[] p2 = new long[k+1];
    for (i = 1; i < k+1; i++) {
      p2[i] = sc.nextLong();
      if (t - p2[i] >= 0) 
         ans = Math.min(ans, (n - c2[i]) * x);
    }
    
    for (j = 0; j < m; j++) {
      long rem = t - p1[j];
      if(rem > 0) {
         c = binSearch(rem,p2,0,k,c2);
         ans = Math.min(ans,(n-c)*t1[j]);
      }
    
    }

    System.out.println(ans);

  }

  private static long binSearch(long rem, long[] p2, int l, int h,long[] c2) {
    int mid = 0;
    while(l<h){
       mid = l + (h-l+1)/2;
      if(rem == p2[mid]) return c2[mid];
      if(rem < p2[mid]) h = mid-1;
      else l = mid;
     
   }
   if(p2[l] > rem ) return 0;
   return c2[l];
    
  }

}

 
