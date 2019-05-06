package com.practice.jai;

import com.practice.jai.java.MySingletonClass;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        MySingletonClass mySingletonClass = MySingletonClass.getInstance();
        MySingletonClass mySingletonClass1 = MySingletonClass.getInstance();
        System.out.println(mySingletonClass.hashCode());
        System.out.println(mySingletonClass1.hashCode());
    }
}
