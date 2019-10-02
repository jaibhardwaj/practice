package com.practice.jai.java;

import java.util.UUID;

public enum MyEnum implements Runnable
{
    JAI(10) {
        @Override
        public void run()
        {

        }
    },
    J {
        @Override
        public void run()
        {

        }
    },
    KRI(20) {
        @Override
        public void run()
        {

        }

        public void test()
        {
            System.out.println("Inner Class");
        }
    };

    public void test()
    {
        System.out.println("Outer Class");
    }

    int id;
    MyEnum(int id)
    {
        this.id = id;
    }

    MyEnum()
    {

    }

    public int getId()
    {
        return id;
    }


    public static void main(String[] args) {
        MyEnum.KRI.test();
    }
}

enum ME implements Runnable
{
    KF(100){
        @Override
        public void run() {
            System.out.println("KF Run");
        }
    },
    KC(200) {
        @Override
        public void run() {
            System.out.println("KC Run");
        }
        public String getUUid()
        {
            return "dd " + UUID.randomUUID().toString();
        }
    };

    private int i;
    ME(int i)
    {
        this.i = i;
    }

    public int getValue() {
        return i;
    }

    public String getUUid()
    {
        return UUID.randomUUID().toString();
    }

}