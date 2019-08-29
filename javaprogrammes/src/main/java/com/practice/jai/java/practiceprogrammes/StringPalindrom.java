package com.practice.jai.java.practiceprogrammes;

public class StringPalindrom
{
    public static void main(String[] args)
    {
        System.out.println(1234%10);
        System.out.println(1234/10);
        /*System.out.println(reverseString("krishan"));
        System.out.println(isPalindrome("jai"));
        System.out.println(recursiveReverseString("jai"));*/
        System.out.println(recursiveReverseString("jai"));
    }

    public static String reverseString(String string)
    {
        String str = string;
        String rev = "";
        while (str.length() > 0)
        {
            rev = rev + str.charAt(str.length() - 1);
            str = str.substring(0, str.length() - 1);
        }
        return rev;
    }

    public static String recursiveReverseString(String string)
    {
        if(string==null || string.isEmpty())
        {
            return string;
        }
        return string.charAt(string.length() - 1) + reverseString(string.substring(0, string.length() - 1));
    }

    public static String isPalindrome(String string)
    {
        String str = string;
        int a = str.length() - 1;
        int b = 0;
        while (a >= 0)
        {
            char end = str.charAt(a);
            char start = str.charAt(b);
            if (end != start)
            {
                return "Not Palindrome";
            }
            a--;
            b++;
        }
        return "Palindrome";
    }
}
