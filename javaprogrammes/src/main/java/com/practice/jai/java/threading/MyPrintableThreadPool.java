package com.practice.jai.java.threading;

import java.util.HashMap;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MyPrintableThreadPool
{
    public static void main(String[] args) throws ExecutionException, InterruptedException
    {
        MyCallableJob[] mc = {new MyCallableJob(5),
                              new MyCallableJob(10),
                              new MyCallableJob(15),
                              new MyCallableJob(20),
                              new MyCallableJob(25)};
        ExecutorService es = Executors.newFixedThreadPool(6);
        for (MyCallableJob job: mc)
        {
            Future submit = es.submit(job);
            System.out.println(submit.get());
        }

        Thread t = new Thread(() ->
        {
        });

        Predicate<String> p = s -> s.length() > 5;
        p.test("jai");
    }
}

class MyCallableJob implements Callable
{
    private int num;

    public MyCallableJob(int num)
    {
        this.num = num;
    }

    @Override public Object call() throws Exception
    {
        for (int i = 0; i < 10; i++)
        {
            num = num + 1;
        }
        return num;
    }
}
