package org.javacream.training.java.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectionUtility {

	public static void inspect(Object o) {
		Class<?> clazz = o.getClass();
		printMethods(clazz);
		printFields(clazz);
	}

	private static void printFields(Class<?> clazz) {

		Field[] fields = clazz.getDeclaredFields();
		Arrays.asList(fields).forEach(f -> System.out.println(f.getName()));
	}

	private static void printMethods(Class<?> clazz) {
		Method[] methods = clazz.getMethods();
		Arrays.asList(methods).forEach(m -> System.out.println(m.getName()));
	}

	public static void dumpFields(Object o) {
		Class<?> clazz = o.getClass();
		Field[] fields = clazz.getDeclaredFields();
		Arrays.asList(fields).forEach(f -> {
			f.setAccessible(true);
			try {
				System.out.println(f.getName() + "=" + f.get(o));
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		});

	}

}
