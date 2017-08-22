package com.cn.passself.sign.proxy;

public class ProxyClient {
	
	public static void main(String[] args) {
		Subject subject = new RealSubject();
		Proxy proxy = new Proxy(subject);
		proxy.operate();
	}
}
