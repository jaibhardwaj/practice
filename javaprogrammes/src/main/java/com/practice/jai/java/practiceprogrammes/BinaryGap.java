package com.practice.jai.java.practiceprogrammes;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class BinaryGap
{
    public static void main(String[] args)
    {
        binaryGap(32);
    }

    public static void binaryGap(int num) {
        String s = Integer.toBinaryString(num);
        System.out.println("Binary String :- " + s);
        char[] chars = s.toCharArray();
        char firstChar = chars[0];
        int maxGap = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < chars.length; i++)
        {
            if (chars[i] == '0')
            {
                count++;
            }
            else if (chars[i] == '1')
            {
                if (firstChar != '0')
                {
                    if (maxGap < count)
                    {
                        maxGap = count;
                    }
                    firstChar = chars[i];
                    count = 0;
                }
            }
        }
        System.out.println("Max BinaryGap:- " + maxGap);
    }

}
