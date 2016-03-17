package cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class SubTask extends Task {
	private int id;

	public SubTask(int id, CyclicBarrier cyclicBarrier) {
		super(cyclicBarrier);
		this.id = id;
	}

	@Override
	void doSomeWork() {
		System.out.println("do something in SubTask " + id);

	}

}
