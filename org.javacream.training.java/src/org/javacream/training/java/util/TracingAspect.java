package org.javacream.training.java.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TracingAspect implements InvocationHandler {

	private Object delegate;

	public TracingAspect(Object delegate) {
		this.delegate = delegate;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		String methodName = method.getName();
		System.out.println("entering " + methodName);
		try {
			Object result = method.invoke(delegate, args);
			System.out.println("returning from " + methodName);
			return result;
		} catch (InvocationTargetException ite) {
			System.out.println("throwing from " + methodName);
			throw ite.getTargetException();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T trace(Object o) {
		TracingAspect tracingAspect = new TracingAspect(o);
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		Class<?>[] interfaces = o.getClass().getInterfaces();
		return (T) Proxy.newProxyInstance(classLoader, interfaces, tracingAspect);
	}

}
