package javaPractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map.Entry;

class A implements Iterable{
	
	public void m1(){
		System.out.println("A m1");
	}
	
	public void m2(){
		System.out.println("A m2");
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}

class B extends  A{
	
	public void m1(){
		System.out.println("B m1");
	}
	
	public void m2(){
		System.out.println("B m2");
	}
	
	public void m3(){
		System.out.println("B m3");
	}
}

class C extends B{
	
	public void m1(){
		System.out.println("C m1");
	}
	
	public void m2(){
		System.out.println("C m2");
	}
	
	public void m3(){
		System.out.println("C m3");
	}
}
public class TestCast {

	public static void main(String[] args) {
		A a = new B();
		HashMap<String,String> hm = new HashMap<String,String>();
		List<Integer> l= new ArrayList<Integer>();
		ListIterator<Integer> lt = l.listIterator();
		Iterator<Entry<String,String>>it = hm.entrySet().iterator();
		//hm.keySet()
		String s ;
		Thread t = new Thread(new Runnable(){

			@Override
			public void run() {
				System.out.println("XYZ");
				
			}
			
			
		});
		t.start();
		a.m1();
		a.m2();
		B b = (B)a;
		b.m1();
		b.m2();
		b.m3();
		C c = new C();
		A a1 = (A)c;
		a1.m1();
		a1.m2();
		A a2 = new C();
		C c1 = (C)a2;
        if(c1 instanceof C){
    		System.out.println("Yes");
        	c1.m1();
    		c1.m2();	
        }
		B b2 = (B)a2;
		b2.m1();
		
		

	}

}
