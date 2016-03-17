package cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
	public static void main(String[] args) {
		int taskSize = 5;

		Runnable taskOver = new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("All things done");
			}
		};

		CyclicBarrier cyclicBarrier = new CyclicBarrier(taskSize, taskOver);
		System.out.println(cyclicBarrier.getNumberWaiting());
		for (int i = 0; i < taskSize; i++) {
			new Thread(new SubTask(i, cyclicBarrier)).start();
		}

		while (cyclicBarrier.getNumberWaiting() != 0) {
			Thread.yield();
		}

		System.out.println("Over");
	}
}
