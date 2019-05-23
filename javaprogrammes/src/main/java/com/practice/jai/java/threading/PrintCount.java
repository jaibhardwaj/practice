package com.practice.jai.java.threading;

public class PrintCount
{
    private volatile boolean isOdd;

    public synchronized void printOdd(int number)
    {
        while (isOdd)
        {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName() + " : " + number);
        isOdd = true;
        notify();
    }

    public synchronized void printEven(int number) {
        while (!isOdd)
        {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName() + " : " + number);
        isOdd = false;
        notify();
    }
}
