package zolando.codility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class Solution {
  public int solution(int[] a, int[] b, int m, int x, int y) {
     int n = a.length;
     int i = 0;
     int ans = 0;
     while(i<n){
         long currW = 0;
         int c = 0;
         List<Integer> l = new ArrayList<Integer>();
         while(i<n && c<x && currW + a[i] <= y){
           l.add(b[i]);
           currW += a[i];
           i++;
           c++;
         }
         Collections.sort(l);
         int j = 0;
         while(j<l.size()){
            int f = l.get(j);
            //k = j+1;
            while(j+1<l.size() && l.get(j+1) == f){
              j++;
            }
            ans++;
            j++;
         }
       ans++;//for travelling again to grnd floor
         
     }
     return ans;
  }
}

public class Problem1 {

  public static void main(String[] args) {
//   int[] a = {60,80,40};
//   int[] b = {2,3,5};
//   int[] a = {40,40,100,80,20};
//   int[] b = {3,3,2,2,3};
    int[] a = {1000000000,1000000000,1000000000,1000000000,1000000000,1000000000};
    int[] b = {3,2,2,2,2,2};
   int m = 3;
   int x = 2;
   int y = 1000000000;
   Solution s = new Solution();
   System.out.println(s.solution(a, b, m, x, y));
   
    

  }

}
