package com.practice.jai.java.threading;

public class DeadLockPrevention
{
    public static void main(String[] args)
    {
        D1 d1 = new D1();
        D2 d2 = new D2();
        d1.setD2(d2);
        d2.setD1(d1);

        Thread t1 = new Thread(d1::method1);
        Thread t2 = new Thread(d2::method2);
        t1.start();
        t2.start();

    }
}

class D1
{
    private D2 d2;

    public void setD2(D2 d2)
    {
        this.d2 = d2;
    }

    public void method1()
    {
        synchronized (this)
        {
            try
            {
                Thread.sleep(5000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println("Staring d2 block from D1");
            synchronized (d2)
            {
                System.out.println("Executing D2.");
            }
        }
    }
}
class D2
{
    private D1 d1;

    public void setD1(D1 d1)
    {
        this.d1 = d1;
    }

    public void method2()
    {
        //synchronized (this)
        synchronized (d1)
        {
            try
            {
                Thread.sleep(5000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println("Staring d1 block from D2");
            //synchronized (d1)
            synchronized (this)
            {
                System.out.println("Executing D1.");
            }
        }
    }
}

