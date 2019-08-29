package com.practice.jai.java.practiceprogrammes;

public class PrintDuplicateCharacterInString
{
    static final int NO_OF_CHARS = 256;
    public static void main(String[] args)
    {

        String s= "india";
        int[] count = new int[NO_OF_CHARS];
        filterCharacter(s, count);
        for (int i = 0; i < count.length; i++)
        {
            if (count[i]> 1)
            {
                System.out.printf("%c count = %d \n", i, count[i]);
            }
        }
    }

    public static void filterCharacter(String str, int[] count)
    {
        for (int i = 0; i < str.length(); i++)
        {
            count[str.charAt(i)]++;
        }
    }
}
