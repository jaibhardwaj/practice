package com.practice.jai.ds;

public class StackUsingLinkedList
{
    private Node head;

    public void push(int data)
    {
        Node node = new Node();
        node.setData(data);
        if(head != null)
        {
            node.setNextNode(head);
        }
        head = node;
    }

    public void pop()
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
