package com.practice.jai.java;

public enum MyEnum implements Runnable
{
    JAI(10) {
        @Override
        public void run() {

        }
    },
    J {
        @Override
        public void run() {

        }
    },
    KRI(20){
        @Override
        public void run() {

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
