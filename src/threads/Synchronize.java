package threads;


public class Synchronize {

  public static void main(String[] args) { 
    
    TwoSums t =  new TwoSums();
    Thread t1 = new Thread(new Runnable(){
      @Override
      public void run() {
       // TwoSums t =  new TwoSums();
        t.add(10,20);
      }
      
    });
    
    Thread t2 = new Thread(new Runnable(){

      @Override
      public void run() {    
       
        t.add(100,200);
      }
      
    });
    t1.start();
    t2.start();
  }
}
