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
class newthread extends Thread

{

    Thread t;

    newthread()

    {

        t = new Thread(this,"My Thread");

        t.start();

    }

    public void run()

    {

        try

        {
            System.out.println("--------------");
            t.join();

            System.out.println(t.getName());

        }

        catch(Exception e)

        {

            System.out.print("Exception");

        }

    }

}

class multithreaded_programing

{

    public static void main(String args[])

    {

        new newthread();

    }

}
