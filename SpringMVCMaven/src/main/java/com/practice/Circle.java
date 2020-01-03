package com.practice;

import org.springframework.stereotype.Component;

@Component
public class Circle implements Shape
{

	public void drawShape()
	{
		System.out.println("Circle Drawn!");
	}

}
