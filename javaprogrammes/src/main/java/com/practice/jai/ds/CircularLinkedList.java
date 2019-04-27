package com.practice.jai.ds;

import java.util.HashSet;

public class CircularLinkedList
{
    private Node head = null;
    private Node tail;


    public void addElementAtHead(int data)
    {
        Node node = new Node();
        node.setData(data);
        if(head == null)
        {
            head = node;
            tail = node;
            tail.setNextNode(head);
        }
        else
        {
            node.setNextNode(head);
            head = node;
            tail.setNextNode(head);
        }
    }

    public void addElementAtTail(int data)
    {
        Node node = new Node();
        node.setData(data);
        if(head == null)
        {
            addElementAtHead(data);
        }
        else
        {
            tail.setNextNode(node);
            node.setNextNode(head);
            tail = node;
        }
    }

    public void deleteElementFromHead()
    {
        if(head != null)
        {
            head = head.getNextNode();
            tail.setNextNode(head);
        }
    }

    public boolean detectLoop()
    {
        Node current = head;

        while (current != null)
        {
            HashSet s = new HashSet();
            if(current == head)
            {
                return true;
            }
            if(s.contains(current))
            {
                return true;
            } else {
                s.add(current);
            }

            current = current.getNextNode();
        }
        return false;
    }

    @Override
    public String toString()
    {
        Node node = head;
        StringBuilder data = new StringBuilder("data { ");
        do
        {
            data.append(node.getData()).append(" ");
            node = node.getNextNode();
        }
        while ((node != head));
        return data.toString() + "}";
    }
}
