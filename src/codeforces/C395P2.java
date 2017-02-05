package codeforces;

public class C395P2 {

  public static void main(String[] args) {
    FastReader2 sc = new FastReader2(System.in);
    int n = sc.nextInt();
    long[] a = new long[n];
    int i, j;
    for (i = 0; i < n; i++)
      a[i] = sc.nextLong();
     i = 0;
     j = n-1;
     int c = 0;
     while(i<j){
       // swap(a,i,j);
        if(c%2==0){
          long temp  = a[i];
          a[i] = a[j];
          a[j] = temp;
        }
        c++;
        i++;
        j--;
     }
    for (i = 0; i < n; i++)
      System.out.print(a[i] + " ");

  }

//  private static void swap(long[] a, int i, int j) {
//    while(i<j){
//      long temp  = a[i];
//      a[i] = a[j];
//      a[j] = temp;
//      i++;
//      j--;
//    }
//    
//  }

}
