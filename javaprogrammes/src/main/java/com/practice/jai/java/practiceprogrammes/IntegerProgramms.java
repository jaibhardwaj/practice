package com.practice.jai.java.practiceprogrammes;

public class IntegerProgramms
{
    public static void main(String[] args)
    {
        System.out.println(reverseNumber(1001));
        System.out.println(palindromeNumber(1001));
    }

    public static int reverseNumber(int num)
    {
        int revNum = 0;
        while (num > 0)
        {
            revNum = revNum * 10 + num % 10;
            num = num / 10;
        }

        return revNum;
    }

    public static boolean palindromeNumber(int num)
    {
        int newNum = num;
        int revNum = 0;
        while (newNum > 0)
        {
            revNum = revNum * 10 + newNum % 10;
            newNum = newNum / 10;
        }

        return revNum == num;
    }
}
