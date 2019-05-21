package com.practice.jai.java.collections;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

public class CollectionTest
{
    public static void main(String[] args)
    {
        Vector<String> v = new Vector<String>();
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


    }
}
