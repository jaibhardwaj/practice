package com.practice.jai.java;

public class ObjectCount
{
    static int count;
    {
        count++;
    }
    public static void main(String[] args)
    {

        for (int i = 0; i < 10; i++)
        {
            ObjectCount o1 = new ObjectCount();

        }
        System.out.println(count);

    }
}
