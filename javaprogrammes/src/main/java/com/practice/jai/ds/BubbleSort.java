package com.practice.jai.ds;

public class BubbleSort
{
    public static void main(String[] args)
    {
        int[] arr = {4, 2, 3, 1, 9};

        for (int i = 0; i < arr.length; i++)
        {
            for (int j = 0; j < arr.length - 1; j++)
            {
                if(arr[j] > arr[j+1])
                {
                    swap(j, j+1, arr);
                }
            }
        }

        printArray(arr);
    }

    public static void swap(int i, int j, int[] arr)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(int[] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
    }
}
