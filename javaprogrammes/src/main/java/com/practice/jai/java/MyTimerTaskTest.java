package com.practice.jai.java;

import java.util.Timer;
import java.util.TimerTask;

public class MyTimerTaskTest
{
    public static void main(String[] args) {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Timer Task Running");
            }
        };

        Timer timer = new Timer();
        timer.schedule(timerTask, 0, 1000);
    }
}
