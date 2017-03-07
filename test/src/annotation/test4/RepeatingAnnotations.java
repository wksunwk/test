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
	 * 这里的Filter类使用@Repeatable(Filters.class)注解修饰，
	 * 而Filters是存放Filter注解的容器，编译器尽量对开发者屏蔽这些细节。
	 * 这样，Filterable接口可以用两个Filter注解注释（这里并没有提到任何关于Filters的信息）。
	 */
	@Filter( "filter1" )
	@Filter( "filter2" )
	@Filter( "filter3" )
	public interface Filterable {

	}

	/*
	 * 自从Java 5中引入注解以来，这个特性开始变得非常流行，并在各个框架和项目中被广泛使用。
	 * 不过，注解有一个很大的限制是：在同一个地方不能多次使用同一个注解。
	 * Java 8打破了这个限制，引入了重复注解的概念，允许在同一个地方多次使用同一个注解。
	 * 在Java 8中使用@Repeatable注解定义重复注解，实际上，这并不是语言层面的改进，
	 * 而是编译器做的一个trick，底层的技术仍然相同。
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
