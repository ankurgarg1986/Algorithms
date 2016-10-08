package dynamicProgramming;

public class MinSquare {

	public static void main(String[] args) {
		int n = 6;
		System.out.println(MinSquares(n));

	}

	public static int MinSquares(int n)
	{
		if(n==0) return 0;
		if(n==1) return 1;
		int i=0;
		int ans = 0;
		i = (int) Math.sqrt(n);
		n = n-i*i;
		ans++;
		if(n==0) return ans; 
		ans += MinSquares(n);
		return ans;
	}
	
}
