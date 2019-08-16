package com.practice.jai.java.threading;

import java.util.concurrent.Semaphore;

class MySemaphorePrintNumber
{
    private final Semaphore semaphore = new Semaphore(1);
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
                    semaphore.acquire();
                    System.out.println(count);
                    count++;
                    isOdd = false;
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    semaphore.release();
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
                    semaphore.acquire();
                    System.out.println(count);
                    count++;
                    isOdd = true;
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    semaphore.release();
                }
            }
        }
    }
}
public class EvenOddUsingSemaphore
{
    public static void main(String[] args) throws InterruptedException
    {
        MySemaphorePrintNumber printNumber = new MySemaphorePrintNumber();
        Thread t1 = new Thread(printNumber::printOdd);
        Thread t2 = new Thread(printNumber::printEven);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Main Semaphore Finished!!");
    }
}
