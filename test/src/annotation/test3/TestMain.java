package annotation.test3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

public class TestMain {
	@UserAnnotation(age=20,gender="F",id=2014,name="zhangsan")
	private Object obj = null;
	
	public static void main(String[] args) {
		/*
		 * 注解的功能分为2部分：
		 * 作为特定的标记
		 * 额外信息的载体
		 */
		try {
			Field objField = TestMain.class.getDeclaredField("obj");
			UserAnnotation a = objField.getAnnotation(UserAnnotation.class);
			System.out.println(a.age() + a.gender() + a.id() + a.name());//得到注解,起到了标记的作用
			
			//***进一步操作的话，假设Object要指向一个User类，那么可以讲注解的值给他
		    TestMain tm = new TestMain();
			objField.set(tm, tm.new User(a.age(), a.gender(), a.id(), a.name())); //不错吧，将自己的信息送给obj，起到了附加信息的作用
			System.out.println(tm.obj);
			
			//-----------请自由遐想吧~~，下面来说说注解怎么能获得注解自己的注解-------------
			Target t = a.annotationType().getAnnotation(Target.class);
			ElementType[] values = t.value();
			System.out.println(values[0]);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	class User {
		public int id;
		public String name;
		public int age;
		public String gender;

		public User(int age, String gender, int id, String name) {
			this.id = id;
			this.gender = gender;
			this.name = name;
			this.age = age;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return id + ";" + name + ";" + age + ";" + gender;
		}
	}
}
