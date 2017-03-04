package javaPractice;

import java.util.Stack;

class Producer3 implements Runnable {

  Stack<Integer> s;

  int size;

  public Producer3(Stack s, int size) {
    this.s = s;
    this.size = size;
  }

  @Override
  public void run() {
    synchronized (s) {
      if (s.size() == size) {
        try {
          s.wait();
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }

      for (int i = 0; i < 5; i++) {
        s.push(i);
      }
      if (s.size() > 0)
        s.notify();
    }

  }

}

class Consumer3 implements Runnable {

  Stack<Integer> s;
  int size;

  public Consumer3(Stack<Integer> s, int size) {
    this.s = s;
    this.size = size;
  }

  @Override
  public void run() {
    synchronized (s) {
      if (s.isEmpty()) {
        try {
          s.wait();
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
      int val = s.pop();
      System.out.println(val);
      if (s.size() < this.size)
        s.notify();

    }
  }

}

public class TestP {

  public static void main(String[] args) throws InterruptedException {

    int i = 0;
    Stack<Integer> s = new Stack<Integer>();
   // for (i = 0; i < 5; i++) {

      Thread p1 = new Thread(new Producer3(s, 5));
      Thread.sleep(2000);
      Thread p2 = new Thread(new Producer3(s, 5));
      Thread.sleep(2000);
      Thread c1 = new Thread(new Consumer3(s, 5));
      Thread c2 = new Thread(new Consumer3(s, 5));
      Thread c3 = new Thread(new Consumer3(s, 5));
      Thread c4 = new Thread(new Consumer3(s, 5));
      Thread c5 = new Thread(new Consumer3(s, 5));
      Thread c6 = new Thread(new Consumer3(s, 5));

      p1.start();
      //p2.start();
      c1.start();
      c2.start();
      c3.start();
      c4.start();
      c5.start();
      c6.start();
      p2.start();
    //}
  }
}
