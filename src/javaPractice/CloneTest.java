package javaPractice;


//An object reference of this class is
//contained by Test2
class Test {
	int x, y;
}

// Contains a reference of Test and implements
// clone with deep copy.
class TestX implements Cloneable {
	int a, b;

	Test c = new Test();

	public Object clone() throws CloneNotSupportedException {
		// Assign the shallow copy to new refernce variable t
		TestX t = (TestX) super.clone();

		t.c = new Test();

		// Create a new object for the field c
		// and assign it to shallow copy obtained,
		// to make it a deep copy
		return t;
	}
}

public class CloneTest {
	public static void main(String args[]) throws CloneNotSupportedException {
		TestX t1 = new TestX();
		t1.a = 10;
		t1.b = 20;
		t1.c.x = 30;
		t1.c.y = 40;

		TestX t3 = (TestX) t1.clone();
		t3.a = 100;

		// Change in primitive type of t2 will not
		// be reflected in t1 field
		t3.c.x = 300;

		// Change in object type field of t2 will not
		// be reflected in t1(deep copy)
		System.out.println(t1.a + " " + t1.b + " " + t1.c.x + " " + t1.c.y);
		System.out.println(t3.a + " " + t3.b + " " + t3.c.x + " " + t3.c.y);
	}
}