package com.practice.jai.java.collections;

import com.practice.jai.java.ObjectCount;
import javafx.scene.web.WebHistory;

public class MyHashMap
{
    private Node[] table;

    public MyHashMap()
    {
        table = new Node[10];
    }

    public boolean put(String key, String value)
    {
        if (key==null)
            return false;

        int index = hash(key);
        Node newNode = new Node(hash(key), key, value, null);
        if(table[index] == null)
        {
            synchronized (table[index])
            {
                table[index] = newNode;
            }
        }
        else {
            String val = getValueOfNode(table[index], newNode);
            if(val == null) {
                newNode.next = table[index];
                table[index] = newNode;
            }
        }

        return true;
    }


    public String get(String key)
    {
        if(key != null)
        {
            int index = hash(key);
            if(table[index].key.equals(key))
            {
                return table[index].value;
            }
            else
            {
                Node n = table[index];
                while (n != null)
                {
                    if(n.key.equals(key))
                    {
                        return n.value;
                    }
                    n = n.next;
                }
            }
        }

        return null;
    }

    private String getValueOfNode(Node head, Node newNode)
    {
        Node n = head;
        while (n !=null)
        {
            if(n.key.equals(newNode.key) && n.value.equals(newNode.value))
            {
               return n.value;
            }
            n = n.next;
        }
        return null;
    }

    private int hash(String key)
    {
        return key.length() % table.length;
    }

    private class Node
    {
        private int hash;
        private String key;
        private String value;
        private Node next;

        public Node(int hash, String key, String value, Node next)
        {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public String getValue()
        {
            return value;
        }

        public String getKey()
        {
            return key;
        }
    }

    public void printMap()
    {
        for (int i = 0; i < 10; i++)
        {
            if (table[i] != null )
            {
                Node n = table[i];
                while (n != null)
                {
                    System.out.println("Key: " + n.key + " : " + "Value: " + n.value);
                    n = n.next;
                }
            }
        }
    }

}
