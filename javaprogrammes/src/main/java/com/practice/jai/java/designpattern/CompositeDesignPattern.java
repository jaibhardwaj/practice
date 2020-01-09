package com.practice.jai.java.designpattern;

import java.util.ArrayList;
import java.util.List;

interface Shape
{
    void fillColor(String color);
}

class Triangle implements Shape
{
    @Override
    public void fillColor(String color)
    {
        System.out.println("Triangle Filled with color : " + color);
    }
}

class Circle implements Shape
{

    @Override
    public void fillColor(String color)
    {
        System.out.println("Circle Filled with color : " + color);
    }
}

class Drawing
{
    private List<Shape> shapeList = new ArrayList<>();

    public void addShape(Shape shape)
    {
        shapeList.add(shape);
    }

    public void drawShapes(String color)
    {
        shapeList.forEach((shape) ->
        {
            shape.fillColor(color);
        });
    }
}


public class CompositeDesignPattern
{
    public static void main(String[] args)
    {
        Drawing drawing = new Drawing();
        Shape triangle =new Triangle();
        Shape circle =new Circle();
        drawing.addShape(triangle);
        drawing.addShape(circle);
        drawing.drawShapes("Green");
        drawing.drawShapes("Red");
    }
}
