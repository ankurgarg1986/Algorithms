package graphs;

import java.util.Arrays;

/**
 * Solution for Stable Marriage Problem in Java
 * Problem Statement  http://www.geeksforgeeks.org/stable-marriage-problem/
 * 
 */
public class StableMarriage {

	public static void main(String[] args) {
		int prefer[][] = { {7, 5, 6, 4},
		        {5, 4, 6, 7},
		        {4, 5, 6, 7},
		        {4, 5, 6, 7},
		        {0, 1, 2, 3},
		        {0, 1, 2, 3},
		        {0, 1, 2, 3},
		        {0, 1, 2, 3},
		    };
		    int[] womenPartner = stableMarriage(prefer);
		    //PrintOut the partners 
		    printPartners(womenPartner);
		 

	}
	
	
	private static void printPartners(int[] womenPartner) {
		for(int i=0;i<womenPartner.length;i++)
		{
			int x = i + womenPartner.length;
			System.out.println("Partner for women  " + x  + " is " + womenPartner[i]);
		}
		
	}


	private static int[] stableMarriage(int[][] prefer) {
		// TODO Auto-generated method stub
		int n  = prefer.length/2;
		boolean[] freeMen  = new boolean[n];
		int[] womenPartner = new int[n];
		Arrays.fill(womenPartner, -1);
		Arrays.fill(freeMen, true);
		int i;
		int j;
		int freeCount  = n;
		//Men have to be assigned partners
		while(freeCount > 0)
		{
			
		   //find first freeMan 
		   for(j=0;j<n;j++)
		   {
			   if(freeMen[j])	
					   break;
		   }
		   for(i=0;i<n && freeMen[j];i++)
		   {
			  //see what partner this freeMan desires
			   int  w = prefer[j][i];
			   int cp = womenPartner[w-n]; // see what is the current partner
			   if(cp == -1)
			   {
				   //no partner assigned 
				   womenPartner[w-n] = j;
				   freeMen[j] = false;
 				   freeCount --;
			   }
			   else
			   {
				   //she already has a partner lets check if the guy is lucky
				   if(isNewManMoreDesirable(cp,j,prefer,w))
				   {
					  womenPartner[w-n] = j;
					  freeMen[cp] = true;
					  freeMen[j] = false;
				   }
			   }
				
		   }
		}
		return womenPartner;	
	}
	
	/**
	 * Checks if new Partner More desirable  
	 * @param cp
	 * @param np
	 * @param prefer
	 * @param w
	 */
	private static boolean isNewManMoreDesirable(int cp, int np,int[][] prefer, int w) {
		  int n = prefer.length;
		  int i;
		  for(i=0;i<n;i++)
		  {
			  if(prefer[w][i] == cp)
			  {
				  return false;
			  }
			  if(prefer[w][i] == np)
			  {
				  return true;
			  }
		  }
		 return false; //code wont reach here unless the test case is wrong
	}

}
