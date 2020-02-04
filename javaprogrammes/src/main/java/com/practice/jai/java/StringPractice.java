package com.practice.jai.java;

public class StringPractice
{
    public static void main(String[] args)
    {
        /*String s1 = new String("durga");
        s1.concat("software");
        String s2 = s1.concat("solutions");
        s1 = s1.concat("soft");
        System.out.println(s1);
        System.out.println(s2);*/

        String s1 = new String("durga");
        String s2 = s1.intern();
        System.out.println(s1 == s2);	//false
        String s3 = "durga";
        System.out.println(s2 == s3);	//true
    }
}
