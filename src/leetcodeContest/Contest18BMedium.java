package leetcodeContest;

import java.util.Deque;
import java.util.LinkedList;


public class Contest18BMedium {

  public static  int[] nextGreaterElements(int[] a) {
    int n = a.length;
    int i=0;
    int[] ans = new int[n];
    boolean[] set = new boolean[n];
    if(n==0) return ans;
    for(i=0;i<n;i++) ans[i] = -1;
    Deque<Integer> s = new LinkedList<Integer>();
    s.push(a[n-1]);
    for(i=n-2;i>=0;i--){
       while(!s.isEmpty()){
         if(s.peek() > a[i]){
           ans[i] = s.peek();
           set[i] =true;
           break;
         }
         s.pop();
       }
       s.push(a[i]);
    }
    for(i=n-1;i>=0;i--){
      if(!set[i]){
        while(!s.isEmpty()){
          if(s.peek() > a[i]){
            ans[i] = s.peek();
            break;
          }
          else s.pop();
        }
      }
    }
    
    return ans;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int[] a ={3,-2,-1};
   // int[] a = {100,1,11,1,120,111,123,1,-1,-100};
      System.out.println(nextGreaterElements(a));
  }

}
 