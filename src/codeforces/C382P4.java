package codeforces;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.InputMismatchException;



public class C382P4 {

  public static void main(String[] args) {
    FastReader sc = new FastReader(System.in);
    long n = sc.nextLong();
    if(n==2 || n==3 || isPrime(n)) System.out.println(1);
    if(n>3 && n%2== 0)
    {
      System.out.println(2);
    }
    if(n>3 && n%2 != 0) 
      System.out.println(3);

  }

  private static boolean isPrime(long n) {
      return false;
  }

}

