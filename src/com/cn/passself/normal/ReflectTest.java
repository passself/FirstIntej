package com.cn.passself.normal;

public class ReflectTest {

    static class Student{
        public Student(){}
    }

    public static void main(String[] args) {
        Student student = new Student();
        Class c1 = Student.class;
        Class c2 = student.getClass();
        System.out.println(c1 == c2);
    }
}
