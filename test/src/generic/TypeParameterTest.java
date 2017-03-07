package generic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TypeParameterTest {

	public static <T extends Comparable<T>> void sort1(List<T> list) {
		Collections.sort(list);
	}

	public static <T extends Comparable<? super T>> void sort2(List<T> list) {
		Collections.sort(list);
	}
	
	class Animal implements Comparable<Animal> {

		protected int age = 0;
		
		public Animal(int age) {
			this.age = age;
		}
		
		@Override
		public int compareTo(Animal o) {
			// TODO Auto-generated method stub
			return this.age - o.age;
		}
	}
	
	// Dog无法implements Comparable<Dog>,
	// 因而只能@Override compareTo(Animal o),
	// 而不能@Override compareTo(Dog o)
	class Dog extends Animal implements Comparable<Animal> {

		public Dog(int age) {
			super(age);
			// TODO Auto-generated constructor stub
		}
		@Override
		public int compareTo(Animal o) {
			// TODO Auto-generated method stub
			return this.age - o.age;
		}
		
		public int compareTo(Dog o) {
			// TODO Auto-generated method stub
			return this.age - o.age;
		}
	}
	
	public static void main(String[] args) {
		TypeParameterTest t = new TypeParameterTest();
		List<Animal> as = Arrays.asList(t.new Animal(5), t.new Animal(3),
				t.new Animal(2), t.new Animal(7));

		List<Dog> ds = Arrays.asList(t.new Dog(9), t.new Dog(54), t.new Dog(7),
				t.new Dog(8), t.new Dog(356));
		
		List<Animal> ads = Arrays.asList(t.new Animal(5), t.new Animal(3),
				t.new Animal(2), t.new Animal(7), t.new Dog(54));
		
		sort1(as);;
//		sort1(ds);
		sort1(ads);
		
		sort2(as);
		sort2(ds);
		sort2(ads);
	}
}
