package codeforces;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.InputMismatchException;



public class C389P1 {

  public static void main(String[] args) {
    FastReader sc = new FastReader(System.in);
    int l = sc.nextInt();
    int d  = sc.nextInt();
    int t = sc.nextInt();
    //int t = 2*l*d;
    int i = 1;
    while(2*i*d<t)
         i++;
    int lo = 2*(i-1)*d;
    System.out.print(i + " ");
    i = 1;
    while(lo + 2*i <= t){
      if(lo + 2*i == t){
        System.out.print( i + " " + "R");
        return;
      }
      i++;
    }
    System.out.println(i + " " + "L");
    

  }

}


