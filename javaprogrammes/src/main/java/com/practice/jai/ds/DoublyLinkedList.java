package com.practice.jai.ds;

public class DoublyLinkedList
{
    private DoublyNode head;

    public void addElement(int data)
    {
        DoublyNode doublyNode = new DoublyNode();
        doublyNode.setData(data);
        if(head != null)
        {
            doublyNode.setNextNode(head);
            head.setPreviousNode(doublyNode);
            head = doublyNode;
        }
        head = doublyNode;
    }

    public void deleteElement()
    {
        if(head != null)
        {
            head = head.getNextNode();
            head.setPreviousNode(null);
        }
    }

    public void insertAtSortedList(int data)
    {
        DoublyNode doublyNode = new DoublyNode();
        doublyNode.setData(data);
        if(head == null){
            head = doublyNode;
        }
        else
        {
            DoublyNode current = head;
            while (current != null)
            {
                if(data < head.getData())
                {
                    addElement(data);
                    break;
                }
                else if (data < current.getData())
                {
                    doublyNode.setNextNode(current);
                    doublyNode.setPreviousNode(current.getPreviousNode());
                    current.getPreviousNode().setNextNode(doublyNode);
                    break;
                }
                current = current.getNextNode();
            }
        }
    }

    @Override
    public String toString()
    {
        DoublyNode node = head;
        StringBuilder data = new StringBuilder("data { ");
        while (node != null)
        {
            data.append(node.getData()).append(" ");
            node = node.getNextNode();
        }
        return data.toString() + "}";
    }
}
