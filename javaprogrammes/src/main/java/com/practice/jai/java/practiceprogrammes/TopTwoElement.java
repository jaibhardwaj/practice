package com.practice.jai.java.practiceprogrammes;

public class TopTwoElement
{
    public static void main(String[] args)
    {
        int[] arr = {10, 5, 3, 40, 6};
        int top = Integer.MIN_VALUE;
        int secondTop = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] > top)
            {
                secondTop = top;
                top = arr[i];
            }
            else if(arr[i] > secondTop)
            {
                secondTop = arr[i];
            }
        }
        System.out.println(top + " - " + secondTop);
    }
}
