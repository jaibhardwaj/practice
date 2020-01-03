package com.practice.jai;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.practice.jai.java.practiceprogrammes.ReapingArrayTest;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    ReapingArrayTest ob = new ReapingArrayTest();
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void firstRepeatingElementTest()
    {
        assertEquals("Values Matched!", 5, ob.findFirstRepeatingElement(new int[] {10, 5, 3, 4, 3, 5, 6}));
    }

    @Test
    public void firstNonRepeatingElementTest()
    {
        assertEquals("Values Matched!", 10, ob.findFirstNotRepeatingElement(new int[] {10, 5, 3, 4, 3, 5, 6}));
    }
}
