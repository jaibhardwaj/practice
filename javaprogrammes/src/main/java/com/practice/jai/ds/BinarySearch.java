package com.practice.jai.ds;

public class BinarySearch
{
    public static void main(String[] args)
    {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int num = 3;

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
