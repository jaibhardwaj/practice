package com.practice.jai.java.practiceprogrammes;

public class ReverseWordsofSentence
{
    public static void main(String[] args)
    {
        System.out.println(reverseSentence("My Name is JAI"));
    }

    public static String reverseSentence(String str)
    {
        String[] arr = str.split("\\s");
        String rev = "";
        for (int i = arr.length - 1; i >= 0 ; i--)
        {
            rev = rev + " " + arr[i];
        }

        return rev;
    }
}
