package com.practice.jai.java.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonClassMain
{
    public static void main( String[] args )
    {
        /*
        1) Early Loading
        2) Early Loading using Static Block
        3) Lazy Loading
        4) Lazy Loading using synchronized method
        5) Lazy Loading using double check synchronized block
        6) Bill PUG (Using inner static class)
        7) Using Enum
        */
        MySingletonClass mySingletonClass = MySingletonClass.getInstance();
        MySingletonClass mySingletonClass1 = MySingletonClass.getInstance();
        System.out.println(mySingletonClass.hashCode());
        System.out.println(mySingletonClass1.hashCode());

        EnumSingleton enumSingleton = EnumSingleton.INSTANCE;
        EnumSingleton enumSingleton1 = EnumSingleton.INSTANCE;
        System.out.println(enumSingleton.hashCode());
        System.out.println(enumSingleton1.hashCode());

        MySingletonClass mySingletonClass2 = null;
        Constructor[] constructors = MySingletonClass.class.getDeclaredConstructors();

        for (Constructor constructor : constructors)
        {
            //Below code will destroy the singleton pattern
            constructor.setAccessible(true);

            try
            {
                mySingletonClass2 = (MySingletonClass) constructor.newInstance();
            }
            catch (InstantiationException | IllegalAccessException | InvocationTargetException e)
            {
                e.printStackTrace();
            }
            break;
        }

        System.out.println(mySingletonClass2.hashCode());


        /*EarlyLoadingUsingStaticBlockSingleton*/

        EarlyLoadingUsingStaticBlockSingleton ea = EarlyLoadingUsingStaticBlockSingleton.getInstance();
        EarlyLoadingUsingStaticBlockSingleton ea1 = EarlyLoadingUsingStaticBlockSingleton.getInstance();
        System.out.println(ea.hashCode());
        System.out.println(ea1.hashCode());


        /* 6) Bill PUG (Using inner static class) */

        BillPughSingelton billPughSingelton = BillPughSingelton.getInstance();
        BillPughSingelton billPughSingelton1 = BillPughSingelton.getInstance();
        System.out.println(billPughSingelton.hashCode());
        System.out.println(billPughSingelton1.hashCode());
    }
}
