package lambda;

import java.util.Arrays;
import java.util.List;

public class Test {

	public static void main(String[] args) {
//		Arrays.asList( "a", "b", "d" ).forEach( e -> System.out.println( e ) );
//		Arrays.asList( "a", "b", "d" ).forEach( ( String e ) -> System.out.println( e ) );
//		String s = "_";
//		Arrays.asList("a", "b", "c", "d", "f", "w", "e").forEach(a -> {
////			System.out.println(a);
//			System.out.println(a + s + a);
//		});
		
		List<String> list = Arrays.asList("a", "b", "c", "d", "f", "w", "e");
		list.sort((s1, s2) -> s1.compareTo(s2));
//		list.sort((s1, s2) -> {
//			return s1.compareTo(s2);
//		});
		list.forEach(e -> System.out.println(e));
	}
}
