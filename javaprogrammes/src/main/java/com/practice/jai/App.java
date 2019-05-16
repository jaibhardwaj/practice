package com.practice.jai;

import com.practice.jai.java.Account;
import com.practice.jai.java.MyImmutableClass;
import com.practice.jai.java.singleton.BillPughSingelton;
import com.practice.jai.java.singleton.EarlyLoadingUsingStaticBlockSingleton;
import com.practice.jai.java.singleton.EnumSingleton;
import com.practice.jai.java.singleton.MySingletonClass;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
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


        System.out.println("------------------------Immutable Class Test----------------------------------------");
        /*
        * Immutable Class Test
        * */
        MyImmutableClass myImmutableClass = new MyImmutableClass(10);
        MyImmutableClass myImmutableClass1 = myImmutableClass.modify(20);
        MyImmutableClass myImmutableClass2 = myImmutableClass.modify(10);
        MyImmutableClass myImmutableClass3 =  new MyImmutableClass(10);
        System.out.println(myImmutableClass.hashCode());
        System.out.println(myImmutableClass1.hashCode());
        System.out.println(myImmutableClass2.hashCode());
        System.out.println(myImmutableClass3.hashCode());



        Boolean b = new Boolean("");
        HashMap<String, String> m = new HashMap<String, String>();
        m.put("s", "k");
        Set s = m.entrySet();
        for (String d: m.keySet()) {

        }
        Iterator i = s.iterator();
        while (i.hasNext())
        {
            Map.Entry e = (Map.Entry) i.next();
            System.out.println(e.getKey() + "  " + e.getValue());
        }
        
    }
}
