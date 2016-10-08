package javaPractice;

class Test1 {
	   int i = 10;
	}
	 
	public class Test2 {
	    public static void main(String args[]) {
	       Test1 t1 = new Test1();
	       Test1 t2 = new Test1();
	      t1 = t2; 
	      String s = "ac";
	    }
	}
