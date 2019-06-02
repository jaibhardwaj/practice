package com.jai.practice.basics;

public class NewTriangle implements Shape
{
    private Point pointA;
    private Point pointB;
    private Point pointC;

    /*public NewTriangle(Point pointA, Point pointB, Point pointC) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
    }*/

    public Point getPointA() {
        return pointA;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
    }

    public Point getPointC() {
        return pointC;
    }

    public void setPointC(Point pointC) {
        this.pointC = pointC;
    }

    @Override
    public void draw() {
        System.out.println("New Triangle created with Point A " + getPointA().getX() + ", " + getPointA().getY() +
                " Point B " + getPointB().getX() + ", " + getPointB().getY() + " Point C " + getPointC().getX() + ", " + getPointC().getY());
    }
}
