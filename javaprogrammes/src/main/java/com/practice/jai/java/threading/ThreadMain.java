package com.practice.jai.java.threading;

public class ThreadMain
{
    public static void main(String[] args) throws InterruptedException
    {

        /*Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++)
            {
                System.out.println("Thread " + Thread.currentThread().getName() + " Running!!!!");
                //Thread.yield();
            }
        });
        t1.setName("Anonymous Child");
        t1.start();
        //t1.join();

        //Thread.sleep(1000);
        for (int i = 0; i < 10; i++)
        {
            System.out.println("Thread " + Thread.currentThread().getName() + " Running!!!!");
        }*/




        /*
        * Wait and Notify
        * */
        /*PrintCount printCount = new PrintCount();
        MyThread1 myThread1 = new MyThread1(printCount);
        myThread1.start();
        System.out.println("Waiting for Notification...");
        synchronized (printCount)
        {
            printCount.wait();
        }
        System.out.println("Got Notification");
        System.out.println(printCount.getCount());*/



        /*
         * Print Even Odd using Two Thread
         * */
        PrintCount printCount = new PrintCount();
        Thread t1 = new Thread(new TaskEvenOdd(10, false, printCount),"Odd");
        Thread t2 = new Thread(new TaskEvenOdd(10, true, printCount), "Even");
        t1.start();
        t2.start();
        t1.setUncaughtExceptionHandler((t, e) -> {

        });

    }
}
