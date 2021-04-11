//Create a task that sleeps for a random amount of time between 1 and 10
//seconds, then displays its sleep time and exits. Create and run a quantity (given on the
//command line) of these tasks. 

import java.util.concurrent.*;
import java.util.*;

public class Ex6 implements Runnable {
	Random rand = new Random();
	public void run() {
		try {
			int t = 1000 * rand.nextInt(10);
			TimeUnit.MILLISECONDS.sleep(t);	
			System.out.println("Slept " + t/1000 + " seconds");
			return;			
		} catch(InterruptedException e) {
			System.err.println("Interrupted");
		}
		
	}
	public static void main(String[] args) {
		if(args.length < 1) {
			System.out.println("Usage: enter a number");
		}		
		if(args.length == 1) {
			int n = Integer.parseInt(args[0]);
			ExecutorService exec = Executors.newCachedThreadPool();
			for(int i = 0; i < n; i++)
				exec.execute(new Ex6());
			exec.shutdown();
		}
	}
}
