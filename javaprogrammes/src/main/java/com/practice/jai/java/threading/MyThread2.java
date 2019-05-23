package com.practice.jai.java.threading;

public class MyThread2 extends Thread
{
    private final PrintCount printCount;

    public MyThread2(PrintCount printCount)
    {
        this.printCount = printCount;
    }
    @Override
    public void run()
    {
        synchronized (printCount)
        {
            /*System.out.println(printCount.getCount());
            printCount.incrementCount();*/
            printCount.notify();
            try {
                printCount.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
