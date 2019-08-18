package com.practice.jai.java.practiceprogrammes;

public class StringAnagram
{
    public static void main(String[] args)
    {
        System.out.println(isAnagram("tops", "stop"));
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
}
