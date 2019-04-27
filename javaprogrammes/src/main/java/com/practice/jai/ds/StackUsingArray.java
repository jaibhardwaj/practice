package com.practice.jai.ds;

public class StackUsingArray
{
    private int maxSize = 10;
    private Integer[] arr = new Integer[10];
    private int top = -1;

    public void push(int data)
    {
        if (top == arr.length - 1)
        {
            Integer[] newArr = new Integer[2 * maxSize];
            System.arraycopy( arr, 0, newArr,0, arr.length);
            arr = newArr;
        }
        top++;
        arr[top] = data;
    }

    public void pop()
    {
        if(top >= 0)
        {
            arr[top] = null;
            top --;
        }
    }

    public int peek()
    {
        int data = -1;

        if(top >= 0)
        {
            data = arr[top];
        }
        return data;
    }


    @Override
    public String toString()
    {
        StringBuilder data = new StringBuilder("data { ");
        for (int i = top; i >=0; i--)
        {
            data.append(arr[i]).append(" ");
        }
        return data.toString() + "}";
    }
}
