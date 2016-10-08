package topcoderProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ropestring {

	private int infexOf(int[] f, boolean[] usedF, int number) {
	    for(int i=0;i<f.length;++i){
	      if(f[i]==number&&!usedF[i]){
	        return i;
	      }
	    }
	    return -1;
	  }
	 public int mindiff(int[] a, int[] b, int[] f) {
		    
		    int n = a.length;    
		    
		    boolean[] usedF = new boolean[f.length];
		        
		    int difference = 0;
		    int fLeft = f.length;
		    
		    for(int i=0;i<n;++i){
//		      System.out.println(i);
		      if(a[i]!=b[i]){
		        int fIndex = infexOf(f,usedF,b[i]);
//		        System.out.println(fIndex);
		        if(fIndex>-1){
		          usedF[fIndex] = true;
		          fLeft--;
		        }else{
		          difference++;
		        }
		      }
		    }
		        
		    if(fLeft>0){
		      for(int i=0;i<n;++i){
		        if(a[i]==b[i]){
		          int fIndex = infexOf(f,usedF,b[i]);
		          if(fIndex>-1){
		            usedF[fIndex] = true;
		            fLeft--;            
		          }
		        }
		        if(fLeft==0){
		          break;
		        }
		      }      
		    }      
		    
		    return Math.max(difference,fLeft);
		  }
		 
		  
	
	public static int  mindiff1(int[] a, int[] b, int[] c) {
		int ans;
		List<Integer> f = new ArrayList<Integer>();
		int i;
		int n = a.length;
		ans = n;
		for (i = 0; i < c.length; i++) {
			f.add(c[i]);
		}
		for (i = 0; i < n; i++) {
			if (a[i] == b[i]) {
				ans--;
				// continue;
			} else {
				if (f.contains(b[i])) {
					ans--;
					f.remove(new Integer(b[i]));
					a[i] = -1;// already replaced
					b[i] = -1;
				}
			}
		}
		i = 0;
		int j;
		n = f.size();
		int m = b.length;
		for (i = 0; i < n; i++) {
			boolean remove = false;
			for (j = 0; j < m; j++) {
				if (b[j] == f.get(i)) {
					// f.remove(new Integer(b[i]));
				   if(a[j]==b[j]){
					   //nothing to do just replace
					   b[j] = -1;
					   a[j] =-1;
					   //break;
				   }else{
					   ans--;
					   a[j] = -1;
					   b[j] = -1;
				   }
				   remove = true;
				   break;
				}
			}
			if (!remove) {
				// no element matched
				int k=0;
				while(k<m && a[k]==b[k]){
					k++;
				}
				if(k==m){
					ans++;//all elements 
					k=0;
					while(a[k]==-1 && b[k] ==-1){
						k++;
					}
					
					}
				}
				//ans++;
			}

		}

		return ans;
	}


	public static String makerope(String s) {
		int n = s.length();
		int i;
		List<String> dash = new ArrayList<String>();
		String res = "";
		String d = "";
		int cP = 0;
		int cD = 0;
		for (i = 0; i < n; i++) {
			if (s.charAt(i) == '-') {
				while (i < n && s.charAt(i) == '-') {
					d = "-" + d;
					cD++;
					i++;
				}
			}
			if (i < n && s.charAt(i) == '.') {
				cP++;
			}
			if (cD > 0 && cD % 2 == 0) {
				// even found
				res = res + d;
				if (cP > 0) {
					res = res + ".";
					cP--;
				}
				d = "";
				cD = 0;
			} else {
				if (d.length() > 0) {
					dash.add(d);
					cD = 0;
					d = "";
				}
			}
		}
		int j = dash.size();
		int k = 0;
		while (k < j) {
			res = res + dash.get(k);
			k++;
			// j--;
			if (cP > 0) {
				res = res + ".";
				cP--;
			}

		}
		while (cP > 0) {
			res = res + ".";
			cP--;
		}
		return res;
	}

	public static void main(String[] args) {
		int[] a = {757, 293, 186, 293, 983, 809, 174, 559, 482, 314, 536, 913, 983, 809, 314, 946, 317, 145,
			162, 174, 293, 647, 536, 115, 174, 660, 702, 482, 356, 54, 787, 559, 162, 787, 467, 322, 197,
			809, 186};
		int[] b ={314, 356, 809, 186, 983, 467, 356, 946, 482, 356, 647, 264, 672, 467, 174, 467, 983,
				946, 54, 536, 314, 647, 314, 186, 833, 809, 45, 356, 115, 130, 293, 660, 467, 162, 197, 536, 54,
				54, 787};
		int[] c = {787, 536, 54, 115, 672, 559, 197, 317, 314, 482, 660, 536, 482, 559, 559};
		System.out.println(mindiff(a,b,c));
	}

}