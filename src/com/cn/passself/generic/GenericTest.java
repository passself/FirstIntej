package com.cn.passself.generic;

/**
 * Created by shx on 2017/8/7.
 * 泛型的测试类
 */
public class GenericTest {

    public static void main(String[] args){

        NumberPair<Integer,Double> pair = new NumberPair<>(10,200.0);
        System.out.println(pair.sum());

        DynamicArray<Number> numbers = new DynamicArray<>();
        numbers.add(100);
        DynamicArray<Double> doubles = new DynamicArray<>();
        doubles.add(100.0);

        numbers.addAll(doubles);//第一种方式
        numbers.addAllNew(doubles);//第二种方式

        //doubles.copyTo(numbers);//编译不过
        doubles.copyToNew(numbers);

        DynamicArray<Child> childs = new DynamicArray<>();
        childs.add(new Child(100));
        childs.add(new Child(200));
        Child child = childs.maxNew(childs);
        System.out.println(child.getSort());
    }
}
