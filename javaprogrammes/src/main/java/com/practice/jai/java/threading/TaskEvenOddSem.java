package com.practice.jai.java.threading;

import java.util.concurrent.Semaphore;

public class TaskEvenOddSem implements Runnable
{
    private Semaphore semaphore;
    private PrintNumber printNumber;
    private volatile boolean isEven;
    private int max;

    public TaskEvenOddSem(Semaphore semaphore, PrintNumber printNumber, boolean isEven, int max)
    {
        this.semaphore = semaphore;
        this.printNumber = printNumber;
        this.isEven = isEven;
        this.max = max;
    }

    @Override
    public void run()
    {
        int number = isEven ? 2 : 1;
        while (number <= max)
        {
            if (isEven)
            {
                printNumber.printNumber(number);
                isEven = false;
            }
            else
            {
                printNumber.printNumber(number);
                isEven = true;
            }
            number +=2;
        }
        semaphore.release();
    }
}
