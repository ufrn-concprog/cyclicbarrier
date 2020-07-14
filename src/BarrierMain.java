import java.util.concurrent.CyclicBarrier;

public class BarrierMain {
	
	private static final int NUM_THREADS = 2;

	public static void main(String[] args) {
		Runnable barrierAction = new Runnable() {
			public void run() {
				System.out.println("Releasing threads at the barrier.");
			}
		};
		
		CyclicBarrier barrier = new CyclicBarrier(NUM_THREADS, barrierAction);
		
		ThreadAction threadA = new ThreadAction("A", barrier);
		ThreadAction threadB = new ThreadAction("B", barrier);
		
		threadA.start();
		threadB.start();
		
		try {
			threadA.join();
			threadB.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
