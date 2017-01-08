package leetcode;

public class P41 {

  public static void main(String[] args) {
    int[] a ={1,-2,3,-7,-11,2};
    int n = a.length;
    System.out.println(findMissingPositive(a, n));

  }

  private static int findMissingPositive(int[] a, int n) {
    int pivot = segregate(a, n);
    return findMissingPositiveHelper(a, pivot +1);
   
  }

  private static int findMissingPositiveHelper(int[] a,  int n) {
    int i;
    for(i=0;i<n;i++){
      int idx = Math.abs(a[i]);
      if(idx <= n && a[idx-1] > 0){
         a[idx - 1] = -1*a[idx-1];
      }
    }
    for(i=0;i<n;i++){
      if(a[i] > 0)
        return i+1;
    }
    return i+1;
  }

  private static int segregate(int[] a, int n) {
    int i = 0;
    int j = -1;
    for (i = 0; i < n; i++) {
       if(a[i] > 0){
           j++;
           int temp = a[j];
           a[j] = a[i];
           a[i] = temp;
       }
    }
    return j;
  }

}
