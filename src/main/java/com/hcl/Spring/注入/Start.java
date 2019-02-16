package com.hcl.Spring.注入;

import com.hcl.Spring.Dao.Person;
import com.hcl.Spring.Dao.Student;
import com.hcl.Spring.Util.Out;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Start {

    /**
     * <bean id = "student" class = "com.hcl.Spring.Dao.Student">
            <constructor-arg value="90"></constructor-arg>
            <constructor-arg value="CHENZHUANG"></constructor-arg>
        </bean>
     构造器注入依据于构造函数传入参数顺序
     */
    @Test
    public void construst(){
        ApplicationContext app =
                new ClassPathXmlApplicationContext("bean.xml");
        Student student = (Student) app.getBean("student");
        Out.Print(student);
    }

    /**
     * 通过静态工厂方法来生成bean
     * <bean id = "factory" class = "com.hcl.Spring.Dao.Student"
        factory-method="getInstance"></bean>
        getInstance 为 Student当中一个方法
     */
    @Test
    public void factory(){
        ApplicationContext app =
                new ClassPathXmlApplicationContext("bean.xml");
        Student student = (Student) app.getBean("factory");
        Out.Print(student);
    }

    /**
     *
     * 验证了bean的作用域，分别为singleton(默认) prototype
     * <bean id = "one" class = "com.hcl.Spring.Dao.Student" scope="prototype">
     </bean>
     */
    @Test
    public void Single(){
        ApplicationContext app =
                new ClassPathXmlApplicationContext("bean.xml");
        Student factory = (Student) app.getBean("factory");
        Student one = (Student) app.getBean("one");
        System.out.println(one == factory);
    }

    /**
     *
     * 通过set方法注入属性，通过<propery 通过set方法注入属性
     * <bean id = "Pfour" class = "com.hcl.Spring.Dao.Person">
        <property name="address" value="one"></property>
        <property name="name" value="yi"></property>
       </bean>
     */
    @Test
    public void Test2(){
        ApplicationContext app =
                new ClassPathXmlApplicationContext("bean.xml");
        Person person = (Person) app.getBean("Pfour");
        Out.Print(person);
    }

    /**
     * 使用set方法注入
     * <bean id = "five" class = "com.hcl.Spring.Dao.Person">
     <property name="address" value="ONE"></property>
     <property name="name" value = "一"></property>
     <property name="student" ref="student"></property> ref 指定空间中的Student对象
     </bean>
     */
    @Test
    public void Test3(){
        ApplicationContext app =
                new ClassPathXmlApplicationContext("bean.xml");
        Person person = (Person) app.getBean("five");
        Out.Print(person);
    }
}
