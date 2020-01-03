package com.practice.jai.java;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Testa
{
    static int x =10;
    Testa()
    {
        this(10);
    }
    Testa(int i)
    {
        super();
    }
    public static void main(String[] args)
    {
        Testa ta = new Testa();
        ta.x =10;
        System.out.println(ME.KC.getValue());
        System.out.println(ME.KC.getUUid());
        ME me1 = ME.KC;
        ME me2 = ME.KC;
        System.out.println(me1.hashCode());
        System.out.println(me2.hashCode());
        Thread t = new Thread(ME.KC);
        t.start();


        List l = new ArrayList<String>();
        l.add("d");
        l.add(2);

        List<String> l2 = new ArrayList();

        Test<String> stringTest = new Test<>();
        stringTest.add("jai");
        stringTest.add("ll");
        String s = stringTest.get(1);
        System.out.println(s);
        Thread tw = new Thread() {
            public void run()
        {
            System.out.println("Child");
        }
        };
    }
}

class Test<T>
{
    private List<T> l = new ArrayList<>();

    public void add(T val)
    {
        l.add(val);
    }

    T get(int index)
    {
        return l.get(index);
    }
}

enum Day
{
    JAN, FEB(100);

    Day()
    {
        System.out.println("NO");
    }

    Day(int i)
    {
        System.out.println("YES");
    }

    public static void main(String[] args)
    {
        System.out.println(JAN);
        MyG<String,String,String> mg = new MyG<>();
        mg.m1("a");
    }
}

class MyG<A, B, C>
{
    public void m1(A a)
    {
        System.out.println(a);
    }
}

class StaticInner
{
    static class SInner
    {
        public void m1()
        {
            System.out.println("SS");
        }
    }

    class NInner
    {
        public void m1()
        {
            System.out.println("dd");
        }
    }

    public static void main(String[] args)
    {
        StaticInner s  = new StaticInner();
        StaticInner.SInner si = new StaticInner.SInner();
        StaticInner.NInner sn = new StaticInner().new NInner();
    }
}

abstract class AT
{
    public static void ma()
    {

    }
}

interface P
{
    void m1();
}
interface Q extends P
{
    void m2();
    default void m3()
    {
        m1();
    }
}

class TR implements Q
{
    @Override public void m2()
    {

    }

    @Override public void m1()
    {

    }
}

