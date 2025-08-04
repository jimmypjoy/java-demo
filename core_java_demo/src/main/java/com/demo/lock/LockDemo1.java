package com.demo.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockDemo1 {
public static void main(String[] args) {
	var lock = new ReentrantReadWriteLock();
	lock.writeLock().lock();
	lock.readLock().lock();
	System.out.println(lock.isWriteLocked());     // true
	System.out.println(lock.getReadLockCount());  // 1
	 
	lock.writeLock().unlock();

	System.out.println(lock.isWriteLocked());     // false
	System.out.println(lock.getReadLockCount());  // 1
	 
	lock.readLock().unlock();
	System.out.println(lock.getReadLockCount());  // 0

	
}
}
