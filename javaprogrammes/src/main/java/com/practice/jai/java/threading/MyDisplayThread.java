package com.practice.jai.java.threading;

public class MyDisplayThread extends Thread
{
    private Display d;
    private String name;

    public MyDisplayThread(Display d, String name)
    {
        this.d = d;
        this.name = name;
    }

    @Override
    public void run() {
        d.show(name);
    }
}
