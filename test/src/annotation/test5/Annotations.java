package annotation.test5;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collection;

public class Annotations {

	@Target( {ElementType.TYPE_USE, ElementType.TYPE_PARAMETER} )
	@Retention( RetentionPolicy.RUNTIME)
	public @interface NonEmpty {
		
	}
	
	public static class Holder<@NonEmpty T> extends @NonEmpty Object {
		public void method () throws @NonEmpty Exception {
			
		}
	}
	
	public static void main(String[] args) {
		Holder<String> holder = new @NonEmpty Holder<>();
		@NonEmpty Collection<@NonEmpty String> c = new ArrayList<String>();
	}
}
