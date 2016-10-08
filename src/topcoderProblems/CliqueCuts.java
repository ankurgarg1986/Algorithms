package topcoderProblems;

import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class CliqueCuts {
	public static int sum(int n, int[] a, int[] b, int[] c) {
		int ans = 0;
		
	
		int[][] g = new int[n][n];
		int i = 0;
		int j = 0;
		int sum = 0;
		int s = a.length;
		for (i = 0, j = 0; i < s && j < s; i++, j++) {
			int x = a[i];
			int y = b[j];
			g[x][y] = c[i];
			sum += c[i];
		}
		int k = 0;
		for(k=0;k<n;k++)
		{
			for(i=0;i<n;i++)
			{
				for(j=0;j<n;j++)
				{
					
				}
			}
		}
		return 0;
	}  
	 
	public static void main(String[] args) {
		int n = 5;
		int[] a = {0,0,0,0,1,1,1,2,2,3};
		int[] b =  {1,2,3,4,2,3,4,3,4,4};
		int[] c = {0,1,2,3,4,5,6,7,8,9};
		System.out.println(sum(n,a,b,c));
	}

}
