package com.hcl.Spring.Dao;


import com.hcl.Spring.Util.Out;
import lombok.Data;
import lombok.ToString;

@ToString
public class Student {

    private long id;

    private String address;

    public Student(long id ,String address){
        this.id = id;
        this.address =address;
    }

    public Student(){

    }

    public static Student getInstance(){
        return new Student();
    }

    public void start(){
        Out.Print("开始初始化bean");
    }

    public void end(){
        Out.Print("销毁bean");
    }
}
