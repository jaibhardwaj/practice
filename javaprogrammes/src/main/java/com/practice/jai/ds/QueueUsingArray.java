package com.practice.jai.ds;

public class QueueUsingArray
{
    private int maxSize = 10;
    private Integer[] arr = new Integer[10];
    private int head = 0;
    private int tail = -1;

    public void add(int data)
    {
        if(tail != maxSize - 1)
        {
            tail++;
            arr[tail] = data;
        }
    }

    public void remove()
    {
        if(head != tail)
        {
            arr[head] = null;
            head ++;
        }
    }


    @Override
    public String toString()
    {
        StringBuilder data = new StringBuilder("data { ");
        for (int i = head; i <= tail; i++)
        {
            data.append(arr[i]).append(" ");
        }
        return data.toString() + "}";
    }
}
