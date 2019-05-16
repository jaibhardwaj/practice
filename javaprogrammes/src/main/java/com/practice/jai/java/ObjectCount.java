package com.practice.jai.java;

import java.io.Serializable;

        public class ObjectCount implements Cloneable
{
    static int count;
    {
        count++;
    }
    public static void main(String[] args) throws CloneNotSupportedException {

        for (int i = 0; i < 10; i++)
        {
            ObjectCount o1 = new ObjectCount();
        }
        System.out.println(count);

        ObjectCount o1 = new ObjectCount();
        ObjectCount o2 = (ObjectCount) o1.clone();

    }
}
