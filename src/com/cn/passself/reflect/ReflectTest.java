package com.cn.passself.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 类 在内存中的字节码
 * @author shihx1
 *
 */
public class ReflectTest {
	
	public static void main(String[] args) throws Exception{
		String str = "abc";
		
		Class str1 = str.getClass();
		Class str2 = String.class;
		Class str3 = Class.forName("java.lang.String");
		
		System.out.println(str1 == str2);
		System.out.println(str1 == str3);
		
		System.out.println(str1.isPrimitive());
		System.out.println(int.class.isPrimitive());
		
		Constructor constructors = String.class.getConstructor(StringBuffer.class);
		System.out.println(constructors.getName());
		
		
		ReflectPoint rfp1 = new ReflectPoint(3, 5);
		//不是某个对象身上的变量，而是类上的
		Field field1 = rfp1.getClass().getDeclaredField("y");
		field1.setAccessible(true);
		System.out.println(field1.get(rfp1));
		
		changeStrValue(rfp1);
		System.out.println(rfp1.toString());
		
		/**
		 * 反射方法的调用
		 */
		Method methodCharAt = String.class.getMethod("charAt", int.class);
		char result = (char)methodCharAt.invoke(str, 1);
		System.out.println(result);
		
		//TestArguments.main(new String[]{"a","b"});
		//main方法的反射测试
		String startingClassName = "com.pass.self.reflect.TestArguments";//args[0];
		Method method = Class.forName(startingClassName).getMethod("main", String[].class);
		method.invoke(null, new Object[]{new String[]{"111","222","333"}});
		
		System.out.println("test git");
	}
	
	/**
	 * 用反射替换字符，字段的替换
	 * @param obj
	 * @throws Exception
	 */
	private static void changeStrValue(Object obj) throws Exception{
		Field[] fields = obj.getClass().getFields();
		for(Field field:fields){
			if(field.getType() == String.class){//字节码一致，用==
				String oldValue = (String)field.get(obj);
				String newValue = oldValue.replace("a","x");
				field.set(obj, newValue);
			}
		}
	}
	
	private static void reflectMethod(Object obj) throws Exception{
		Field field = ReflectPoint.class.getField("x");
		String x = (String)field.get(obj);
		System.out.println(x);
	}
}

class TestArguments{
	public static void main(String[] args) {
		for(String arg:args){
			System.out.println("TestArguments "+ arg);
		}
	}
}
