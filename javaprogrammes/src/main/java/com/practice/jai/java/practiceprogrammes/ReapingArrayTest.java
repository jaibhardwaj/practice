package com.practice.jai.java.practiceprogrammes;

import java.util.HashSet;

public class ReapingArrayTest
{
    public static void main(String[] args)
    {
        int[] arr = {10, 5, 3, 4, 3, 5, 6};
        ReapingArrayTest ob = new ReapingArrayTest();
        int element1 = ob.findFirstRepeatingElement(arr);
        int element2 = ob.findFirstNotRepeatingElement(arr);
        System.out.println(element1);
        System.out.println(element2);
    }

    public int findFirstRepeatingElement(int[] arr)
    {
        HashSet<Integer> set = new HashSet<>();
        int min = -1;
        for (int i = arr.length - 1; i >= 0 ; i--)
        {
            if (set.contains(arr[i]))
            {
                min = i;
            }
            else
            {
                set.add(arr[i]);
            }
        }
        return arr[min];
    }

    public int findFirstNotRepeatingElement(int[] arr)
    {
        HashSet<Integer> set = new HashSet<>();
        int min = -1;
        for (int i = arr.length - 1; i >= 0 ; i--)
        {
            if (!set.contains(arr[i]))
            {
                min = i;
            }
            else
            {
                set.add(arr[i]);
            }
        }
        return arr[min];
    }
}
