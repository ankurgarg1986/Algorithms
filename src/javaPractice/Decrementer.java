package javaPractice;

import java.util.concurrent.CountDownLatch;


public class Decrementer implements Runnable {

  CustomLatch latch = null;

  public Decrementer(CustomLatch latch) {
      this.latch = latch;
  }
  @Override
  public void run() {
    try {
      Thread.sleep(1000);
      this.latch.countDown();

      Thread.sleep(1000);
      this.latch.countDown();

//      Thread.sleep(3000);
//      this.latch.countDown();
  } catch (InterruptedException e) {
      e.printStackTrace();
  }
  }

}
