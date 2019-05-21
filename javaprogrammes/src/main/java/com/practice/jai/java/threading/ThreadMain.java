package com.practice.jai.java.threading;

public class ThreadMain
{
    public static void main(String[] args) throws InterruptedException
    {

        Thread t1 = new Thread(() -> {
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
        }
    }
}
