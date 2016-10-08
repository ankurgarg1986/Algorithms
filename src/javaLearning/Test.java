package javaLearning;

class Base {

	// Static method in base class which will be hidden in subclass
	public static void display() {
		System.out.println("Static or class method from Base");
	}

	// public static void date() {
	// System.out.println("Static or class method from Derived");
	// }
	//
	// Non-static method which will be overridden in derived class
	public void print() {
		System.out.println("Non-static or Instance method from Base");
	}
}

// Subclass
class Derived extends Base {

	// This method hides display() in Base
	public static void display() {
		System.out.println("Static or class method from Derived");
	}

	public static void date() {
		System.out.println("Static or class method from Derived");
	}

	// This method overrides print() in Base
	public void print() {
		System.out.println("Non-static or Instance method from Derived");
	}
}

// Driver class
public class Test {
	public static void main(String args[]) {
		Derived obj1 = new Derived();
        Base obj2 = obj1;
        obj1.date();
		// As per overriding rules this should call to class Derive's static
		// overridden method. Since static method can not be overridden, it
		// calls Base's display()
		obj1.display();
		

		// Here overriding works and Derive's print() is called
		// obj1.print();
	}
}
