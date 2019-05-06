package com.practice.jai.java.singleton;

public class EarlyLoadingUsingStaticBlockSingleton
{
    private static EarlyLoadingUsingStaticBlockSingleton instance = null;

    static
    {
        try
        {
            instance =  new EarlyLoadingUsingStaticBlockSingleton();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public static EarlyLoadingUsingStaticBlockSingleton getInstance()
    {
        return instance;
    }

}
