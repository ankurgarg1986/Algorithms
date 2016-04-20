package dynamicProgramming;

public class ArrangeAdjacentBalls {

	public static void main(String[] args) {
		int p = 6,q=6,r=16;
		System.out.println("No Of Ways to arrange is " + waysToArrangeRecursion(p,q,r));

	}

	private static int  waysToArrangeRecursion(int p, int q, int r) {
		 return (waysRecursionUtil(p,q,r,0) + waysRecursionUtil(p,q,r,1) + waysRecursionUtil(p,q,r,2));
	}

	private static int waysRecursionUtil(int p, int q, int r, int x) {
		 if(p<0 || q<0 || r<0 ) return 0;
		 if(p==1 && q==0 && r==0 && x==0 )
			 return 1;
		 if(q==1 && p==0 && r==0 && x==1 )
			 return 1;
		 if(r==1 && p==0 && q==0 && x==2 )
			 return 1;
		 if(x==0)
			 return waysRecursionUtil(p-1,q,r,1) + waysRecursionUtil(p-1,q,r,2);
		 if(x==1)
			 return waysRecursionUtil(p,q-1,r,0) + waysRecursionUtil(p,q-1,r,2);
		 else
			 return waysRecursionUtil(p,q,r-1,0) + waysRecursionUtil(p,q,r-1,1);
	}

}
