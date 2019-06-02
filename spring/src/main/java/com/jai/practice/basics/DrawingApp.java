package com.jai.practice.basics;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class DrawingApp
{
    public static void main(String[] args) {
        //BeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("classpath*:spring.xml");
        /*Triangle triangle = (Triangle) beanFactory.getBean("triangle");
        triangle.draw();*/
        context.registerShutdownHook();

        /*Shape shape = (Shape) context.getBean("newTriangle");
        shape.draw();*/

        Shape shape1 = (Shape) context.getBean("circle");
        shape1.draw();
    }
}
