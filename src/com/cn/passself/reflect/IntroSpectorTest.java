package com.cn.passself.reflect;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class IntroSpectorTest {
	
	public static void main(String[] args) throws Exception{
		ReflectPoint point = new ReflectPoint(3, 5);
		String propertyName = "x";
		System.out.println(getProperty(point, propertyName));
		
		setProperty(point, propertyName);
	}

	private static void setProperty(ReflectPoint point, String propertyName)
			throws IntrospectionException, IllegalAccessException,
			InvocationTargetException {
		PropertyDescriptor pd = new PropertyDescriptor(propertyName, point.getClass());
		Method setMethod = pd.getWriteMethod();
		setMethod.invoke(point, 7);
	}

	private static Object getProperty(ReflectPoint point, String propertyName)
			throws IntrospectionException, IllegalAccessException,
			InvocationTargetException {
		/*PropertyDescriptor pd = new PropertyDescriptor(propertyName, point.getClass());
		Method methodX = pd.getReadMethod();
		Object retValue = methodX.invoke(point);
		System.out.println(retValue);*/
		Object retValue=null;
		BeanInfo beanInfo = Introspector.getBeanInfo(point.getClass());
		PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
		for(PropertyDescriptor pd:descriptors){
			if(pd.getName().equals(propertyName)){
				Method methodX = pd.getReadMethod();
				retValue = methodX.invoke(point);
			}
		}
		
		return retValue;
	}
}
