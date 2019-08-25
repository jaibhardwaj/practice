package com.practice.jai;

public class SelectionSort
{
    public static void main(String[] args)
    {
        int[] arr = {4, 2, 3, 1, 9};

        for (int i = 0; i < arr.length; i++)
        {
            int minIndex = i;

            for (int j = i; j < arr.length; j++)
            {
                if(arr[j] < arr[minIndex])
                {
                    minIndex = j;
                }
            }

            swap(i, minIndex, arr);
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
