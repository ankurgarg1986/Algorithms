package codeforces;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.InputMismatchException;

public class C384P1 {

  public static void main(String[] args) {
    FastReader sc = new FastReader(System.in);
    int n = sc.nextInt();
    int a = sc.nextInt();
    int b = sc.nextInt();
    int[] ap = new int[n];
    int i = 0;
    while (i < n) {
      ap[i] = sc.nextCharacter() - '0';
      i++;
    }
    a--;
    b--;
    if(ap[a]== ap[b]){
      System.out.println(0);
      return;
    }
//    
//    int x = Math.min(a, b);
//    int y = Math.max(a, b);
//    while(x<y && ap[x]!= ap[y]){
//       x++;
//       
//    }
//    if(x==1){
      System.out.println(1);
//      return;
//    }else{
//      
//    }
//    
//    
//    int ansL = 0;
//    int ansR = 0;
//    while (x < y && ap[x] != ap[y]) {
//      y--;
//      ansL++;
//    }
//    x = Math.min(a, b);
//    y = Math.max(a, b);
//    while (x < y && ap[x] != ap[y]) {
//      x++;
//      ansR++;
//    }
//    System.out.println(Math.min(ansR, ansL));

  }
}


