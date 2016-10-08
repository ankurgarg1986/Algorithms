package ArraysPractice;

public class TestABC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		    int[] a = {-5,3,-7,-10,2,6,-4,4};
		    int n = a.length;
		    int i = 0;
		    int j = 1;
		    int k;
		    while(i<n && j<n){
		        if(a[i] * a[j] < 0){
		           i++;
		           j++;
		        }else{
		            k= j;
		            while(k< n && j<n){
		                if(a[i]*a[j] < 0){
		                    int temp = a[k];
		                    a[k] = a[j];
		                    a[j] = temp;
		                    //swap(a[k],a[j]);
		                   if(k+1< n && k+1 < j){
		                     //swap(a[k+1],a[j]);
		                     temp = a[k+1];
		                     a[k+1] = a[j];
		                     a[j] = temp;
		                   }
		                   break;
		                }else{
		                    j++;
		                }    
		            }
		            j = k;
		            i++;
		            j++;
		        }
		    }
		    for(i= 0;i<n;i++){
		       System.out.print(a[i] + " ");
		    }
	}

}
