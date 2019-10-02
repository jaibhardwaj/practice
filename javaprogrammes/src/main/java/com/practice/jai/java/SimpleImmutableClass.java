package com.practice.jai.java;

import java.io.*;

public final class SimpleImmutableClass
{
    private final int id;
    private final String name;

    public SimpleImmutableClass(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public SimpleImmutableClass modify(String name)
    {
        if(name.equals(this.name))
        {
            return this;
        }

        return new SimpleImmutableClass(this.id, name);
    }
}

class Dog implements Serializable
{
    int i = 10;
    int j = 20;
}
class SerializeDemo
{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        Dog d1 = new Dog();

        FileOutputStream fos = new FileOutputStream("abc.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(d1);

        FileInputStream fis = new FileInputStream("abc.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Dog d2 = (Dog)ois.readObject();

        System.out.println(d2.i+ "....." + d2.j);
    }
}
