package com.cn.passself.sign.proxy;

public class Proxy implements Subject {
	
	private Subject subject;
	
	public Proxy(Subject subject) {
		// TODO Auto-generated constructor stub
		this.subject = subject;
	}
	
	@Override
	public void operate() {
		// TODO Auto-generated method stub
		subject.operate();
	}

}
