package com.practice.jai.java;

public final class ImmutableClassWithMutableProperty
{
    private final int id;
    private final String name;
    private final Age age;

    public ImmutableClassWithMutableProperty(int id, String name, Age age)
    {
        this.id = id;
        this.name = name;
        Age cloneAge = new Age();
        cloneAge.setDay(age.getDay());
        cloneAge.setYear(age.getYear());
        this.age = cloneAge;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public Age getAge()
    {
        Age cloneAge = new Age();
        cloneAge.setDay(this.age.getDay());
        cloneAge.setYear(this.age.getYear());
        return cloneAge;
    }
}

class Age
{
    private int day;
    private int year;

    public int getDay()
    {
        return day;
    }

    public void setDay(int day)
    {
        this.day = day;
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }
}


class MyImTest
{
    public static void main(String[] args)
    {
        SimpleImmutableClass simpleImmutableClass = new SimpleImmutableClass(1, "jai");
        System.out.println(simpleImmutableClass.hashCode());
        System.out.println(simpleImmutableClass.modify("jai").hashCode());
        System.out.println(simpleImmutableClass.modify("krishna").hashCode());

        Age age = new Age();
        age.setDay(9);
        age.setYear(1991);
        ImmutableClassWithMutableProperty classWithMutableProperty = new ImmutableClassWithMutableProperty(1, "jai", age);
        //System.out.println(classWithMutableProperty.hashCode());
        System.out.println(classWithMutableProperty.getAge().getYear());
        classWithMutableProperty.getAge().setYear(1234);
        //System.out.println(classWithMutableProperty.hashCode());
        System.out.println(classWithMutableProperty.getAge().getYear());


    }
}
