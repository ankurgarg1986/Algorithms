package matrix;


public class PrintAllSorted {

  static int inf = 9999;
  public static void main(String[] args) {
    int N = 4;
    int mat[][] = { {10, 20, 30, 40},
                      {15, 25, 35, 45},
                      {27, 29, 37, 48},
                      {32, 33, 39, 50},
                    };
    printSorted(mat,N);

  }

  private static void printSorted(int[][] mat,int N) {
          for(int i = 0;i<N*N;i++){
             int res = printSortedUtil(mat,N);
             System.out.print(res + " ");
          }
          
    
  }

  private static int printSortedUtil(int[][] mat, int n) {
    int res = mat[0][0];
    mat[0][0] = inf;
    youngify(mat,0,0,n);
    return res;
  }

  private static void youngify(int[][] mat,int i,int j,int N) {
      if(i>=N || j>=N) return;
      int dVal = (i+1<N) ? mat[i+1][j] : inf;
      int rVal = (j+1<N) ? mat[i][j+1] : inf;
      if(dVal == inf && rVal == inf) return;
      if(dVal < rVal){
          mat[i][j] = dVal;
          mat[i+1][j] = inf;
          youngify(mat,i+1,j,N);
      }else{
          mat[i][j] = rVal;
          mat[i][j+1] = inf;
          youngify(mat,i,j+1,N);
      }
  }

}
