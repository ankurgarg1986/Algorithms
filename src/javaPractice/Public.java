package javaPractice;

import java.util.Hashtable;

class X{
	int c;
	public X(int C){
		this.c = C;
	}
}
public class Public {

	Hashtable<String,String> ht = new Hashtable<String,String>(); 
	final  private X x;
	
	public Public(X a){
		this.x = a;
	}
	public X A(X b){
		this.x.c = b.c;
		return this.x;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        X x1 = new X(19);
        X x2 = new X(20);
        Public p1 = new Public(x1);
        p1.x = x2;
	}

}
