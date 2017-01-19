package ArraysPractice;


public class MaximumSubArrayRemovingOne {

  public static void main(String[] args) {
    //int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
   // int[] a = {1, 2, 3, -4, 5};
    int[] a = {4,-4,4};
    int n = a.length;
    System.out.println(maxSum(a,n));

  }

  private static int maxSum(int[] a,int n) {
    int[] f = new int[n];
    int[] b = new int[n];
    int curr_max = 0;int max_val = a[0];
    f[0] = 0;
    b[n-1] = 0;
    int i;
    for(i=1;i<n;i++){
        curr_max = Math.max(a[i-1], curr_max + a[i-1]);
        f[i] = curr_max;
    }
    curr_max = 0;
    for(i=n-2;i>=0;i--){
      curr_max = Math.max(a[i+1], curr_max + a[i+1]);
      b[i] = curr_max;
    }
    for(i=0;i<n;i++){
      max_val = Math.max(max_val, f[i]+ b[i]);
    }
    return max_val;
  }

}
