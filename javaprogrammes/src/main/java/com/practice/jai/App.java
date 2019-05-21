package com.practice.jai;

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

    public static void main(String[] args )
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

        LinkedHashSet linkedHashSet = new LinkedHashSet();
        //TreeSet<Employee> treeSet = new TreeSet((i1, i2) -> (i1.getId() < i2.getId()) ? -1 : (i1.getId() > i2.getId()) ? 1 : 0);

        Integer i1 = new Integer(10);
        Integer i2 = new Integer(10);
        HashMap map = new HashMap();
        map.put(i1, "Jai");
        map.put(i2, "ki");
        System.out.println(map);

        WeakHashMap map1 = new WeakHashMap();
        String s1 = new String("Jai");
        map1.put(s1, "Kri");
        System.out.println(map1);
        s1 = null;
        System.gc();
        System.out.println(map1);



        Hashtable<Integer, String> hashtable = new Hashtable<>();
        hashtable.put(5, "A");
        hashtable.put(13, "B");
        hashtable.put(3, "C");
        hashtable.put(12, "D");
        hashtable.put(16, "D");


    }
}
