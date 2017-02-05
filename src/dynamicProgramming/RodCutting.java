package dynamicProgramming;


public class RodCutting
{
    /* Returns the best obtainable price for a rod of
       length n and price[] as prices of different pieces */
    static int cutRod(int price[],int n)
    {
        int dp[] = new int[n+1];
        dp[0] = 0;
 
        // Build the table val[] in bottom up manner and return
        // the last entry from the table
        for (int i = 0; i<price.length; i++)
        {
            //int max_val = Integer.MIN_VALUE;
            for (int j = 1; j <= n; j++)
             if(j-i-1>=0)  dp[j] = Math.max(dp[j], dp[j-i-1]+price[i]);
                                   
            //val[i] = max_val;
        }
 
        return dp[n];
    }
 
    /* Driver program to test above functions */
    public static void main(String args[])
    {
        int arr[] = {2  ,5   ,9   ,9  ,10  ,17  ,17  ,120};
        int size = arr.length;
        System.out.println("Maximum Obtainable Value is " +
                            cutRod(arr, 6));
    }
}