package mutipleThreads;

import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomic {

	private static AtomicInteger counter = new AtomicInteger();

	public static int getNextUniqueIndex() {
	  return counter.getAndIncrement();
	}
	
	public static void main(String[] args) {
		int current;
		do {
		  current = getNextUniqueIndex();
		} while(!compareAndSet(current, current + 1));
	}

	private static boolean compareAndSet(int current, int i) {
		// TODO Auto-generated method stub
		return false;
	}
	
//	public static void main(String[] args) {
//		private volatile int counter;
//		public int getNextUniqueIndex() {
//		  return counter++; 
//		}
//	}

	
}
