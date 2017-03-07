package annotation.test1;

import java.lang.reflect.Field;

public class TestAnnotations {
	
	@TestTarget(doTestTarget = "Hello World!")
	private String str = null;
	
	@TestTarget(doTestTarget = "Hello World again!")
	private int i = 0;

	public static void main(String[] args) {
		
		try {
			Class<?> clazz = Class.forName("annotation.test1.TestAnnotations");
//			Class<?> clazz = TestAnnotations.class;
			Field f = clazz.getDeclaredField("str");
			TestTarget t = f.getAnnotation(TestTarget.class);
			System.out.println(t.doTestTarget());
			
			f = clazz.getDeclaredField("i");
			t = f.getAnnotation(TestTarget.class);
			System.out.println(t.doTestTarget());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
