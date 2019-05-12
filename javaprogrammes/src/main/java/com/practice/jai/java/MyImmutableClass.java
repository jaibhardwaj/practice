package com.practice.jai.java;

public class MyImmutableClass
{
    private int i;
    public MyImmutableClass(int data)
    {
        this.i = data;
    }

    public MyImmutableClass modify(int i)
    {
        if (this.i == i)
        {
            return this;
        }
        else
        {
            return new MyImmutableClass(i);
        }
    }
}
