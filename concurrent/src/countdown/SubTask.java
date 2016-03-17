package countdown;

import java.util.concurrent.CountDownLatch;

public class SubTask extends Task {
	private int id;

	public SubTask(int id, CountDownLatch startSignal, CountDownLatch doSignal) {
		super(startSignal, doSignal);
		this.id = id;
	}

	@Override
	void doSomeWork() {
		System.out.println("Do Something in SubTask " + id);
	}

}
