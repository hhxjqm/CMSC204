import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

public class CarQueue{

	
	Random direction;
	Queue<Integer> queue;
	
	public CarQueue() {
		queue = new ArrayDeque<>();
		direction = new Random();
		queue.add(direction.nextInt(4));
		queue.add(direction.nextInt(4));
		queue.add(direction.nextInt(4));
		queue.add(direction.nextInt(4));
		queue.add(direction.nextInt(4));
	}
	
	public void addToQueue() {
		
		class MyRunnable implements Runnable{
			@Override
			public void run() {
				
				try {
					while(true) {
						queue.add(direction.nextInt(4));
						Thread.sleep(0);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				}
			}
		Runnable r = new MyRunnable();
		Thread t = new Thread(r);
		t.start();
	}
	
	public int deleteQueue() {
		return queue.remove();
	}
}
