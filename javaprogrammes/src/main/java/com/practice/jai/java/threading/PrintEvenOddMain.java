package com.practice.jai.java.threading;

public class PrintEvenOddMain
{
    public static void main(String[] args) throws InterruptedException {
        MyPrintEvenOdd pc = new MyPrintEvenOdd();
        Thread t1 = new Thread(()->
        {
            pc.printOdd();
        });
        Thread t2 = new Thread(()->
        {
            pc.printEven();
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("End of Main!");

    }
}
