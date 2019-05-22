package com.practice.jai.java;

public enum MyEnum
{
    JAI(10),
    KRI(20){
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

    public int getId()
    {
        return id;
    }

}
