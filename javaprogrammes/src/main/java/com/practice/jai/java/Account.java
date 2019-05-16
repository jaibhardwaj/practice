package com.practice.jai.java;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Account implements Serializable
{
    String un = "Durga";
    transient String pwd = "Anushka";

    private void writeObject(ObjectOutputStream os) throws Exception
    {
        os.defaultWriteObject();	//meant for default Serialization
        String epwd = "123"+pwd;
        os.writeObject(epwd);
    }

    private void readObject(ObjectInputStream is) throws Exception
    {
        is.defaultReadObject();
        String epwd = (String)is.readObject();
        pwd = epwd.substring(3);
    }
}
