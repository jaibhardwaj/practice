package com.jai.practice.basics;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class MyEventListener implements ApplicationListener
{

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println(event);
    }
}
