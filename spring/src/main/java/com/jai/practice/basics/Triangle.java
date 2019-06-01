package com.jai.practice.basics;

public class Triangle implements Shape
{
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void draw()
    {
        System.out.println(getType() + " Triangle Drawn!");
    }
}
