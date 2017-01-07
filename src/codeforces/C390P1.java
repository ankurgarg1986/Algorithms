package codeforces;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.InputMismatchException;



public class C390P1 {

  public static void main(String[] args) {
    FastReader2 sc = new FastReader2(System.in);
    char[][] tt = new char[4][4];
    int i,j;
    for(i=0;i<4;i++){
      for(j=0;j<4;j++){
        char c = sc.nextCharacter();
         tt[i][j] = c;
      }
    }
    for(i=0;i<4;i++){
      for(j=0;j<4;j++){
         if(tt[i][j] == '.'){
           if( (isValid(i-1,j) &&  tt[i-1][j]== 'x' && isValid(i+1,j) && tt[i+1][j]=='x') || (isValid(i-1,j) &&  tt[i-1][j]== 'x' && isValid(i-2,j) &&  tt[i-2][j] == 'x')
                  || (isValid(i+1,j) && tt[i+1][j]=='x' && isValid(i+2,j) && tt[i+2][j]=='x')){
             System.out.println("YES");
             return;
           }
           if((isValid(i,j-1) &&  tt[i][j-1]== 'x' && isValid(i,j+1) && tt[i][j+1]=='x') || (isValid(i,j-1) &&  tt[i][j-1]== 'x' && isValid(i,j-2) &&  tt[i][j-2]== 'x')
                || (isValid(i,j+1) && tt[i][j+1]=='x' && isValid(i,j+2) && tt[i][j+2]=='x')){
             System.out.println("YES");
             return;
           }
           if((isValid(i-1,j+1) &&  tt[i-1][j+1]== 'x' && isValid(i+1,j-1) && tt[i+1][j-1]=='x')
               || (isValid(i-1,j+1) &&  tt[i-1][j+1]== 'x' && isValid(i-2,j+2) &&  tt[i-2][j+2]== 'x') 
                 || (isValid(i+1,j-1) && tt[i+1][j-1]=='x' && isValid(i+2,j-2) && tt[i+2][j-2]=='x')){
             System.out.println("YES");
             return;
           }
           if((isValid(i-1,j-1) &&  tt[i-1][j-1]== 'x' && isValid(i+1,j+1) && tt[i+1][j+1]=='x')
               || (isValid(i-1,j-1) &&  tt[i-1][j-1]== 'x' && isValid(i-2,j-2) &&  tt[i-2][j-2]== 'x')
                || ((isValid(i+1,j+1) && tt[i+1][j+1]=='x') && isValid(i+2,j+2) && tt[i+2][j+2]=='x')){
             System.out.println("YES");
             return;
           }
         }
      }
    }
    System.out.println("NO");
    
  }

  private static boolean isValid(int i, int j) {
     return i>=0 && i<4 && j>=0 && j<4;
  }

}


