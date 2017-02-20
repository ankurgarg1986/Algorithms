package leetcode;


public class P153 {

  
  public int findMin(int[] a) {
    int n = a.length;
    if(n==0) return -1;
    if(n==1) return a[0];
    int l=0,h=n-1;
    int m;
    while(l<=h){
      m = l + (h-l)/2;
      if(m-1>=0 && a[m] < a[m-1] && m+1 <n && a[m] < a[m+1]) return a[m];
      if(a[l] <= a[m] ){
        if(a[l] > a[h])
           l = m+1;
        else
          h = m-1;
      }
      else{
        h = m -1;
      }
    }
    return a[l];
    
    
   }
}
