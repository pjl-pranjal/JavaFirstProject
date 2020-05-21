package com.sapient.week7;

import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

public class Demo 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        Scanner reader = new Scanner(System.in);
        
        System.out.println("Enter employee code:");
        Integer empCode = Integer.parseInt(reader.nextLine());
        System.out.println((Employee)context.getBean("e" + empCode));
        ((ConfigurableApplicationContext) context).close();
        
        ApplicationContext context1 = new AnnotationConfigApplicationContext(BeansJava.class);
        EmpMap map = context1.getBean(EmpMap.class);
        System.out.println("Enter employee code:");
        Integer empCode1 = Integer.parseInt(reader.nextLine());
        System.out.println(map.getMap().get(empCode1));
        ((ConfigurableApplicationContext) context1).close();
        
        reader.close();
    }
}
