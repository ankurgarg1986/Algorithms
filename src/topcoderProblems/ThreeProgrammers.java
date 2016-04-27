package topcoderProblems;


public class ThreeProgrammers {
	public static String validCodeHistory(String s) {

		String ans = "";
		int i = 0;
		int cntA = 0;
		int cntB = 0;
		int cntC = 0;
		for (i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'A')
				cntA++;
			if (s.charAt(i) == 'B')
				cntB++;
			if (s.charAt(i) == 'C')
				cntC++;
		}
		int n = s.length();
		int cNext = 0;
		int bNext = 0;
		while (n > 0) {
			if (cNext > 0)
				cNext--;
			if (bNext > 0)
				bNext--;
			if (cNext==0 && cntC>0 && (cntC>=cntB || bNext != 0)) {
				cNext = 3;
				ans += 'C';
				cntC--;
				
			} else if (bNext==0 && cntB > 0) {
                 bNext = 2;
                 ans += 'B';
                 cntB--;
			} else {
				if (cntA == 0)
					return "Impossible";
				else {
					ans += 'A';
					cntA--;
				}
			}
			n--;
		}

		return ans;

	}
	
	public static void main(String[] args) {
		String s = "ACABAABCCBCBAAABCCBCCABACBACBBACBACABBBACCCBBB";
		System.out.println(validCodeHistory(s));
	}
}
