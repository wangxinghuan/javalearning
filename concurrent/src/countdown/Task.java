package countdown;

import java.util.concurrent.CountDownLatch;

public abstract class Task implements Runnable {
	private CountDownLatch startSignal;
	private CountDownLatch doSignal;

	public Task(CountDownLatch startSignal, CountDownLatch doSignal) {

		this.startSignal = startSignal;
		this.doSignal = doSignal;
	}

	@Override
	public void run() {
		try {
			startSignal.await();
			doSomeWork();
			doSignal.countDown();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	abstract void doSomeWork();
}
