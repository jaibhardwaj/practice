package com.practice.jai.java.collections;

import java.util.Arrays;
import java.util.Map;

public class MyConcurrentHashMap
{
    private Node[] table;

    public MyConcurrentHashMap()
    {
        this.table = new Node[15];
    }

    private class Node implements Map.Entry<String, String>
    {

        private int hash;
        private String key;
        private String value;
        private Node next;
        private Node prev;

        public Node(int hash, String key, String value)
        {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }

        @Override
        public String getKey()
        {
            return this.key;
        }

        @Override
        public String getValue()
        {
            return this.value;
        }

        @Override
        public String setValue(String value)
        {
            String val = this.value;
            this.value = value;
            return val;
        }

        public Node getNext()
        {
            return next;
        }

        public void setNext(Node next)
        {
            this.next = next;
        }

        public Node getPrev()
        {
            return prev;
        }

        public void setPrev(Node prev)
        {
            this.prev = prev;
        }
    }


    public void put(String key, String value)
    {
        if(null == key)
        {
            putNullKey(key, value);
        }

        int hash = hash(key);
        Node node = new Node(hash, key, value);
        if (table[hash] == null)
        {
            table[hash] = node;
        }
        else
        {
            Node node1 = table[hash];
            synchronized (node1)
            {
                String s = checkAndPutToExistingValue(node1, key, value);
                if (null == s)
                {
                    Node newNode = new Node(hash, key, value);
                    newNode.setNext(node1);
                    node1.setPrev(newNode);
                    table[hash] = newNode;
                }
            }
        }
    }

    /*public String get(String key)
    {}*/

    private String checkAndPutToExistingValue(Node node, String key, String value)
    {
        String oldValue = null;
        while (node != null)
        {
            if(node.getKey().equals(key))
            {
                oldValue = node.setValue(value);
                break;
            }
            node = node.getNext();
        }
        return oldValue;
    }

    private void putNullKey(String key, String value)
    {
        Node node = new Node(value.hashCode(), key, value);
        table[0] = node;
    }

    private int hash(String key)
    {
        return key.hashCode();
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyConcurrentHashMap that = (MyConcurrentHashMap) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(table, that.table);
    }

    @Override
    public int hashCode()
    {
        return Arrays.hashCode(table);
    }
}
