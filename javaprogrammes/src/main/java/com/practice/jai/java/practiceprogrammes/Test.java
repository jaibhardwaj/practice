package com.practice.jai.java.practiceprogrammes;

import java.util.HashMap;

public class Test
{
    public static void main(String[] args)
    {
        /*int[] arr1 = {2,4,5,7,9};
        int[] arr2 = {9,4,7,5};

        int missingValue = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++)
        {
            map.put(arr2[i], arr2[i]);
        }
        for (int i = 0; i < arr1.length; i++)
        {
            if(map.get(arr1[i]) == null)
            {
                missingValue = arr1[i];
                break;
            }
        }
        *//*for (int i = 0; i < arr1.length; i++)
        {
            if(map.put(arr1[i], arr1[i]) == null)
            {
                missingValue = arr1[i];
                break;
            }
        }*//*
        System.out.printf("Missing Value:- " + missingValue);*/

        /*HashMap<Integer, Integer> map1 = new HashMap<>();
        int[] arr3 = {1,2,2,3,4,5,6,7,7};
        for (int i = 0; i < arr3.length; i++)
        {
            if(map1.containsKey(arr3[i]))
            {
                map1.put(arr3[i], map1.get(arr3[i]) + 1);
            }
            else
            {
                map1.put(arr3[i], 1);
            }
        }

        System.out.println(map1);*/

        Student s = Student.StudentBuilder.newBuilder().setId(2).build();
        System.out.println(s.getId());

    }
}
