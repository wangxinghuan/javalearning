package countdown;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
	public static void main(String[] args) {
		CountDownLatch startSignal = new CountDownLatch(1);
		CountDownLatch doneSignal = new CountDownLatch(5);

		for (int i = 0; i < 5; i++) {
			new Thread(new SubTask(i, startSignal, doneSignal)).start();
		}

		try {
			startSignal.countDown();
			doneSignal.await();
			System.out.println("All Task has completed");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
