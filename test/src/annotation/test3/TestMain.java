package annotation.test3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

public class TestMain {
	@UserAnnotation(age=20,gender="F",id=2014,name="zhangsan")
	private Object obj = null;
	
	public static void main(String[] args) {
		/*
		 * ע��Ĺ��ܷ�Ϊ2���֣�
		 * ��Ϊ�ض��ı��
		 * ������Ϣ������
		 */
		try {
			Field objField = TestMain.class.getDeclaredField("obj");
			UserAnnotation a = objField.getAnnotation(UserAnnotation.class);
			System.out.println(a.age() + a.gender() + a.id() + a.name());//�õ�ע��,���˱�ǵ�����
			
			//***��һ�������Ļ�������ObjectҪָ��һ��User�࣬��ô���Խ�ע���ֵ����
		    TestMain tm = new TestMain();
			objField.set(tm, tm.new User(a.age(), a.gender(), a.id(), a.name())); //����ɣ����Լ�����Ϣ�͸�obj�����˸�����Ϣ������
			System.out.println(tm.obj);
			
			//-----------�����������~~��������˵˵ע����ô�ܻ��ע���Լ���ע��-------------
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
