package Strings;

import java.util.Arrays;

public class CountKSubStr {

	public static void main(String[] args)
    {
        CountKSubStr ob = new CountKSubStr();
        String ch = "abcbaa";
        int k = 3;
        System.out.println("Total substrings with exactly " +
                           k +  " distinct characters : "
                           + ob.countkDist("aba", k));
        System.out.println("Total substrings with exactly " +
                k +  " distinct characters : "
                + ob.countkDist1("aba", k));
    }
	
	int countkDist1(String str, int k)
    {
        // Initialize result
        int res = 0;
 
        int n = str.length();
 
        // To store count of characters from 'a' to 'z'
        int cnt[] = new int[26];
 
        // Consider all substrings beginning with
        // str[i]
        for (int i = 0; i < n; i++)
        {
            int dist_count = 0;
 
            // Initializing count array with 0
            Arrays.fill(cnt, 0);
 
            // Consider all substrings between str[i..j]
            for (int j=i; j<n; j++)
            {
                // If this is a new character for this
                // substring, increment dist_count.
                if (cnt[str.charAt(j) - 'a'] == 0)
                    dist_count++;
 
                // Increment count of current character
                cnt[str.charAt(j) - 'a']++;
 
                // If distinct character count becomes k,
                // then increment result.
                if (dist_count == k){
                    res++;
                   // System.out.println(str.substring(i,j+1));
                }
            }
        }
 
        return res;
    }

	private int countkDist(String s, int k) {
		
		int[] cnt = new int[26];
		int c = 0;
		int n = s.length();
		int i,j;
		int ans = 0 ;
		for(i=0;i<n;i++)
		{
			c = 0;
			for(j=i;j<n;j++){
				if(cnt[s.charAt(j)-'a']-i ==0){
					//first time seen so distinct
					c++;
					cnt[s.charAt(j)-'a']++;
				}	
				if(c==k){
					ans++;
					//System.out.println(s.substring(i,j+1));
				}
			}
		}
		return ans;
	}

}
