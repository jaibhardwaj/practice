package com.practice.jai.java;

import com.practice.jai.Department;
import com.practice.jai.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

interface MyFunctionInterface
{
    void m1();
}
public class FunctionalInterfTest
{
    public static void m2()
    {
        System.out.println("Static Method Implementation..");
    }

    public void m3()
    {
        System.out.println("Instance Method Implementation..");
    }
    public static void main(String[] args)
    {
        Consumer<Object> consumer = ob -> System.out.println(ob.toString());

        Predicate<String> p = a -> a.equals("ja");
        //System.out.println(p.test("j"));
        consumer.accept(p.test("j"));

        Predicate<Integer> p2 =i -> i%2==0;

        Predicate<Integer> p1 = a -> a < 10;
        System.out.println(p1.test(5));

        System.out.println(p1.and(p2).test(6));

        Function<String, Integer> f1 = s -> s.length();
        System.out.println(f1.apply("kl"));

        consumer.accept("jai");

        Supplier<Integer> supplier = () -> Integer.MAX_VALUE;


        BiFunction<Integer, Integer, Integer> biFunction = (a, b) -> (a+b);
        consumer.accept(biFunction.apply(1,2));



        MyFunctionInterface myFunctionInterface1 = FunctionalInterfTest :: m2;
        myFunctionInterface1.m1();

        MyFunctionInterface myFunctionInterface2 = new FunctionalInterfTest() :: m3;
        myFunctionInterface2.m1();


        List<String> list = new ArrayList<String>();
        list.add("Jai");
        list.add("Kri");
        list.add("Bha5");
        list.add("Chi");
        List<String> s1 = list.stream().filter(s -> s.length() < 4).collect(Collectors.toList());
        long count = list.stream().filter(s -> s.length() < 4).count();
        System.out.println(s1);
        System.out.println(count);
        Stream s2 = list.stream().map(s -> s.length());

        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee(1, "jai", 20, "fbd", "ind", new Department("IT")));
        empList.add(new Employee(2, "krishan", 23, "mtj", "ind", new Department("CS")));
        empList.add(new Employee(3, "sachin", 32, "agra", "swe", new Department("Mech")));
        empList.add(new Employee(4, "navdeep", 29, "mumbai", "uk", new Department("ELE")));
        empList.add(new Employee(5, "arun", 40, "hodal", "usa", new Department("Civil")));
        empList.add(new Employee(6, "yogesh", 43, "palwal", "china", new Department("MBA")));

        List<Employee> l1 = empList.stream().filter(employee -> employee.getCountry().equals("ind")).collect(Collectors.toList());
        System.out.println(l1);

        List<Employee> l2 = empList.stream().map(e -> new Employee(e.getId() + 2, e.getName().toUpperCase(),
                e.getAge()+20, e.getCity().toLowerCase(), e.getCountry().toUpperCase())).collect(Collectors.toList());

        System.out.println(l2);

        int summingAge = empList.stream().collect(Collectors.summingInt(Employee::getAge));
        System.out.println(summingAge);

        Map<Department, List<Employee>> byDept
         = empList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(byDept);

    }
}
