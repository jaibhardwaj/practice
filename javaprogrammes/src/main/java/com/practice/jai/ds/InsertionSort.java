package com.practice.jai.ds;

public class InsertionSort
{
    public static void main(String[] args)
    {
        int[] arr = {4, 2, 3, 1, 9};

        for (int i = 0; i < arr.length - 1; i++)
        {
            int j = i+1;
            int temp = arr[j];
            while (j > 0)
            {
                if (arr[j - 1] > temp)
                {
                    arr[j] = arr[j - 1];
                }
                else
                {
                    break;
                }
                j--;
            }
            arr[j] = temp;
        }
        printArray(arr);
    }
    private static void printArray(int[] arr)
    {
        for (int value : arr)
        {
            System.out.print(value + " ");
        }
    }
}
