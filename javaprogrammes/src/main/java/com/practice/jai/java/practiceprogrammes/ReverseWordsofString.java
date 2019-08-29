package com.practice.jai.java.practiceprogrammes;

public class ReverseWordsofString
{
    public static void main(String[] args)
    {
        System.out.println(reverseWords("My Name is Jai"));
    }

    public static String reverseWords(String string)
    {
        String[] arr = string.split("\\s");
        String reverseStr ="";
        for (int i = arr.length - 1; i >= 0 ; i--)
        {
            reverseStr = reverseStr + " " + arr[i];
        }
        return reverseStr;
    }
}
