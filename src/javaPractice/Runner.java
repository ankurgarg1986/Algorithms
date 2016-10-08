package javaPractice;

import java.util.concurrent.locks.ReentrantReadWriteLock;

class Queue {
	static int n;
	static boolean produced;

	public Queue() {
		n = 0;
		produced = false;
	}

	synchronized public void get(int id) {

		while (!produced) {
			try {
				wait();
			} catch (InterruptedException ie) {
				System.out.println("Caught Interrupted exception");
			}
		}
		System.out.println("Got " + n + " By Consumer: " + id);
		produced = false;
		notifyAll();
	}

	synchronized public void put(int val, int id) {
		while (produced) {
			try {
				wait();
			} catch (InterruptedException ie) {
				System.out.println("Caught Interrupted exception");
			}

		}
		n = val;
		System.out.println("Put : " + n + " By Producer: " + id);
		produced = true;
		notifyAll();
	}

}

class Producer extends Thread {

	Queue q;
	int id;
	static int p = 1;

	public Producer(Queue qu, int sn) {
		q = qu;
		id = sn;
		this.start();
	}

	public void run() {

		while (p < 100) {
			q.put(p++, id);

		}
	}

}

class Consumer implements Runnable {
	Queue q;
	int id;

	public Consumer(Queue qu, int sn) {
		q = qu;
		id = sn;
		new Thread(this, "Consumer").start();
	}

	public void run() {

		while (true) {
			q.get(id);

		}
	}

}

public class Runner {
	ReentrantReadWriteLock rbX = new ReentrantReadWriteLock();
    
	public static void main(String params[]) {
		Queue q = new Queue();
		new Producer(q, 1);
		new Consumer(q, 1);
		new Producer(q, 2);
		new Consumer(q, 2);
		new Consumer(q, 3);
	}
}
