package lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test3 {

	static List<Person> ps = null;
	
	public static void main(String[] args) {
		ps = Arrays.asList(new Person("fsd"), new Person("ere"),
				new Person("fdf"), new Person("jhrt"), new Person("bvc"));
		Collections.sort(ps, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				// TODO Auto-generated method stub
				return o1.getName().compareToIgnoreCase(o2.getName());
			}
		});
		System.out.println(ps);
		
		ps = Arrays.asList(new Person("fsd"), new Person("ere"), new Person(
				"fdf"), new Person("jhrt"), new Person("bvc"));
		Collections.sort(ps,
				(o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
		System.out.println(ps);
		
//		ps = Arrays.asList(new Person("fsd"), new Person("ere"), new Person(
//				"fdf"), new Person("jhrt"), new Person("bvc"));
//		Collections.sort(ps, Comparator.comparing(p -> p.getName()));
//		System.out.println(ps);
		
		ps = Arrays.asList(new Person("fsd"), new Person("ere"), new Person(
				"fdf"), new Person("jhrt"), new Person("bvc"));
		Collections.sort(ps, Comparator.comparing(Person::getName));
		System.out.println(ps);
		
		ps = Arrays.asList(new Person("fsd"), new Person("ere"), new Person(
				"fdf"), new Person("jhrt"), new Person("bvc"));
		ps.sort(Comparator.comparing(Person::getName));
		System.out.println(ps);
		
		ps = Arrays.asList(new Person("fsd"), new Person("ere"), new Person(
				"fdf"), new Person("jhrt"), new Person("bvc"));
		ps.sort(Comparator.comparing(Person::getName).reversed());
		System.out.println(ps);
	}
	
	
	static class Person {
		String name = null;
		int age = 0;
		public Person(String name) {
			this.name = name;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return this.name;
		}
	}
}
