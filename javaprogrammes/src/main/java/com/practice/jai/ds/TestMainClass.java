package com.practice.jai.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class TestMainClass
{
    public static void main(String[] args)
    {

        /********* Singly Linked List *************/
        LinkedList1 linkedList1 = new LinkedList1();
        linkedList1.addElement(7);
        linkedList1.addElement(5);
        linkedList1.addElement(4);
        linkedList1.addElement(2);
        linkedList1.addElement(1);

        System.out.println("Middle Element:- "+linkedList1.middleElement());

        System.out.println("Linked List:- "+linkedList1);

        linkedList1.insertAtSortedList(6);
        linkedList1.insertAtSortedList(0);

        System.out.println("Data added Sorted Linked List:- "+linkedList1);

        linkedList1.deleteElementFromHead();

        System.out.println("Linked List After Delete:- "+linkedList1);

        System.out.println("Linked List After Reverse:- "+linkedList1.reverse());

        LinkedList1 linkedList2 = new LinkedList1();
        linkedList2.addElement(7);
        linkedList2.addElement(5);
        linkedList2.addElement(5);
        linkedList2.addElement(4);
        linkedList2.addElement(1);
        linkedList2.addElement(1);
        linkedList2.addElement(3);

        System.out.println("Linked List With Duplicates :- "+linkedList2);

        System.out.println("Linked List After Duplicate removal :- "+linkedList2.removeDuplicates());






        /********* Doubly Linked List *************/
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.addElement(7);
        doublyLinkedList.addElement(5);
        doublyLinkedList.addElement(4);
        doublyLinkedList.addElement(2);
        doublyLinkedList.addElement(1);

        System.out.println("Doubly Linked List:- "+doublyLinkedList);

        doublyLinkedList.insertAtSortedList(6);
        doublyLinkedList.insertAtSortedList(0);

        System.out.println("Data added Sorted Doubly Linked List:- "+doublyLinkedList);

        doublyLinkedList.deleteElement();

        System.out.println("Doubly Linked List After Delete:- "+doublyLinkedList);






        /********* Double Ended Linked List *************/
        DoubleEndedLinkedList doubleEndedLinkedList = new DoubleEndedLinkedList();
        doubleEndedLinkedList.addElementAtHead(5);
        doubleEndedLinkedList.addElementAtHead(2);
        doubleEndedLinkedList.addElementAtHead(6);
        doubleEndedLinkedList.addElementAtHead(8);
        doubleEndedLinkedList.addElementAtHead(1);

        System.out.println("Doubly Ended Linked List:- "+doubleEndedLinkedList);

        doubleEndedLinkedList.deleteElementAtHead();

        System.out.println("Doubly Ended Linked List After Delete:- "+doubleEndedLinkedList);

        DoubleEndedLinkedList doubleEndedLinkedList1 = new DoubleEndedLinkedList();
        doubleEndedLinkedList1.addElementAtTail(5);
        doubleEndedLinkedList1.addElementAtTail(2);
        doubleEndedLinkedList1.addElementAtTail(6);
        doubleEndedLinkedList1.addElementAtTail(8);
        doubleEndedLinkedList1.addElementAtTail(1);

        System.out.println("Doubly Ended Linked List Tail:- "+doubleEndedLinkedList1);
        System.out.println("Doubly Ended Linked List Tail Print:- "+doubleEndedLinkedList1.printFromTail());

        doubleEndedLinkedList1.deleteElementAtTail();

        System.out.println("Doubly Ended Linked List Tail After Delete:- "+doubleEndedLinkedList1);





        /********* Circular Linked List *************/
        CircularLinkedList circularLinkedList = new CircularLinkedList();
        circularLinkedList.addElementAtHead(5);
        circularLinkedList.addElementAtHead(2);
        circularLinkedList.addElementAtHead(6);
        circularLinkedList.addElementAtHead(8);
        circularLinkedList.addElementAtHead(1);

        System.out.println("Circular Linked List:- "+circularLinkedList);

        circularLinkedList.deleteElementFromHead();

        circularLinkedList.addElementAtTail(15);
        circularLinkedList.addElementAtTail(11);
        circularLinkedList.addElementAtTail(12);
        circularLinkedList.addElementAtTail(14);
        circularLinkedList.addElementAtTail(19);

        System.out.println("Circular Linked ListAfter Delete:- "+circularLinkedList);



        /********* Stack Using Linked List *************/

        StackUsingLinkedList stackUsingLinkedList = new StackUsingLinkedList();
        stackUsingLinkedList.push(5);
        stackUsingLinkedList.push(7);
        stackUsingLinkedList.push(3);
        stackUsingLinkedList.push(8);
        stackUsingLinkedList.push(1);
        stackUsingLinkedList.push(0);

        System.out.println("Stack Using LinkedList: - " + stackUsingLinkedList);
        stackUsingLinkedList.pop();
        stackUsingLinkedList.pop();
        System.out.println("Stack Using LinkedList After Pop: - " + stackUsingLinkedList);



        /********* Stack Using Array *************/

        StackUsingArray stackUsingArray = new StackUsingArray();
        stackUsingArray.push(1);
        stackUsingArray.push(2);
        stackUsingArray.push(3);
        stackUsingArray.push(4);
        stackUsingArray.push(5);
        stackUsingArray.push(6);
        stackUsingArray.push(7);
        stackUsingArray.push(8);
        stackUsingArray.push(9);
        stackUsingArray.push(10);
        stackUsingArray.push(11);

        System.out.println("Stack Using Array: - " + stackUsingArray);
        stackUsingArray.pop();
        stackUsingArray.pop();
        System.out.println("Stack Using Array After Pop: - " + stackUsingArray);

        System.out.println("Stack Using Array Peek: - " + stackUsingArray.peek());


        /********* Queue Using Linked List *************/

        QueueUsingLinkedList queueUsingLinkedList = new QueueUsingLinkedList();
        queueUsingLinkedList.add(1);
        queueUsingLinkedList.add(2);
        queueUsingLinkedList.add(3);
        queueUsingLinkedList.add(4);
        queueUsingLinkedList.add(5);
        queueUsingLinkedList.add(6);

        System.out.println("Queue Using LinkedList: - " + queueUsingLinkedList);
        queueUsingLinkedList.remove();
        queueUsingLinkedList.remove();
        System.out.println("Queue Using LinkedList After Remove: - " + queueUsingLinkedList);


        /********* Queue Using Array *************/

        QueueUsingArray queueUsingArray = new QueueUsingArray();
        queueUsingArray.add(1);
        queueUsingArray.add(2);
        queueUsingArray.add(3);
        queueUsingArray.add(4);
        queueUsingArray.add(5);
        queueUsingArray.add(6);

        System.out.println("Queue Using Array: - " + queueUsingArray);
        queueUsingArray.remove();
        queueUsingArray.remove();
        System.out.println("Queue Using Array After Remove: - " + queueUsingArray);



    }
}
