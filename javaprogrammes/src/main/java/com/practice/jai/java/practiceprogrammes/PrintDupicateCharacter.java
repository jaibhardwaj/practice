package com.practice.jai.java.practiceprogrammes;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PrintDupicateCharacter
{
    public static void main(String[] args)
    {
        printDuplicateCharacter("india");
    }

    public static void printDuplicateCharacter(String str)
    {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] c = str.toCharArray();
        for (int i = 0; i < c.length; i++)
        {
            if(map.containsKey(c[i]))
            {
                map.put(c[i], map.get(c[i]) + 1);
            }
            else
            {
                map.put(c[i], 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet())
        {
            if (entry.getValue() > 1)
            {
                System.out.printf("%s : %d %n", entry.getKey(), entry.getValue());
            }
        }
    }
}
