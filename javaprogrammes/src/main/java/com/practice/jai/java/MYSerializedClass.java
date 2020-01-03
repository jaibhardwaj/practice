package com.practice.jai.java;

import java.io.*;

public class MYSerializedClass implements Serializable
{
    private String name = "JAI";
    private transient String password = "123";
    public MYSerializedClass()
    {
        System.out.println("Constructor Called!!");
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        MYSerializedClass mySerializedClass = new MYSerializedClass();
        Class<MYSerializedClass> mySerializedClassClass = MYSerializedClass.class;
        Class<? extends MYSerializedClass> aClass = mySerializedClass.getClass();

        System.out.println(mySerializedClass.name + " " + mySerializedClass.password);
        FileOutputStream fos = new FileOutputStream("xyz.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(mySerializedClass);
        System.out.println("Deserialization Started");

        FileInputStream fis = new FileInputStream("xyz.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        MYSerializedClass cl = (MYSerializedClass) ois.readObject();
        System.out.println(cl.name + " " + cl.password);
    }

    private void writeObject(ObjectOutputStream oos) throws Exception
    {
        oos.defaultWriteObject();
        oos.writeObject(password + "jai");
    }
    private void readObject(ObjectInputStream ois) throws Exception
    {
        ois.defaultReadObject();
        String ps = (String) ois.readObject();
        password =ps.substring(0,3);
    }
}

class MyCustomSerClass implements Externalizable
{
    private String name;
    private int id;

    public MyCustomSerClass()
    {
        System.out.println("Constructor Called!!");
    }

    public MyCustomSerClass(String name, int id)
    {
        this.name = name;
        this.id = id;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        MyCustomSerClass c = new MyCustomSerClass("jai", 1);
        FileOutputStream fos = new FileOutputStream("exter.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(c);
        System.out.println("Deserialization Started");
        FileInputStream fis = new FileInputStream("exter.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        MyCustomSerClass c1 = (MyCustomSerClass) ois.readObject();
        System.out.println(c1.id + " " + c1.name);

    }

    @Override public void writeExternal(ObjectOutput out) throws IOException
    {
        out.writeObject(name);
        out.writeInt(1);
    }

    @Override public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
    {
        name = (String) in.readObject();
        id = in.readInt();
    }
}
