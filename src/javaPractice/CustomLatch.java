package javaPractice;

public class CustomLatch {

  final Object lock = new Object();
  int num;

  public CustomLatch(int num) {
    this.num = num;
  }

  public void await() throws InterruptedException {
     synchronized(lock){
       if(this.num > 0){
         lock.wait();
       }
     }
  }

  public int getCount() {
    return this.num;
  }

  public void countDown() {
    synchronized (lock) {
      num--;
      if (num == 0) {
           lock.notifyAll();
      }
    }
  }
}
