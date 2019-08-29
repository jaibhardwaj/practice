package com.practice.jai.ds;

public class BinarySearch
{
    public static void main(String[] args)
    {
        int[] arr = {1, 2, 5, 7, 8};
        int num = 5;

        int l = 0;
        int h = arr.length - 1;
        while (h >= l)
        {
            int mid = (l + h)/2;
            if (num == arr[mid])
            {
                System.out.println("Number Found at Index:- " + mid);
                break;
            }
            else if(num > arr[mid])
            {
                l = mid + 1;
            }
            else
            {
                h = mid - 1;
            }
        }
    }
}
