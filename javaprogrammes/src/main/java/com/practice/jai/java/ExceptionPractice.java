package com.practice.jai.java;

import java.io.*;

public class ExceptionPractice
{
    static int x = 1/0;
    public static void main(String[] args) throws MyException {
        System.out.println("start");


        try
        {
            //System.out.println(1/0);
            throw new MyException("HHHHHHH");
            //return;
        }
        catch (NullPointerException e)
        {
            System.out.println("e");
            System.out.println(1/0);
        }
        finally
        {
            System.out.println("end");
            //System.out.println(1/0);
            System.out.println("kk");
        }


    }
}
