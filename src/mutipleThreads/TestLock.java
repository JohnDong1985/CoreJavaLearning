package mutipleThreads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestLock {

	public static void main(String[] args) {
		Lock lock1 = new ReentrantLock();
		lock1.lock();
		try {
			// update object state
		} finally {
			lock1.unlock();
		}
		
//		Lock lock2 = new ReadWriteLock() {
//			
//			@Override
//			public Lock writeLock() {
//				// TODO Auto-generated method stub
//				return null;
//			}
//			
//			@Override
//			public Lock readLock() {
//				// TODO Auto-generated method stub
//				return null;
//			}
//		};
		
		Lock lock3 = (Lock) new ReentrantReadWriteLock();
	}
}
