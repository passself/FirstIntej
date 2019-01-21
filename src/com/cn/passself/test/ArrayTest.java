package com.cn.passself.test;

import java.util.*;

/**
 * Created by shx on 2017/6/26.
 */
public class ArrayTest {

    public static void main(String[] args){
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Student student = null;
            if (i%2 == 0) {
                student = new Student("name_" + i, i);
            }else{
                student = new Student(i+ "name", i);
            }
            students.add(student);
        }
        //Collections.selectSort(students);
        Collections.sort(students, new ComprareByName());
        for (Student s : students){
            System.out.println(""+s.name);
        }
    }

    private static class ComprareByName implements Comparator<Student> {
        @Override
        public int compare(Student student, Student t1) {
            //按name 从大到小进行排序
            return t1.name.compareTo(student.name);
        }
    }

    public static class Student implements Comparable<Student>{
        private String name;
        private int id;

        public Student(String name, int id) {
            this.name = name;
            this.id = id;
        }

        @Override
        public int compareTo(Student o) {
            return name.compareTo(o.name);
        }
    }
}
