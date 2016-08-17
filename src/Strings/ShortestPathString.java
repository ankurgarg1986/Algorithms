package Strings;

public class ShortestPathString {

	public static void main(String[] args) {
		char[] c = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
				'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
				'X', 'Y', 'Z' };
		// };
		String s = "GEEK";
		printCommands(s, c, 0);

	}

	private static void printCommands(String s, char[] c, int x) {

		int i,d = 0;
		char c2;
		for (i = 0; i < s.length(); i++) {
			char c1 = s.charAt(i);
			if (i == 0)
				c2 = c[x];
			else
				c2 = s.charAt(i-1);
			System.out.println("c1 is " + c1 + " And c2 is " + c2);
			int r1 = (c1 - 'A') / 5;
			int r2 = (c2 - 'A') / 5;
			int rd  = r1-r2;
			//System.out.println(rd);
			while(rd > 0){
				System.out.println("Move Down");
				rd--;
				c2 = (char) (c2 + 5);
			}
			while(rd<0){
				System.out.println("Move Up");
				rd++;
				c2 = (char)(c2-5);
			}
			if (rd==0) {
				 d = c2 - c1;
			//	 System.out.println(" d is " + d);
				if (d > 0) {
					while (d > 0) {
						d--;
						System.out.println("Move left");
					}
				}else{
					while(d<0){
						d++;
						System.out.println("Move Right");
					}
				}

			}
			if(d==0) System.out.println("Ok");

		}

	}
}
