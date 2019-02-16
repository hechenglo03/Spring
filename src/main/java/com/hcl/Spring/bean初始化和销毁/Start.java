package com.hcl.Spring.bean初始化和销毁;

import com.hcl.Spring.Dao.Person;
import com.hcl.Spring.Dao.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Start {

    /**
     * bean注解当中
     * <bean id = "two" class = "com.hcl.Spring.Dao.Student" init-method="start" destroy-method="end"></bean>
     * init-method 指定bean初始化之前的方法
     * destory-method指定bean销毁之前的方法
     *
     */
    @Test
    public void Dev(){
        ApplicationContext app =
                new ClassPathXmlApplicationContext("bean.xml");
        Student student = (Student) app.getBean("two");
        System.out.println(student);

        //关闭spring的ioc容器可以销毁对象
        if(app instanceof AbstractApplicationContext)
        {
            ((AbstractApplicationContext)app).registerShutdownHook();

        }
    }

    /**
     * 实现类Person实现了InitializingBean,DisposableBean来实现了bean初始化之前的操作和销毁之前的操作
     */
    @Test
    public void Test1(){
        ApplicationContext app =
                new ClassPathXmlApplicationContext("bean.xml");
        Person person = (Person) app.getBean("three");

        if(app instanceof AbstractApplicationContext){
            ((AbstractApplicationContext)app).registerShutdownHook();
        }
    }
}
