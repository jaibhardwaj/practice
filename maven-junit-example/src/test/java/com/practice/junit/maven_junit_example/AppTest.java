package com.practice.junit.maven_junit_example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

/*import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;*/

/**
 * Unit test for simple App.
 */
public class AppTest {
	
	private int[] testArray;
	
	@BeforeClass
	public static void before() {
		System.out.println("Before Class"); 
	}
	
	@AfterClass
	public static void after() {
		System.out.println("After Class");
	}
	
	@Before
	public void setUp() {
		System.out.println("Before");
		 testArray = new int[]{1,0,4,2};
	}
	
	@After
	public void tearDown() {
		System.out.println("After");
	}
	
	@Test
	@Category(GoodTestCategory.class)
	public void findMaxTest() {
		//Given
		int data = App.findMax(testArray);
		
		//then
		assertEquals("Given Number is not the Max Number!!",4, data);
	}
	
	@Test
	@Category({GoodTestCategory.class, BadTestCategory.class})
	public void findMinTest() {
		
		//Given
		int data = App.findMin(testArray);
		
		//then
		//assertEquals("Given Number is not the Min Number!!",0, data);
		assertThat("Given Number is not the Min Number!!", data, is(0));
	}
	
}
