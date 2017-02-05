package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Input: ["Hello", "Alaska", "Dad", "Peace"]
// Output: ["Alaska", "Dad"]

public class P500 {

  public static String[] findWords(String[] words) {

    Character[] l1 = { 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p' ,'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P'};
    Character[] l2 = { 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l' ,'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L'};
    Character[] l3 = { 'z', 'x', 'c', 'v', 'b', 'n', 'm', 'Z', 'X', 'C', 'V', 'B', 'N', 'M' };
    List<Character> ll1 = Arrays.asList(l1);
    List<Character> ll2 = Arrays.asList(l2);
    List<Character> ll3 = Arrays.asList(l3);
    ArrayList<String> ans = new ArrayList<String>();
    for(String word :words){
      //for(i=0;i<word.length();i++){
        // word =word.toLowerCase();  
         if(ll1.contains(word.charAt(0))){
             if(allExists(ll1,word)){
               ans.add(word);
             }
           }else if(ll2.contains(word.charAt(0))){
             if(allExists(ll2,word)){
               ans.add(word);
             }
           
           }else{
             if(allExists(ll3,word)){
               ans.add(word);
             }
           }
      //}
    }
    String[] ans1 = new String[ans.size()];
    return ans.toArray(ans1);

  }

  private static  boolean allExists(List<Character> ll2, String word) {
    for(int i=0;i<word.length();i++){
      if(!ll2.contains(word.charAt(i))){
         return false;
      }
    }
    return true;
  }
  public static void main(String[] args) {
    String[] a = {"Hello", "Alaska", "Dad", "Peace"};
    String[] ans = findWords(a);
    for(String ab : ans)
      System.out.println(ab);
  }
}
