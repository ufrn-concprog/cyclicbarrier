import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class ThreadAction extends Thread {
	private CyclicBarrier barrier;
	
	public ThreadAction(String name, CyclicBarrier barrier) {
		super(name);
		this.barrier = barrier;
	}
	
	@Override
	public void run() {
		try {
			System.out.println("Thread " + this.getName() + 
				" waiting at the barrier.");
			barrier.await();
			
			Thread.sleep(400);
			System.out.println("Thread " + this.getName() + " released.");
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
		
		
	}
}
