package com.practice.jai.java.designpattern;

abstract class House
{
    public final void buildHouse()
    {
        buildWall();
        buildPiller();
        buildWindow();
        buildDoor();
    }

    protected abstract void buildDoor();

    protected abstract void buildWindow();

    public void buildPiller()
    {
        System.out.println("Build Piller!!");
    }

    public void buildWall()
    {
        System.out.println("Build Wall!!");
    }
}

class BuildWoodenHouse extends House
{

    @Override
    protected void buildDoor()
    {
        System.out.println("Build Wooden Door!!");
    }

    @Override
    protected void buildWindow()
    {
        System.out.println("Build Wooden Window!!");
    }
}

class BuildSteelHouse extends House
{

    @Override
    protected void buildDoor()
    {
        System.out.println("Build Steel Door!!");
    }

    @Override
    protected void buildWindow()
    {
        System.out.println("Build Steel Window!!");
    }
}

public class TemplateMethodPattern
{
    public static void main(String[] args)
    {
        House woodenHouse = new BuildWoodenHouse();
        woodenHouse.buildHouse();
        House steelHouseHouse = new BuildSteelHouse();
        steelHouseHouse.buildHouse();
    }
}
