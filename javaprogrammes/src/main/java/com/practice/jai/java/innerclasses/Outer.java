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

    static class StaticInner
    {
        public void m1()
        {
            System.out.println("Static Inner Method");
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

        StaticInner i =  new StaticInner();
        Outer.Inner inner = new Outer().new Inner();
        i.m1();

    }
}

class Mt
{
    public static void main(String[] args) {
        Outer.StaticInner st = new Outer.StaticInner();
        st.m1();

        Outer.Inner inner = new Outer().new Inner();
        inner.test();

    }
}