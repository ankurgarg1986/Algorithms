package javaPractice;

import java.util.concurrent.CountDownLatch;


public class Waiter implements Runnable {

  CustomLatch latch = null;

  public Waiter(CustomLatch latch) {
      this.latch = latch;
  }
  @Override
  public void run() {
    try {
      latch.await();
      System.out.println("U Rovl");
  } catch (InterruptedException e) {
    System.out.println("Interrupted");  
    e.printStackTrace();
  }

  System.out.println("Waiter Released");
  }

}
