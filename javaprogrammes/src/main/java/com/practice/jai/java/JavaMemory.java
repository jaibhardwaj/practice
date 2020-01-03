package com.practice.jai.java;

import com.practice.jai.Department;
import com.practice.jai.Employee;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class JavaMemory
{
    public static void main(String[] args)
    {
        Employee e = new Employee(1, "jai", 20, "fbd", "ind", new Department("IT"));
        Employee e1 = null;
        Class c = e.getClass();
        c.getName();

        Constructor[] declaredConstructors = c.getDeclaredConstructors();
        for (Constructor cons: declaredConstructors)
        {
            cons.setAccessible(true);
            try
            {
                e1 = (Employee) cons.newInstance();
            }
            catch (InstantiationException | IllegalAccessException | InvocationTargetException ex)
            {
                ex.printStackTrace();
            }
        }


        JavaMemory jm = new JavaMemory();
    }

    public void m1()
    {}
}
