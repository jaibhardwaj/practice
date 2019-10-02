package com.practice.jai.java.collections;

import com.practice.jai.ds.Node;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

public class MyHashMap2<K, V>
{
    private DataNode[] table;
    private int size;

    public MyHashMap2(int size)
    {
        this.size = size;
        table = new DataNode[size];
    }

    public static class DataNode<K, V>
    {
        private K key;
        private V value;
        private DataNode<K, V> nextNode;
        private int hash;

        public DataNode(K key, V value, DataNode<K, V> nextNode, int hash)
        {
            this.key = key;
            this.value = value;
            this.nextNode = nextNode;
            this.hash = hash;
        }

        public K getKey()
        {
            return key;
        }

        public V getValue()
        {
            return value;
        }

        public void setValue(V value)
        {
            this.value = value;
        }

        public void setNextNode(DataNode<K, V> nextNode)
        {
            this.nextNode = nextNode;
        }

        @Override public String toString()
        {
            return key + "-"+ value;
        }
    }

    private int getKey(K k)
    {
        return k.hashCode() % size;
    }

    public V put(K key, V value)
    {
        if (key == null)
        {
            table[0] = new DataNode<>(key, value, null, 0);
            return null;
        }
        int hashKey = getKey(key);
        DataNode<K,V> node = new DataNode<>(key, value, null, hashKey);
        if (table[hashKey] == null)
        {
            table[hashKey] = node;
        }
        else
        {
            V duplicateValue = (V) addDuplicateNode(table[hashKey], key, value);
            if(duplicateValue == null)
            {
                node.setNextNode(table[hashKey]);
                table[hashKey] = node;
            }
            else
            {
                return duplicateValue;
            }
        }
        return null;
    }

    private V addDuplicateNode(DataNode<K, V> current, K key, V value)
    {
        V duplicateValue = null;
        while (current != null)
        {
            if(current.getKey().equals(key))
            {
                duplicateValue = current.getValue();
                current.setValue(value);
            }
            current = current.nextNode;
        }

        return duplicateValue;
    }

    public V get(K key)
    {
        int hashKey = getKey(key);
        DataNode<K, V> current = table[hashKey];
        V value = null;
        while (current != null)
        {
            if(current.getKey().equals(key))
            {
                value = current.getValue();
            }
            current = current.nextNode;
        }
        return value;
    }

    @Override public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++)
        {
            DataNode current = table[i];
            while (current != null)
            {
                sb.append(current);
                sb.append(", ");
                current = current.nextNode;
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
