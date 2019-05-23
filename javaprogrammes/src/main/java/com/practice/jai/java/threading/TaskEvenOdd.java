package com.practice.jai.java.threading;

public class TaskEvenOdd implements Runnable
{
    private int max;
    private boolean isEven;
    private PrintCount printCount;


    public TaskEvenOdd(int max, boolean isEven, PrintCount printCount)
    {
        this.max = max;
        this.isEven = isEven;
        this.printCount = printCount;
    }

    @Override
    public void run()
    {
        int number = isEven ? 2 : 1;

        while (number <= max)
        {
            if (isEven)
            {
                printCount.printEven(number);
            }
            else
            {
                printCount.printOdd(number);
            }
            number += 2;
        }
    }
}
