package com.zyj.proxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

public class Test {
	public static void main(String[] args) {
		byte[] bytes = ProxyGenerator.generateProxyClass("proxy", new Class[]{ITest.class});
		try {
			FileOutputStream fos = new FileOutputStream("/Users/yingjiezhong/Desktop/proxy.class");
			fos.write(bytes);
			fos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
