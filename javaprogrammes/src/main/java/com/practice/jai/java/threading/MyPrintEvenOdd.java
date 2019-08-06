package com.practice.jai.java.threading;

public class MyPrintEvenOdd
{
    private boolean isOdd = false;
    private int number = 1;
    private int max = 10;

    public synchronized void printOdd()
    {
        //System.out.println("Printing ODD number!");
        while (number < max)
        {
            if(isOdd)
            {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(number++);
            isOdd = true;
            System.out.println("ODD number Printed, Notifying Even!");
            notify();
        }
    }

    public synchronized void printEven()
    {
        //System.out.println("Printing Even number!");
        while (number < max)
        {
            if(!isOdd)
            {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(number++);
            isOdd = false;
            System.out.println("EVEN number Printed, Notifying ODD!");
            notify();
        }
    }
}
