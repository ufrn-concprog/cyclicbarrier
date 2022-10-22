import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Action to be performed by a thread to be synchronized at a barrier
 * @author <a href="mailto:everton.cavalcante@ufrn.br">Everton Cavalcante</a>
 */
public class ThreadAction extends Thread {
	/** Reference to the synchronization barrier */
	private CyclicBarrier barrier;

	/**
	 * Parameterized constructor
	 * @param name Name to be assigned to the thread
	 * @param barrier Reference to the sychronization barrier
	 */
	public ThreadAction(String name, CyclicBarrier barrier) {
		super(name);
		this.barrier = barrier;
	}

	/** Thread's action */
	@Override
	public void run() {
		try {
			// Thread is suspended by a random time interval to
			// simulate waiting time
			int duration = (int) (Math.random() * 5) + 1;
			Thread.sleep(duration * 1000);

			System.out.printf("Thread %s arrived at the barrier after %d seconds\n",
					this.getName(), duration);
			barrier.await();

			System.out.println("Thread " + this.getName() + " released.");
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
		
		
	}
}
