package annotation.test3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * 注解@Target的源码
 *  @Documented
    @Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.ANNOTATION_TYPE) //这不是在作弊，这确实是自己注解自己，所以说注解也可以被自己给注解
	public @interface Target {
    	ElementType[] value(); //值可以使数组 value={...}
	}
 
		public enum ElementType {
	    TYPE,  //给类（型）注解
	    FIELD, //给字段注解，不要忘了，字段可以是对象
	    METHOD, //给方法注解
	    PARAMETER, //给参数注解
	    CONSTRUCTOR, //给构造方法注解
	    LOCAL_VARIABLE, //给局部变量注解
	    ANNOTATION_TYPE,//给注解注解（这貌似把自己不当类来看）
	    PACKAGE, //给包注解
	    TYPE_PARAMETER, //不知道，等知道了我再写在这里
	    TYPE_USE //这个也不知道
	}
 */

/*
 *  注解@Retention的源码
 *  @Documented
	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.ANNOTATION_TYPE)
	public @interface Retention {
    	RetentionPolicy value();
	}
 
	public enum RetentionPolicy {
	    SOURCE, //源码状态运行，
	    CLASS, //编译类文件时运行
	    RUNTIME //运行时运行
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
