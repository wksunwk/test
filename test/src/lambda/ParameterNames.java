package lambda;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ParameterNames {

	public static void main(String[] args) {
		try {
			Method m = ParameterNames.class.getMethod("main", String[].class);
			
			/*
			 * 为了在运行时获得Java程序中方法的参数名称，老一辈的Java程序员必须使用不同方法，例如Paranamer liberary。
			 * Java 8终于将这个特性规范化，在语言层面（使用反射API和Parameter.getName()方法）和字节码层面（使用新的javac编译器以及-parameters参数）提供支持。
			 */
			for (Parameter p : m.getParameters()) {
				System.out.println("parameter: " + p.getName());
			}
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
