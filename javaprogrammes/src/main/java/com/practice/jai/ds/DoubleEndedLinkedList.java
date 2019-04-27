package com.practice.jai.ds;

import com.jai.DoublyEndedLinkedList;

public class DoubleEndedLinkedList
{
    private DoubleEndedNode head;
    private DoubleEndedNode tail;

    public void addElementAtHead(int data)
    {
        DoubleEndedNode doubleEndedNode = new DoubleEndedNode();
        doubleEndedNode.setData(data);
        if(head == null)
        {
            head = doubleEndedNode;
            tail = doubleEndedNode;
        }
        else
        {
           doubleEndedNode.setNextNode(head);
           head = doubleEndedNode;
        }
    }

    public void addElementAtTail(int data)
    {
        DoubleEndedNode doubleEndedNode = new DoubleEndedNode();
        doubleEndedNode.setData(data);
        if(tail == null)
        {
            head = doubleEndedNode;
            tail = doubleEndedNode;
        }
        else
        {
           tail.setNextNode(doubleEndedNode);
           doubleEndedNode.setPreviousNode(tail);
           tail = doubleEndedNode;
        }
    }

    public void deleteElementAtHead()
    {
        if(head != null)
        {
            if(head == tail)
            {
                head = null;
                tail = null;
            }
            else
            {
                head = head.getNextNode();
                head.setPreviousNode(null);
            }
        }
    }

    public void deleteElementAtTail()
    {
        if(tail != null)
        {
            if(head == tail)
            {
                head = null;
                tail = null;
            }
            else
            {
                tail = tail.getPreviousNode();
                tail.setNextNode(null);
            }
        }
    }

    public String printFromTail()
    {
        DoubleEndedNode node = tail;
        StringBuilder data = new StringBuilder("data { ");
        while (node != null)
        {
            data.append(node.getData()).append(" ");
            node = node.getPreviousNode();
        }
        return data.toString() + "}";
    }

    @Override
    public String toString()
    {
        DoubleEndedNode node = head;
        StringBuilder data = new StringBuilder("data { ");
        while (node != null)
        {
            data.append(node.getData()).append(" ");
            node = node.getNextNode();
        }
        return data.toString() + "}";
    }
}
