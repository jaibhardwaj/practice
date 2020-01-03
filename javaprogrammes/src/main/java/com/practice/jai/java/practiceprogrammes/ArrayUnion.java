package com.practice.jai.java.practiceprogrammes;

public class ArrayUnion
{
    public static void main(String[] args)
    {
        int[] arr1 = {1, 3, 4, 5, 7};
        int[] arr2 = {2, 3, 5, 6};
        //output = {1, 2, 3, 4, 5, 6, 7}
        makeUnion(arr1, arr2);
    }

    private static void makeUnion(int[] arr1, int[] arr2)
    {
        int[] unionArray = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int count = 0;
        while (i < arr1.length && j < arr2.length)
        {
            if (arr1[i] < arr2[j])
            {
                unionArray[count] = arr1[i];
                i++;
            }
            else if (arr1[i] > arr2[j])
            {
                unionArray[count] = arr2[j];
                j++;
            }
            else
            {
                unionArray[count] = arr1[i];
                i++;
                j++;
            }
            count++;
        }

        while ( i < arr1.length)
        {
            unionArray[count] = arr1[i];
            i++;
            count++;
        }
        while ( j < arr2.length)
        {
            unionArray[count] = arr2[j];
            j++;
            count++;
        }

        for (int k = 0; k < unionArray.length; k++)
        {
            System.out.print(unionArray[k] + " ");
        }
    }

}
