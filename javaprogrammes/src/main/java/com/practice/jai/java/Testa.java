package com.practice.jai.java;

import java.util.ArrayList;
import java.util.List;

public class Testa
{
    public static void main(String[] args) {
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
