package javaPractice;

import java.util.concurrent.CyclicBarrier;

public class CustomLatch {

  final Object lock = new Object();
  int num;
  CyclicBarrier cb = new CyclicBarrier(2);

  public CustomLatch(int num) {
    this.num = num;
  }

  public void await() throws InterruptedException {
    synchronized (this) {
      if (this.num > 0) {
       // wait();
        System.out.println("Do Nothing");
      }
    }
  }

  public int getCount() {
    return this.num;
  }

  public void countDown() {
    synchronized (this) {
      num--;
      System.out.println("Locked");
      if (num == 0) {
        this.notifyAll();
      }
    }
  }
}
