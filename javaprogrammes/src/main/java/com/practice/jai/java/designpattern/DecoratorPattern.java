package com.practice.jai.java.designpattern;

interface Car
{
    void assemble();
}

class BaseCar implements Car
{
    @Override
    public void assemble()
    {
        System.out.println("Basic Car!");
    }
}

class CarDecorator implements Car
{
    protected Car c;
    CarDecorator(Car c)
    {
        this.c = c;
    }
    @Override
    public void assemble()
    {
        this.c.assemble();
    }
}

class SportsCar extends CarDecorator
{
    SportsCar(Car c)
    {
        super(c);
    }

    @Override
    public void assemble()
    {
        this.c.assemble();
        System.out.println("Adding Feature of SportsCar");
    }
}

class LuxuryCar extends CarDecorator
{
    LuxuryCar(Car c)
    {
        super(c);
    }

    @Override
    public void assemble()
    {
        this.c.assemble();
        System.out.println("Adding Feature of LuxuryCar");
    }
}
public class DecoratorPattern
{
    public static void main(String[] args)
    {
        Car c = new LuxuryCar(new SportsCar(new BaseCar()));
        c.assemble();
    }
}
