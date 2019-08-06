package com.practice.jai.java.threading;

import java.util.concurrent.Semaphore;

public class MySemaphoreThread extends Thread
{
    private Semaphore semaphore;
    private String name;
    private static int count = 0;

    MySemaphoreThread(Semaphore semaphore, String name)
    {
        this.semaphore = semaphore;
        this.name = name;
    }

    @Override
    public void run()
    {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " aquire Lock!");

        if(this.name.equals("A"))
        {
            for (int i = 0; i < 10; i++) {
                count++;
            }
        }
        else if(this.name.equals("B"))
        {
            for (int i = 0; i < 10; i++) {
                count--;
            }
        }
        System.out.println(name + " releasing Lock!" + count);
        semaphore.release();
    }
}
