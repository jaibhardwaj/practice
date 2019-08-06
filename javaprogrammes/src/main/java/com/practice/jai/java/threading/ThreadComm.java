package com.practice.jai.java.threading;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class ThreadComm
{
    public static void main(String[] args)
    {
        Thread t = new Thread(()->
        {
            System.out.println("jai");
        });
        t.start();
        t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler()
        {
            @Override
            public void uncaughtException(Thread t, Throwable e) {

            }
        });

        Display d = new Display();
        MyDisplayThread thread1 = new MyDisplayThread(d, "Thread-1");
        MyDisplayThread thread2 = new MyDisplayThread(d, "Thread-2");
        thread1.start();
        thread2.start();


        ExecutorService executorService = Executors.newFixedThreadPool(3);
        //executorService.submit();
        Semaphore semaphore = new Semaphore(1);
        MySemaphoreThread mySemaphoreThread1 = new MySemaphoreThread(semaphore, "A");
        MySemaphoreThread mySemaphoreThread2 = new MySemaphoreThread(semaphore, "B");
        mySemaphoreThread1.start();
        mySemaphoreThread2.start();


    }

}
