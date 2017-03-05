package leetcodeContest;


public class Contest22P2 {

  public int findLonelyPixel(char[][] p) {
    int i,j;
    int ans = 0;
    int m = p.length;
    int n = p[0].length;
    int[] rowCount = new int[m];
    int[] colCount = new int[n];
    for(i=0;i<m;i++){
        for(j=0;j<n;j++){
            if(p[i][j] == 'B'){
                //row i,column j
                rowCount[i] ++;
                colCount[j]++;
            }
        }
    }
    for(i=0;i<m;i++){
      for(j=0;j<n;j++){
        if(p[i][j] == 'B'){
                //row i,column j
             if(rowCount[i] == 1 && colCount[j]==1) ans++;
        }
      }
    }
    return ans;
}
}
