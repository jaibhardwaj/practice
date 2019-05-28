package com.practice.jai.java.threading;

import java.util.concurrent.locks.ReentrantLock;

public class MyRentrantLock
{
    private static final ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args)
    {
        lock.lock();
        lock.lock();
        lock.lock();
        lock.lock();
        lock.lock();

        System.out.println(lock.getHoldCount());
        System.out.println(lock.getQueueLength());
        System.out.println(lock.isHeldByCurrentThread());
        System.out.println(lock.isLocked());

        lock.unlock();
        lock.unlock();
        lock.unlock();
        lock.unlock();
        lock.unlock();

        System.out.println(lock.getHoldCount());
        System.out.println(lock.getQueueLength());
        System.out.println(lock.isHeldByCurrentThread());
        System.out.println(lock.isLocked());



    }
}
