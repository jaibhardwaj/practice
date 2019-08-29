package com.practice.jai.java.practiceprogrammes;

public class RemoveDuplicatesFromArray
{
    public static void main(String[] args)
    {
        /*printArray(removeDuplicate(new int[]{1, 2, 2, 4, 3, 4, 5}));*/
        printArray(removeDuplicateUsingArray(new int[]{1, 2, 2, 3, 3, 4, 5}));
        /*int[] arr = {1, 2, 2, 3, 3, 4, 5};
        int length = removeDuplicateElements(arr, arr.length);
        for (int i=0; i<length; i++) {
            System.out.print(arr[i] + " ");
        }*/
    }


    public static int[] removeDuplicate(int[] arr)
    {
        for (int i = 0; i < arr.length - 1; i++)
        {
            int j = i+1;
            while ( j < arr.length)
            {
                if(arr[i] == arr[j])
                {
                    arr[j] = 0;
                }
                j++;
            }
        }

        return arr;
    }

    /* only works on sorted array*/
    public static int[] removeDuplicateUsingArray(int[] arr)
    {
        /*int[] result = new int[arr.length];
        result[0]= arr[0];
        int j = 0;
        for (int i = 0; i < arr.length; i++)
        {
            if(result[j] != arr[i])
            {
                j++;
                result[j] = arr[i];
            }
        }*/


        int[] result = new int[arr.length];
        int previous = arr[0];
        result[0] = previous;

        for (int i = 1; i < arr.length; i++) {
            int ch = arr[i];

            if (previous != ch) {
                result[i] = ch;
            }
            previous = ch;
        }

        return result;
    }

    public static int removeDuplicateElements(int[] arr, int n)
    {
        if (n==0 || n==1)
        {
            return n;
        }
        int j = 0;//for next element
        for (int i=0; i < n-1; i++)
        {
            if (arr[i] != arr[i+1])
            {
                arr[j++] = arr[i];
            }
        }
        arr[j++] = arr[n-1];
        return j;
    }

    public static void printArray(int[] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }
}
