package javaPractice;

import java.util.concurrent.CountDownLatch;


public class TestCountLatch {

  public static void main(String[] args) throws InterruptedException {
    CustomLatch latch = new CustomLatch(3);

    Waiter      waiter      = new Waiter(latch);
    Decrementer decrementer = new Decrementer(latch);

    Thread t1 = new Thread(waiter);
    t1.start();
    new Thread(decrementer).start();
    System.out.println("Abc");

    Thread.sleep(4000);
    System.out.println("Def");
   // t1.interrupt();

  }

}
