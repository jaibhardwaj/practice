package com.practice.jai.java;

public class MySingletonClass
{
    /* Early Initialization*/
   // private static final MySingletonClass mySingletonClass = new MySingletonClass();

    /* Lazy Initialization*/
    private static MySingletonClass mySingletonClass = null;

    private MySingletonClass()
    {}

    public static MySingletonClass getInstance()
    {
        /* Early Initialization*/
        //return mySingletonClass;


        /* Lazy Initialization*/
        if(mySingletonClass == null)
        {
            mySingletonClass = new MySingletonClass();
        }

        return mySingletonClass;
    }
}
