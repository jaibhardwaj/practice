package com.practice;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Triangle implements Shape
{

	public void drawShape()
	{
		System.out.println("Triangle Drawn!");
	}

}
