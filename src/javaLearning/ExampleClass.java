package javaLearning;

public class ExampleClass extends Thread{
 
    public static void main(String[] args) {
 
    	StringBuffer s1 = new StringBuffer("Ankur");
    	StringBuffer s2 = new StringBuffer("Ankur");
    	StringBuffer s3 = s2;
    	if(s3.equals(s2)) System.out.println("True");
    	
    	
        // Upcasting from subclass to super class.
        A aRef=new B();
 
        aRef.display();//Am in class C
        //Downcasting of reference to subclass reference.
        //C bRef=(C) aRef; //ERROR
        //bRef.display();
    }
}
 
interface A 
{
  void display();
}
 
class B implements A
{
 
    public void display() {
        System.out.println("Am in class B");
    }
 
}
 
class C extends B
{
    @Override
    public void display() {
        System.out.println("Am in class C");
    }
     
}

