package com.practice.jai.java;

public class MyException extends Exception
{
    public MyException(String s)
    {
        super(s);
    }
}

class MyTest
{
    private int x;
    /*@Override
    public int hashCode() {
        return 100;
    }*/

    public static void main(String[] args)
    {
        MyTest m1 = new MyTest();
        MyTest m2 = new MyTest();
        System.out.println(m1.hashCode() + " " + m2.hashCode());
        m1.x = 10;
        m2.x = 20;
        System.out.println(m1.x + " " + m2.x);
    }
}
