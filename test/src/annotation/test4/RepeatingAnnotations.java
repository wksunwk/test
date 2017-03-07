package annotation.test4;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class RepeatingAnnotations {

	@Target(value = { ElementType.TYPE })
	@Retention(value = RetentionPolicy.RUNTIME)
	public @interface Filters {
		Filter[] value();
	}

	@Target(value = { ElementType.TYPE })
	@Retention(value = RetentionPolicy.RUNTIME)
	@Repeatable(Filters.class)
	public @interface Filter {
		String value();
	}

	/*
	 * �����Filter��ʹ��@Repeatable(Filters.class)ע�����Σ�
	 * ��Filters�Ǵ��Filterע��������������������Կ�����������Щϸ�ڡ�
	 * ������Filterable�ӿڿ���������Filterע��ע�ͣ����ﲢû���ᵽ�κι���Filters����Ϣ����
	 */
	@Filter( "filter1" )
	@Filter( "filter2" )
	@Filter( "filter3" )
	public interface Filterable {

	}

	/*
	 * �Դ�Java 5������ע��������������Կ�ʼ��÷ǳ����У����ڸ�����ܺ���Ŀ�б��㷺ʹ�á�
	 * ������ע����һ���ܴ�������ǣ���ͬһ���ط����ܶ��ʹ��ͬһ��ע�⡣
	 * Java 8������������ƣ��������ظ�ע��ĸ��������ͬһ���ط����ʹ��ͬһ��ע�⡣
	 * ��Java 8��ʹ��@Repeatableע�ⶨ���ظ�ע�⣬ʵ���ϣ��Ⲣ�������Բ���ĸĽ���
	 * ���Ǳ���������һ��trick���ײ�ļ�����Ȼ��ͬ��
	 */
	public static void main(String[] args) {
		for (Filter f : Filterable.class.getAnnotationsByType(Filter.class)) {
			System.out.println(f.value());
		}
//		
		for (Filter f : Filterable.class.getAnnotation(Filters.class).value()) {
			System.out.println(f.value());
		}
	}
}
