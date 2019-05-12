package com.practice.jai.java.innerclasses;

public class Outer
{
    int x = 10;
    class Inner
    {
        int x = 20;
        public void test()
        {
            System.out.println(x);
        }
    }

    public static void main(String[] args)
    {
        new Outer().new Inner().test();

        Runnable r = new Runnable() {
            @Override
            public void run() {

            }
        };

        Thread t = new Thread(r);

    }
}
