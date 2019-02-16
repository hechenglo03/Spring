package com.hcl.Spring.xml文件启动;

import com.hcl.Spring.Dao.Student;
import com.sun.xml.internal.ws.api.pipe.ServerTubeAssemblerContext;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Start {

    /**
     * 使用ClassPathXmlApplicationContext加载xml文件，
     * 是从类加载路径下加载，一般而言在maven生成项目当中，把xml文件放在
     *  src/main/resource下面
     */
    @Test
    public void ClassPath(){
        ApplicationContext app =
                new ClassPathXmlApplicationContext("bean.xml");
        Student student = (Student) app.getBean("student");

        System.out.println(student);
    }

    /**
     * FileSystemXmlApplicationContext 加载xml文件是在项目路径下加载的
     * 也就是在src上一级目录当中，
     * 当然也是可以指定绝对路径即F:\NeedProject\java\Spring\src\main\resources\bean.xml
     * ------src
     *         ----java
     *         ----resources
     *
     */
    @Test
    public void FileSystem1(){
        ApplicationContext app =
                new FileSystemXmlApplicationContext("src/main/resources/bean.xml");
        Student student = (Student) app.getBean("student");
        System.out.println(student);
    }

    /**
     * FileSystemXmlApplicationContext 也可以加载classpath下的类
     * 只需要在加载路径上添加classpath即可
     *
     */
    @Test
    public void FileSystem2(){
        ApplicationContext app =
                new FileSystemXmlApplicationContext("classpath:bean.xml");
        Student student = (Student) app.getBean("student");
        System.out.println(student);
    }

}
