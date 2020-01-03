package com.practice.jai.java.practiceprogrammes;

public class Student
{
    private int id;
    private String name;

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    private Student(StudentBuilder builder)
    {
        this.id = builder.id;
        this.name = builder.name;
    }

    public static class StudentBuilder
    {
        private int id;
        private String name;

        private StudentBuilder()
        {
        }

        public StudentBuilder setId(int id)
        {
            this.id = id;
            return this;
        }

        public StudentBuilder setName(String name)
        {
            this.name = name;
            return this;
        }

        public static StudentBuilder newBuilder()
        {
            return new StudentBuilder();
        }
        public Student build()
        {
            return new Student(this);
        }
    }
}
