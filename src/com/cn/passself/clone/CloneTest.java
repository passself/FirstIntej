package com.cn.passself.clone;

/**
 * Created by shx on 2017/8/11.
 */
public class CloneTest {

    public static void main(String[] args) throws Exception{
        FatherClass fatherA = new FatherClass();
        fatherA.name = "张三";
        fatherA.age = 28;

        FatherClass fatherB = (FatherClass) fatherA.clone();

        //浅拷贝
        showOut("fatherA==fatherB? "+(fatherA == fatherB));
        showOut("fatherA.hashCode()) is:"+fatherA.hashCode());
        showOut("fatherB.hashCode()) is:"+fatherB.hashCode());

        //深拷贝
        showOut("fatherA.child==fatherB.child is:"+(fatherA.child == fatherB.child));
        showOut("fatherA.child.hashCode is:"+fatherA.child.hashCode());
        showOut("fatherB.child.hashCode is:"+fatherB.child.hashCode());
    }

    public static void showOut(String str){
        System.out.println(str);
    }
}
