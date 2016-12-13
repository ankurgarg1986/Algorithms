package dynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PrintAllPalindrome {

  public static Map<String,Boolean> m = new HashMap<String,Boolean>();
  public static List<String> ans  = new ArrayList<String>();
  
  public static void main(String[] args) {
    String s  = "nitin";
    printAllPalindrome(s);
  }

  private static void printAllPalindrome(String s) {
    int i,j;  
    int n  = s.length();
    for(i=0;i<n;i++){
      for(j=i;j<n;j++){
          if(printPalinHelper(s,i,j)){
               ans.add(s.substring(i, j+1));
          }
          if(j+1 < n  && printPalinHelper(s,j+1,n-1)){
            ans.add(s.substring(j+1));
          }
      }
    }
    ans.forEach(System.out::println);
  }

  private static boolean printPalinHelper(String str, int s, int e) {
     if(m.get(str.substring(s, e+1)) != null){
         return m.get(str.substring(s, e+1));
     }
      
     while(s<e){
        if(str.charAt(s) != str.charAt(e)){
          m.put(str.substring(s, e+1), false);
          return false;
        }
        s++;
        e--;
     }
     m.put(str.substring(s, e+1), true);
     return true;
  }

}
