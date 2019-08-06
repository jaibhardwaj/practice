package com.practice.jai.java.threading;

import java.util.concurrent.locks.ReentrantLock;

public class Display
{
    private ReentrantLock lock = new ReentrantLock();

    public void show(String name)
    {
        if(lock.tryLock())
        {
            System.out.println(name + " Got Lock!");
            for (int i = 0; i < 10; i++) {
                System.out.println("Welcome: " + name);
            }
            System.out.println(name + " Releases Lock!");
            lock.unlock();
        }
        else
        {
            System.out.println(name + " Unable to get Lock so performing Alternate Solution!");
        }

    }
}
