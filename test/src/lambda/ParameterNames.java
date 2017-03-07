package lambda;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ParameterNames {

	public static void main(String[] args) {
		try {
			Method m = ParameterNames.class.getMethod("main", String[].class);
			
			/*
			 * Ϊ��������ʱ���Java�����з����Ĳ������ƣ���һ����Java����Ա����ʹ�ò�ͬ����������Paranamer liberary��
			 * Java 8���ڽ�������Թ淶���������Բ��棨ʹ�÷���API��Parameter.getName()���������ֽ�����棨ʹ���µ�javac�������Լ�-parameters�������ṩ֧�֡�
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
