package com.practice.jai.java.collections;

import java.util.Arrays;

public class MyBlockingQueue {
    private String[] queue;
    private int max = 10;
    private int offset = -1;

    public MyBlockingQueue()
    {
        queue = new String[10];
    }

    private boolean isEmpty()
    {
        return offset < 0;
    }

    private boolean isFull()
    {
        return offset >= max - 1;
    }

    public synchronized void enqeue(String s)
    {
        while (isFull())
        {
            try {
                System.out.println("Waiting for queue to be empty.");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        offset+=1;
        queue[offset] = s;
        notify();
        System.out.println("Enqueued: "+ s);
    }

    public synchronized String deqeue()
    {
        while (isEmpty())
        {
            try {
                System.out.println("Waiting for queue to be fill.");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String s = queue[offset];
        queue[offset] = null;
        offset-=1;
        notify();

        System.out.println("Dequeued: "+ s);
        return s;
    }

    @Override
    public String toString() {
        return "MyBlockingQueue{" +
                "queue=" + Arrays.toString(queue) +
                '}';
    }
}
