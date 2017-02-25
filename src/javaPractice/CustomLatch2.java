package javaPractice;


public class CustomLatch2 {
    int num;
    Object lock;
    
    public CustomLatch2(int num){
      this.num  = num;
      lock = new Object();
    }
     
    public void await() throws InterruptedException{
      while(this.num > 0){
        wait();
      }
    }
    
    public int getCount(){
      return this.num;
    }
    
    
    public void countDown(){
      synchronized(lock){
          this.num--;
          if(this.num ==0) notifyAll();
      }
    }
}



