package com.practice.jai.java.threading;

import java.util.concurrent.locks.ReentrantLock;

class MyPrintNumber
{
    private final ReentrantLock reentrantLock = new ReentrantLock();
    private volatile boolean isOdd = true;
    private int count = 1;
    private int max = 10;

    public void printOdd()
    {
        while (count < max)
        {
            if (isOdd)
            {
                try
                {
                    reentrantLock.lock();
                    System.out.println(count);
                    count++;
                    isOdd = false;
                }
                finally
                {
                    reentrantLock.unlock();
                }
            }
        }
    }

    public void printEven()
    {
        while (count <= max)
        {
            if (!isOdd)
            {
                try
                {
                    reentrantLock.lock();
                    System.out.println(count);
                    count++;
                    isOdd = true;
                }
                finally
                {
                    reentrantLock.unlock();
                }
            }
        }
    }
}

public class OddEvenUsingReeantrantLock
{
    public static void main(String[] args) throws InterruptedException
    {
        MyPrintNumber printNumber = new MyPrintNumber();
        Thread t1 = new Thread(printNumber::printOdd);
        Thread t2 = new Thread(printNumber::printEven);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Main Finished!!");
    }
}
