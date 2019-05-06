package com.practice.jai.java.singleton;

public class BillPughSingelton
{
    private static class BillPughSingeltonInnerClass
    {
        private static final BillPughSingelton INSTANCE = new BillPughSingelton();
    }

    public static BillPughSingelton getInstance()
    {
        return BillPughSingeltonInnerClass.INSTANCE;
    }
}
