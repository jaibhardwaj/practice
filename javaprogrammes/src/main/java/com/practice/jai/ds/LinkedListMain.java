package com.practice.jai.ds;

public class LinkedListMain
{
    public static void main(String[] args)
    {
        LinkedList1 linkedList1 = new LinkedList1();
        linkedList1.addElement(7);
        linkedList1.addElement(5);
        linkedList1.addElement(4);
        linkedList1.addElement(5);
        linkedList1.addElement(7);
        System.out.println(linkedList1);
        linkedList1.removeDuplicate();
        System.out.println(linkedList1);

    }
}
