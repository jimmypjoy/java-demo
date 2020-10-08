package com.samples.java8;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionSample {

	public static void main(String[] args) {
		try {
			Class<TestReflection> cl = TestReflection.class;
			System.out.println(cl.getName());
			System.out.println("##### Constructors");
			Constructor<?>[] constructors = cl.getConstructors();
			for (Constructor<?> constructor : constructors) {
				System.out.println(constructor);
			}

			System.out.println("##### Methods");
			Method[] methods = cl.getMethods();
			for (Method method : methods) {
				System.out.println(method);
			}

			System.out.println("##### Invoke construtor");
			Constructor<?> const1 = cl.getConstructor(null);
			const1.newInstance(null);
			Constructor<?> const2 = cl.getConstructor(String.class);
			Object obj = const2.newInstance("test..");

			System.out.println("##### Invoke Mthod");
			Method method1 = cl.getMethod("getStr1", null);
			System.out.println(method1.invoke(obj, null));
			Method method2 = cl.getMethod("testMthodPublic", Integer.class);
			method2.invoke(obj, 10);

			System.out.println("##### Accessing provate variable");
			Field field1 = cl.getDeclaredField("str1");
			field1.setAccessible(true);
			field1.set(obj, "test new");
			System.out.println(method1.invoke(obj, null));

			System.out.println("##### Accessing Annotations");
			Annotation[] annotations = cl.getAnnotations();
			for (Annotation annotation : annotations) {
				System.out.println(annotation);
			}
			AnnotationExample annotationExample = (AnnotationExample) annotations[0];
			System.out.println(annotationExample.value1());
			System.out.println(annotationExample.value2());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

@AnnotationExample(value1 = "123", value2 = "456")
class TestReflection {
	private String str1;

	public TestReflection() {
		System.out.println("inside empty constructor");
	}

	public TestReflection(String str) {
		System.out.println("inside constructor: paramter passed: " + str);
		this.str1 = str;
	}

	public void testMthodPublic(Integer i) {
		System.out.println("public void testMthodPublic()- integer passed: " + i);
	}

	private void testMthodPrivate() {
		System.out.println("private void testMthodPrivate()");
	}

	public String getStr1() {
		return str1;
	}

	public void setStr1(String str1) {
		this.str1 = str1;
	}
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface AnnotationExample {
	public String value1();

	public String value2();

}
