package com.practice.junit.maven_junit_example;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParameterizedPractice {

	private static App app= new App();
	
	private int[] input;
	private int expected;

	@Parameters
	public static List<Object[]> data(){
		return Arrays.asList(new Object[][] {
			{new int[]{2,3,1,0}, 3},
			{new int[]{7,2,5,8}, 8},
			{new int[]{3,2,5,0}, 5},
			{new int[]{2,9,1,5}, 9}
		});
	}
	
	public ParameterizedPractice(int[] input, int epected) {
		this.input = input;
		this.expected = epected;
	
	}
	
	@Test
	public void parameterTest() {
		assertEquals(expected, app.findMax(input));
	}
}
