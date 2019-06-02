package com.jai.practice.basics;

public class Triangle implements Shape
{
    private String type;
    private int height;

    public Triangle(String type, int height) {
        this.type = type;
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void draw()
    {
        System.out.println(getType() + " Triangle Drawn with height " + getHeight());
    }
}
