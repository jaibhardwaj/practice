package com.practice.jai.ds;

import java.util.NoSuchElementException;

public class CircularQueueEx
{
    private Integer[] queue;
    private int front;
    private int back;

    public CircularQueueEx(int capacity)
    {
        queue = new Integer[capacity];
    }

    public void add(Integer employee)
    {
        if (size() == queue.length - 1)
        {
            int numItems = size();
            Integer[] newArray = new Integer[2 * queue.length];

            System.arraycopy(queue, front, newArray, 0, queue.length - front);
            System.arraycopy(queue, 0, newArray, queue.length - front, back);

            queue = newArray;

            front = 0;
            back = numItems;
        }

        // 0   jane
        // 1    john
        // 2  -   -back
        // 3  -mike - front
        // 4   -bill

        // 0 mike
        // 1 bill
        // 2 jane
        // 3 john
        // 4 - back
        // 5
        // 9


        queue[back] = employee;
        if (back < queue.length - 1)
        {
            back++;
        }
        else
        {
            back = 0;
        }
    }

    public Integer remove()
    {
        if (size() == 0)
        {
            throw new NoSuchElementException();
        }

        Integer employee = queue[front];
        queue[front] = null;
        front++;
        if (size() == 0)
        {
            front = 0;
            back = 0;
        }
        else if (front == queue.length)
        {
            front = 0;
        }

        return employee;
    }

    public Integer peek()
    {
        if (size() == 0)
        {
            throw new NoSuchElementException();
        }

        return queue[front];
    }

    public int size()
    {
        if (front <= back)
        {
            return back - front;
        }
        else
        {
            return back - front + queue.length;
        }

    }

    public void printQueue()
    {
        if (front <= back)
        {
            for (int i = front; i < back; i++)
            {
                System.out.println(queue[i]);
            }
        }
        else
        {
            for (int i = front; i < queue.length; i++)
            {
                System.out.println(queue[i]);
            }
            for (int i = 0; i < back; i++)
            {
                System.out.println(queue[i]);
            }
        }
    }
}
