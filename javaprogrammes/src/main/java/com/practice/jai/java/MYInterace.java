package com.practice.jai.java;

public class MYInterace
{

}


interface Left
{
    void m1();
}

interface Right
{
    int m1();
}


class A //implements Left, Right
{

    /*@Override
    public void m1() {

    }*/
}




interface Left1
{
    Object m1();
}

interface Right1
{
    String m1();
}

class B1 implements Left1, Right1
{

    @Override
    public String m1()
    {
        return null;
    }
}