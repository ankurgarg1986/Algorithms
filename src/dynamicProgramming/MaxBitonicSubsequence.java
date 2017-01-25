package dynamicProgramming;


public class MaxBitonicSubsequence {

  public static void main(String[] args) {
   int[] a = {1,15,51,45,33,100,12,18,9};
   int n = a.length;
   System.out.println(findMaxBitonicSum(a));

  }

  private static int findMaxBitonicSum(int[] a) {
    int n = a.length;  
    int[] dpInc = new int[n];
    int[] dpDec = new int[n];
    int i,j;
    for(i=0;i<n;i++){
      dpInc[i] = a[i];
      dpDec[i] = a[i];
    }
    for(i=1;i<n;i++){
      for(j=0;j<i;j++){
        if(a[i]>a[j]){
          dpInc[i] = Math.max(dpInc[i], dpInc[j] + a[i]);
        }
      }
    }
    for(i=n-2;i>=0;i--){
      for(j=n-1;j>i;j--){
        if(a[i]>a[j]){
           dpDec[i] = Math.max(dpDec[i], dpDec[j] + a[i]); 
        }
      }
    }
    int ans = 0;
    for(i=0;i<n;i++)
      ans = Math.max(ans, dpDec[i] + dpInc[i] - a[i]);
    return ans;
  }

}
