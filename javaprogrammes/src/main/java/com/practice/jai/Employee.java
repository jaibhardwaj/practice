package com.practice.jai;

public class Employee {
    private int id;
    private String name;
    private int age;
    private String city;
    private String country;
    private Department department;

    public Employee(int id, String name, int age, String city, String country, Department department) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.city = city;
        this.country = country;
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee(int id, String name, int age, String city, String country) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.city = city;
        this.country = country;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", department=" + department +
                '}';
    }
}
