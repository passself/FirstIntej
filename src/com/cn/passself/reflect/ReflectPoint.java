package com.cn.passself.reflect;

public class ReflectPoint {
	public int x;
	private int y;
	
	public String str1 = "ball";
	public String str2 = "basketball";
	public String str3 = "abc";
	
	public ReflectPoint(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	
	
	public int getX() {
		return x;
	}



	public void setX(int x) {
		this.x = x;
	}



	public int getY() {
		return y;
	}



	public void setY(int y) {
		this.y = y;
	}



	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "str1--"+str1+"--str2--"+str2+"--str3--"+str3;
	}
}
