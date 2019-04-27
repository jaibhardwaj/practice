package com.practice.jai.ds;

public class QueueUsingLinkedList
{
    private Node head;
    private Node tail;

    public void add(int data)
    {
        Node node = new Node();
        node.setData(data);
        if(head == null)
        {
            head = node;
        }
        else
        {
            tail.setNextNode(node);
        }
        tail = node;
    }

    public void remove()
    {
        if(head != null)
        {
            head = head.getNextNode();
        }
    }


    @Override
    public String toString()
    {
        Node node = head;
        StringBuilder data = new StringBuilder("data { ");
        while (node != null)
        {
            data.append(node.getData()).append(" ");
            node = node.getNextNode();
        }
        return data.toString() + "}";
    }

}
