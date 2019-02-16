package com.hcl.Spring.Dao;

import com.hcl.Spring.Util.Out;
import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

@Data
@ToString
public class Person implements InitializingBean,DisposableBean{

    private String name;

    private String address;

    private Student student;


    public void afterPropertiesSet() throws Exception {
        Out.Print("开始启动初始化");
    }

    public void destroy() throws Exception {
        Out.Print("开始销毁bean");
    }
}
