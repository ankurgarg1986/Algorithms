package topcoderProblems;

public class SimilarUserDetection {
	public static String haveSimilar(String[] h) {
		int i = 0;
		int j = 0;
		for (i = 0; i < h.length; i++) {
			String s = h[i];
			for (j = 0; j < s.length(); j++) {
				if (s.charAt(j) == '0' || s.charAt(j) == 'I'
						|| s.charAt(j) == '1' || s.charAt(j) == 'O'
						|| s.charAt(j) == 'l') {
					s = s.replace(s.charAt(j), 'x');
				}
			}
			h[i] = s;
		}
		System.out.println("String are : ");
		for (i = 0; i < h.length; i++) {
			System.out.println(h[i]);
		}
		for (i = 0; i < h.length - 1; i++) {
			for (j = i + 1; j < h.length; j++) {
				if (h[i].equals(h[j])) {
					return "Similar handles found";
				}
			}
		}
		return "Similar handles not found";

	}

	public static void main(String[] args)
{

   String[] s = {"I1010O", "11O1lOI10l10llOO0O0OI01OO00O01ll01", "1llO00I0Ol0OllO0Ol1lIlI1OO1lIIl1l1lI00O0O1ll10", "I1I0I10OlIllO10ll11llI", "0lOl0l111l0l0", "I0lOlII0011O10O0OI0OlO1Ol0lI1IIOlOlO11", "Il1O0OOl1OOl00l", "1lIIl01IOI101ll110I1l0I01IOl1", "1IO1lO011O000110I0l01O1OlIlO0O0I1l0IO1OI1OO0l", "ll1O01OOO0I000ll11Ol", "IO1lIO0101III10101l0O1OIIOIl0lOl10lOOlOl", 
		   "110O0IOIlOO1II0I0O001", "IOO0IO1I0lOIIOlIOl1IOII0O00111I01lI000110Il1100I1l", "O0lO0O0IlI10O0", "Ill0I0IllIl1l101OIO000O00llIO0OO0lO0O11I1", "lOI111OllO0IOl10lOOlOl0OI1I0OI0O", 
		   "0IlI1O0OlIOl1Ill10lIOO0I", "1", "l0I110IOOO0OlI1I11OlI", "1OI0O0I1l11ll", "ll0ll000lOl0OllIOOI0110lIl1l00O0011llOll1Ol", "lO0IOll1l0Oll0IllIIl00lO1l0", "Il00lOlI0l0IO1lOO001IO01OO1l", "OII010O00", "0lIIO1OOIllIO0lOIOll1O01OIlO1lOOIOII011IIlOIl", "O0OIOII11llI0I10Illl110I110IIlOOlIOO0lOIO100O1I0", "IlO101111IO0I11O1lOlOl1", "0O011I11lI0OOII1OO100IlI01l1I10011Ol110IO", "1ll0OII1ll1OOI0IOOIIIIO00OOO0lOl10", "l0I00100Il1IIOII1OOOO0O010", "1Il1IlO1I010OIOlI11ll0l1O11lIOIIl1ll01I0lI011O11", "IlOOOIIl1I", "O1l0l1O00l0I00I1OI00O0l", "11ll0O010O0O00l01I0Ill01lI", "l01I0OlO1OI01OO0l1l1IOOI11l1II01O0IlO0lOOlOO0l1lI", "lI0l11I0I0OIOllO1l1O0IIOl1OI1IlOlIOO0I", "lO0OIIl10", "OlOlOOO11OO111", "10O0lO0lIO11II101l1IIIl0OIllOO", "OIIOOlI1l001ll0Il1l10Il0II001IO1OIO10"};
   System.out.println(haveSimilar(s));
}
}
