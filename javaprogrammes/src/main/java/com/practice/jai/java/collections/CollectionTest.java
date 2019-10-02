package com.practice.jai.java.collections;

import java.util.*;

public class CollectionTest
{
    public static void main(String[] args)
    {
        /*Vector<String> v = new Vector<String>();
        v.add("jai");
        v.add("Kri");
        Enumeration e = v.elements();
        while (e.hasMoreElements())
        {
            System.out.println(e.nextElement());
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add("k");
        Iterator i = linkedList.iterator();

        MyHashMap map = new MyHashMap();
        map.put("21", "jai");
        map.put("2", "Kri");
        map.put("53", "Sac");
        map.put("84", "kkk");
        map.put("5", "iiii");
        map.printMap();

        System.out.println(map.get("84"));

        MyBlockingQueue queue = new MyBlockingQueue();
        queue.enqeue("a1");
        queue.enqeue("a2");
        queue.enqeue("a3");
        queue.enqeue("a4");
        queue.enqeue("a5");
        queue.enqeue("a6");
        queue.enqeue("a7");
        queue.enqeue("a8");
        queue.enqeue("a9");
        queue.enqeue("a10");
        new Thread(() -> queue.enqeue("jai")).start();
        new Thread(() -> queue.deqeue()).start();

        System.out.println(queue);*/


        MyHashMap2<String, String> m2 = new MyHashMap2<>(10);
        for (int i = 0; i < 50; i++)
        {
            m2.put("a" + i, "b" + i);
        }
        System.out.println(m2);
        System.out.println(m2.get("a5"));
    }
}
