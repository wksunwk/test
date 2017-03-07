package annotation.test2;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MyAnnotationTest {

	public static void main(String[] args) {
		
		MyAnnotationDemo demo = new MyAnnotationDemo("Hello qscsed!");
		MyAnnotationClass aClass = demo.getClass().getAnnotation(MyAnnotationClass.class);
		System.out.println(aClass.msg());
		
		try {
			Method method = demo.getClass().getDeclaredMethod("print", new Class[0]);
			MyAnnotationMethod aMethod = method.getAnnotation(MyAnnotationMethod.class);
			System.out.println(aMethod.common());
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Field field = demo.getClass().getDeclaredField("hello");
			MyAnnotationField aField = field.getAnnotation(MyAnnotationField.class);
			System.out.println(aField.request());
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
