package Numbers;

public class ZeroDigit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int n = 107;
        System.out.println(countZeros(n));
	}

	private static int countZeros(int n) {
		int ans = 0;
		int d = countDigits(n);
		ans += countZeroDigits(d-1);
		//ans += countRemaining(n,d);
		return ans;
	}

	private static void countRemaining(int n, int d) {
		
	}

	private static int countZeroDigits(int d) {
		double res = (Math.pow(10, d-1) - Math.pow(9, d-1));
		return (int) res;
	}

	private static int countDigits(int n) {
		int d = 0;
		while(n > 0)
		{
			n = n/10;
			d++;
		}
		return d;
	}
	

}
