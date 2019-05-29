package com.practice.jai.java.threading;

import java.util.concurrent.Semaphore;

public class PrintNumber
{
    private Semaphore semaphore;

    public PrintNumber(Semaphore semaphore)
    {
        this.semaphore = semaphore;
    }

    public void printNumber(int number) {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " : " + number);
        semaphore.release();
    }

    /*public void printOdd(int number)
    {
        System.out.println(Thread.currentThread().getName() + " : " + number);
    }*/
}
