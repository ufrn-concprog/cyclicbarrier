import java.util.concurrent.CyclicBarrier;

/**
 * Demonstration of the synchronization of threads at a barrier
 * @see java.util.concurrent.CyclicBarrier
 *
 * @author <a href="mailto:everton.cavalcante@ufrn.br">Everton Cavalcante</a>
 */
public class BarrierMain {
	/** Number of threads to synchronize */
	private static final int NUM_THREADS = 2;

	/**
	 * Main method
	 * @param args Command line arguments
	 */
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
