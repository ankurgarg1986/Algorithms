package codeforces;


public class C395P1 {
 
  static int size = 100001;
  public static void main(String[] args) {
    FastReader2 sc = new FastReader2(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int z = sc.nextInt();
    int[] nA = new int[z+1];
    int[] nB = new int[z+1];
    int x = n;
    int y = m;
    int j = 1;
    while(x <=z){
      nA[x] = 1;
      //j++; 
      x += n;
    }
    j=1;
    int ans = 0;
    while(y<=z){
      //y = y*j;
      nB[y] = 1;
      if(nA[y] == 1) ans++;
     // j++;
      y += m;
    }
    System.out.println(ans);

  }

}
