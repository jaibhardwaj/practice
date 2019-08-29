package com.practice.jai.java.practiceprogrammes;

public class ArrayReverse
{
    public static void main(String[] args)
    {
        int[] arr ={1,2,3,4,5,7};
        reverse(arr);
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
    }

    public static void reverse(int[] arr)
    {
        int mid = arr.length/2;
        for (int i = 0; i < mid; i++)
        {
            int temp = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = arr[i];
            arr[i] = temp;
        }
    }
}
