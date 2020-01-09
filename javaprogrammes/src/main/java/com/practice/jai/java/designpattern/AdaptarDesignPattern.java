package com.practice.jai.java.designpattern;

interface Bird
{
    void makeSound();
    void fly();
}

interface ToyDuck
{
    void squeek();
}

class Sparrow implements Bird
{

    @Override
    public void makeSound()
    {
        System.out.println("Sparrow Making Sound!");
    }

    @Override
    public void fly()
    {
        System.out.println("Sparrow Flying!");
    }
}

class PlasticDuck implements ToyDuck
{

    @Override
    public void squeek()
    {
        System.out.println("PlasticDuck Squeeking!");
    }
}

class BirdAdaptor implements ToyDuck
{
    private Bird bird;

    public BirdAdaptor(Bird bird)
    {
        this.bird = bird;
    }

    @Override
    public void squeek()
    {
        bird.makeSound();
    }
}


public class AdaptarDesignPattern
{
    public static void main(String[] args)
    {
        Bird sparrow = new Sparrow();
        ToyDuck plastic = new PlasticDuck();
        sparrow.makeSound();
        sparrow.fly();
        plastic.squeek();

        ToyDuck birdAdaptor = new BirdAdaptor(sparrow);
        birdAdaptor.squeek();

    }
}
