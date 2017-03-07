package annotation.test3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * ע��@Target��Դ��
 *  @Documented
    @Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.ANNOTATION_TYPE) //�ⲻ�������ף���ȷʵ���Լ�ע���Լ�������˵ע��Ҳ���Ա��Լ���ע��
	public @interface Target {
    	ElementType[] value(); //ֵ����ʹ���� value={...}
	}
 
		public enum ElementType {
	    TYPE,  //���ࣨ�ͣ�ע��
	    FIELD, //���ֶ�ע�⣬��Ҫ���ˣ��ֶο����Ƕ���
	    METHOD, //������ע��
	    PARAMETER, //������ע��
	    CONSTRUCTOR, //�����췽��ע��
	    LOCAL_VARIABLE, //���ֲ�����ע��
	    ANNOTATION_TYPE,//��ע��ע�⣨��ò�ư��Լ�������������
	    PACKAGE, //����ע��
	    TYPE_PARAMETER, //��֪������֪��������д������
	    TYPE_USE //���Ҳ��֪��
	}
 */

/*
 *  ע��@Retention��Դ��
 *  @Documented
	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.ANNOTATION_TYPE)
	public @interface Retention {
    	RetentionPolicy value();
	}
 
	public enum RetentionPolicy {
	    SOURCE, //Դ��״̬���У�
	    CLASS, //�������ļ�ʱ����
	    RUNTIME //����ʱ����
	}
 */
@Target(value = { ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UserAnnotation {
	public int id() default 0;
    public String name() default "";
    public int age() default 18;
    public String gender() default "M";
}
