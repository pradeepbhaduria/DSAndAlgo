package ds.tree.puzzles;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPuzzle1 {
	public static void main(String[] args) {
		BlockingQueue<Integer> q1 = new LinkedBlockingQueue<>(1);
		BlockingQueue<Integer> q2 = new LinkedBlockingQueue<>(1);
		BlockingQueue<Integer> q3 = new LinkedBlockingQueue<>(1);
		BlockingQueue<Integer> q4 = new LinkedBlockingQueue<>(1);
		new Thread(new Thread1(q1)).start();
		new Thread(new Thread2(q2)).start();
		new Thread(new Thread3(q3)).start();
		new Thread(new Thread4(q4)).start();
		while (true) {
			try {
				System.out.println(q1.take());
				System.out.println(q2.take());
				System.out.println(q3.take());
				System.out.println(q4.take());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Thread1 implements Runnable {
	BlockingQueue<Integer> queue;

	public Thread1(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		for (int i = 0; i < 14; i++) {
			try {
				queue.put(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Thread2 implements Runnable {
	BlockingQueue<Integer> queue;

	public Thread2(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		for (int i = 100; i < 114; i++) {
			try {
				queue.put(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Thread3 implements Runnable {
	BlockingQueue<Integer> queue;

	public Thread3(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		for (int i = 1000; i < 1014; i++) {
			try {
				queue.put(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Thread4 implements Runnable {
	BlockingQueue<Integer> queue;

	public Thread4(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		for (int i = 10000; i < 10014; i++) {
			try {
				queue.put(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
