package com.practice.jai.java.threading;

public class DaemonThread
{
    public static void main(String[] args) throws InterruptedException
    {
        Thread t = new Thread(() ->
        {
            for (int i = 0; i < 10; i++)
            {
                System.out.println("Lazy!!");
                try
                {
                    Thread.sleep(2000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        });
        t.setDaemon(true);
        t.start();
        Thread.sleep(5000);
        System.out.println("End of Main!!");
    }
}
