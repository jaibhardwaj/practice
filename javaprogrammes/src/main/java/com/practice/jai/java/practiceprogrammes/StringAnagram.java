package com.practice.jai.java.practiceprogrammes;

public class StringAnagram
{
    public static void main(String[] args)
    {
        //System.out.println(isAnagram("tops", "stop"));
        System.out.println(isAnagram2("tops", "stop"));
    }

    public static boolean isAnagram(String word, String anagram)
    {
        if(word.length() != anagram.length())
        {
            return false;
        }
        char[] ch = word.toCharArray();

        for (char c: ch)
        {
            int index = anagram.indexOf(c);
            if(index != -1)
            {
                anagram = anagram.substring(0, index) + anagram.substring(index + 1, anagram.length());
            }
            else
            {
                return false;
            }
        }

        return anagram.isEmpty();
    }

    public static boolean isAnagram2(String word1, String word2)
    {
        if(word1.length() != word2.length())
        {
            return false;
        }
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        int[] count = new int[256];

        for (int i = 0; i < chars1.length && i < chars2.length; i++)
        {
            count[chars1[i]]++;
            count[chars2[i]]--;
        }

        for (int i = 0; i < count.length; i++)
        {
            if (count[i] > 0)
            {
                return false;
            }
        }

        return true;
    }
}
