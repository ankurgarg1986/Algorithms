package stacks;

import java.util.Stack;

public class LargestHistogram {

	public static void main(String[] args) {
		int[] hist = { 6, 2, 5, 4, 5,1,6 };
		int n = hist.length;
		System.out.println(getMaxArea(hist, n));
//		return 0;

	}

	private static int getMaxArea(int[] a, int n) {
	  int ans =0;
	  Stack<Integer> s = new Stack<Integer>();
	  int i=0;
	  while(i<n)
	  {
		  if(s.empty() || a[s.peek()] <= a[i]){
			  s.push(i++);
		  }
		  else{
			  int tp = s.peek();
			  //get the top
			  s.pop();
			  int area = a[tp]*(s.empty() ? i :i-s.peek()-1);
			  ans = Math.max(ans, area);
		  }
	  }
	  return ans;
	}
	 
	
}
