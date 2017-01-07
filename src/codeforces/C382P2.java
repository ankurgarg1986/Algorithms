package codeforces;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.InputMismatchException;


public class C382P2 {

  public static void main(String[] args) {
    FastReader sc = new FastReader(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();
    char[] c = new char[n];
    int i;
    int g = -1;
    int t = -1;
    for (i = 0; i < n; i++) {
      c[i] = sc.nextCharacter();
      if (c[i] == 'G') {
        g = i;
      }
      if (c[i] == 'T') {
        t = i;
      }
    }
    int diff = g-t;
    int j,p;
    char ch;
    if(diff > 0){
       //left
      j = t;
      p = g;
      ch = 'G';
      
    }else{
      //right
      j = g;
      p = t;
      ch = 'T';
    }
    for(i=j;i<=p;i+=k){
      if(c[i] == '#'){
        System.out.println("NO");
        System.exit(0);
      }
      if(c[i] == ch){
        System.out.println("YES");
        System.exit(0);
      }
    }
    
    System.out.println("NO");
  }

}




