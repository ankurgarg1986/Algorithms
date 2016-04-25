package topcoderProblems;

// BEGIN CUT HERE

// END CUT HERE
import java.util.*;
public class ParenthesesDiv2Medium {
    public int[] correct(String st) {
//    	Integer[] integers = new Integer[] {1,2,3,4,5};
//    	List list21 =  Arrays.asList(integers);  	
    	List<Integer> ans = new ArrayList<Integer>();
    	StringBuffer s = new StringBuffer(st);
    	int n  = s.length();
        int a = n/2 + 1;
        int cnt0 = 0;//(
        int cnt1 = 0;//)
        int i = 0;
        for(i=0;i<n;i++)
        {
        	if(s.charAt(i) == '(')
        		cnt0++;
        	else 
        		cnt1++;
        }
        int diff = cnt0 - cnt1; //if negetive then ) to ( else ( to )
        int cnt00 = 0;
        int cnt11 = 0;
        int j = 0;
        for(i=0;i<n;i++)
        {
        	if(s.charAt(i) == '('){
        		cnt00++;
        	}
        	else{ 
        		cnt11++;
        	}
        	if(cnt11 > cnt00)
        	{
        		s.replace(i, i+1, "(");
        		//s.insert(i, '(');
        		ans.add(i);
        		j++;
        		cnt11 --;
        		cnt00++;
        		diff += 2;
        	}
        	else if(cnt00 > cnt11+1  && diff > 0)
        	{
        		s.replace(i, i+1, ")");
        		diff -= 2;
        		cnt00--;
        		cnt11++;
        		ans.add(i);
        		j++;
        	}
        	
        }
//        for(i=0;i<j;i++)
//        {
//        	System.out.println(st.charAt(i));
//        }
        
        int[] res = new int[j];
        System.out.println("Ans is ");
        for(i=0;i<j;i++)
        {
        	res[i] = ans.get(i);
        }
        for(i=0;i<j;i++)
        {
        	System.out.print(res[i]);
        }
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
           // eq(0,(new ParenthesesDiv2Medium()).correct(")("),new int[] {0, 1 });
            //eq(1,(new ParenthesesDiv2Medium()).correct(")))))((((("),new int[] {0, 2, 4, 5, 7, 9 });
            //eq(2,(new ParenthesesDiv2Medium()).correct("((()"),new int[] {1 });
        	eq(2,(new ParenthesesDiv2Medium()).correct(")()("),new int[] {0, 3 });
            eq(3,(new ParenthesesDiv2Medium()).correct(")))(()(())))))"),new int[] {0, 1, 2 });
            eq(4,(new ParenthesesDiv2Medium()).correct("()()()()()()()()()()()()()"),new int[] { });
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }
    private static void eq( int n, int a, int b ) {
        if ( a==b )
            System.err.println("Case "+n+" passed.");
        else
            System.err.println("Case "+n+" failed: expected "+b+", received "+a+".");
    }
    private static void eq( int n, char a, char b ) {
        if ( a==b )
            System.err.println("Case "+n+" passed.");
        else
            System.err.println("Case "+n+" failed: expected '"+b+"', received '"+a+"'.");
    }
    private static void eq( int n, long a, long b ) {
        if ( a==b )
            System.err.println("Case "+n+" passed.");
        else
            System.err.println("Case "+n+" failed: expected \""+b+"L, received "+a+"L.");
    }
    private static void eq( int n, boolean a, boolean b ) {
        if ( a==b )
            System.err.println("Case "+n+" passed.");
        else
            System.err.println("Case "+n+" failed: expected "+b+", received "+a+".");
    }
    private static void eq( int n, String a, String b ) {
        if ( a != null && a.equals(b) )
            System.err.println("Case "+n+" passed.");
        else
            System.err.println("Case "+n+" failed: expected \""+b+"\", received \""+a+"\".");
    }
    private static void eq( int n, int[] a, int[] b ) {
        if ( a.length != b.length ) {
            System.err.println("Case "+n+" failed: returned "+a.length+" elements; expected "+b.length+" elements.");
            return;
        }
        for ( int i= 0; i < a.length; i++)
            if ( a[i] != b[i] ) {
                System.err.println("Case "+n+" failed. Expected and returned array differ in position "+i);
                print( b );
                print( a );
                return;
            }
        System.err.println("Case "+n+" passed.");
    }
    private static void eq( int n, long[] a, long[] b ) {
        if ( a.length != b.length ) {
            System.err.println("Case "+n+" failed: returned "+a.length+" elements; expected "+b.length+" elements.");
            return;
        }
        for ( int i= 0; i < a.length; i++ )
            if ( a[i] != b[i] ) {
                System.err.println("Case "+n+" failed. Expected and returned array differ in position "+i);
                print( b );
                print( a );
                return;
            }
        System.err.println("Case "+n+" passed.");
    }
    private static void eq( int n, String[] a, String[] b ) {
        if ( a.length != b.length) {
            System.err.println("Case "+n+" failed: returned "+a.length+" elements; expected "+b.length+" elements.");
            return;
        }
        for ( int i= 0; i < a.length; i++ )
            if( !a[i].equals( b[i])) {
                System.err.println("Case "+n+" failed. Expected and returned array differ in position "+i);
                print( b );
                print( a );
                return;
            }
        System.err.println("Case "+n+" passed.");
    }
    private static void print( int a ) {
        System.err.print(a+" ");
    }
    private static void print( long a ) {
        System.err.print(a+"L ");
    }
    private static void print( String s ) {
        System.err.print("\""+s+"\" ");
    }
    private static void print( int[] rs ) {
        if ( rs == null) return;
        System.err.print('{');
        for ( int i= 0; i < rs.length; i++ ) {
            System.err.print(rs[i]);
            if ( i != rs.length-1 )
                System.err.print(", ");
        }
        System.err.println('}');
    }
    private static void print( long[] rs) {
        if ( rs == null ) return;
        System.err.print('{');
        for ( int i= 0; i < rs.length; i++ ) {
            System.err.print(rs[i]);
            if ( i != rs.length-1 )
                System.err.print(", ");
        }
        System.err.println('}');
    }
    private static void print( String[] rs ) {
        if ( rs == null ) return;
        System.err.print('{');
        for ( int i= 0; i < rs.length; i++ ) {
            System.err.print( "\""+rs[i]+"\"" );
            if( i != rs.length-1)
                System.err.print(", ");
        }
        System.err.println('}');
    }
    private static void nl() {
        System.err.println();
    }
// END CUT HERE
}
