package topcoderProblems;


import java.util.*;
/**
 * 
 * @author agarg
 * Solution for Problem https://community.topcoder.com/stat?c=problem_statement&pm=2356
 * Problem for Single Round Match 184 Round 1 - Division II, Level Three.
 * This is a straight forward implementation for FloydWarshal Algorithm. 
 *
 */
public class TeamBuilder {
    public int[] specialLocations(String[] paths) {
        int[] res = new int[2];
        int canReach = 0;
        int reachable = 0;
        int maxm = 9999;
        int n = paths.length;
        int[][] dp  = new int[n][n];
        int i=0;
        int j= 0;
        for(i = 0;i<n;i++)
        {
        	for(j=0;j<n;j++)
        	{
        		dp[i][j] = paths[i].charAt(j) - 48;
        		if(dp[i][j] == 0)
        		{
        			dp[i][j] = maxm;
        		}
        	}
        }
        int k = 0;
        for(k=0;k<n;k++)
        {
        	for(i=0;i<n;i++)
        	{
        		for(j=0;j<n;j++)
        		{
        			
        			if(i==j) {
        				dp[i][j] = maxm;
        				continue;
        			}
        			dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
        		}
        	}
        }
        int cnt = 0;
        for(i=0;i<n;i++)
        {
        	cnt = 0;
        	for(j=0;j<n;j++)
        	{
        		if(dp[i][j] != maxm)
        		{
        			cnt++;
        		}
        	}
        	if(cnt == n-1)
        	{
        		canReach++;
        	}
        }
        cnt = 0;
        for(j=0;j<n;j++)
        {
            cnt = 0;
        	for(i=0;i<n;i++)
        	{
        		if(dp[i][j] != maxm)
        		{
        			cnt++;
        		}
        	}
        	if(cnt == n-1)
        	{
        		reachable++;
        	}
        }
        res[0] = canReach;
        res[1] = reachable;
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new TeamBuilder()).specialLocations(new String[] {"010","000","110"}),new int[] { 1,  1 });
            eq(1,(new TeamBuilder()).specialLocations(new String[] {"0010","1000","1100","1000"}),new int[] { 1,  3 });
            eq(2,(new TeamBuilder()).specialLocations(new String[] {"01000","00100","00010","00001","10000"}),new int[] { 5,  5 });
            eq(3,(new TeamBuilder()).specialLocations(new String[] {"0110000","1000100","0000001","0010000","0110000","1000010","0001000"}),new int[] { 1,  3 });
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
