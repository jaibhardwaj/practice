package com.jai.practice.basics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class Circle implements Shape, ApplicationEventPublisherAware
{
    @Autowired
    private Point center;
    private ApplicationEventPublisher applicationEventPublisher;

    public Point getCenter() {
        return center;
    }

    /*public void setCenter(Point center) {
        this.center = center;
    }*/

    @Override
    public void draw()
    {
        System.out.println("Circle Drawn with center " + getCenter().getX() + ", " + getCenter().getY());
        MyDrawingEvent myDrawingEvent = new MyDrawingEvent(this);
        applicationEventPublisher.publishEvent(myDrawingEvent);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
