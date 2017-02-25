package leetcode;

public class P418SentenceFitting {

  public static int wordsTyping(String[] s, int r, int c) {
    int i, j, k;
    j = 0;// row
    k = 0;// column
    i = 0;
    int ans = 0;
    while (j < r) {
      String s1 = s[i];
      if (k + s1.length() <= c) {
        k += s1.length();
        k++;// for space
        i++;
      } else {
        j++;
        k = 0;
      }
      if (i == s.length) {
        ans++;
        i = 0;
      }
  
    }
    return ans;
  }

  public static int wordsTypingBinarySearch(String[] s, int r, int c) {
    int i, j, k;
    j = 0;// row
    i = 0;// column
    i = 0;
    int n = s.length;
    int ans = 0;
    int[] dp = new int[n];
    dp[0] = s[0].length();
    for(i=1;i<n;i++){
      dp[i] += dp[i-1] + 1 + s[i].length();
    }
    int l = 0;
    int h = n-1;
    for(i=0;i<r;i++){
      int idx = binarySearch(l,h,c,dp);
      if(idx == -1) return 0;
      c += 1 + dp[idx];
      idx++;
      idx = idx % n;
      l =idx;
      if(idx == 0) ans++; 
    }
   
 
    return ans;
  }

  private static int binarySearch(int l,int h, int c, int[] dp) {
   int n = dp.length;
   int l1 = l;
   int h1 = h;
    while(l<h){
      int m  = l + (h-l+1)/2;
      if(dp[m] == c){
        return m;
      }
      if(dp[m] < c){
        l = m;
      }
      else if(dp[m] > c){
        h = m-1;
      }
      
    }
    if(dp[l1] > c) return -1;
    return l;
    
  }
  
  public static int wordsTyping1(String[] sentence, int rows, int cols) {
    int[] nextIndex = new int[sentence.length];
    int[] times = new int[sentence.length];
    for(int i=0;i<sentence.length;i++) {
        int curLen = 0;
        int cur = i;
        int time = 0;
        while(curLen + sentence[cur].length() <= cols) {
            curLen += sentence[cur++].length()+1;
            if(cur==sentence.length) {
                cur = 0;
                time ++;
            }
        }
        nextIndex[i] = cur;
        times[i] = time;
    }
    int ans = 0;
    int cur = 0;
    for(int i=0; i<rows; i++) {
        ans += times[cur];
        cur = nextIndex[cur];
    }
    return ans;
}

  public static void main(String[] args) {
    String[] s = { "I", "had", "apple", "pie"};
    System.out.println(wordsTyping1(s, 4, 5));
  }

}
