package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class Test2 {

	Runnable r1 = () -> { System.out.println(this); };
	Runnable r2 = () -> { System.out.println(toString()); };
	
	Runnable r3 = new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println(this);
		}
	};
	
	Runnable r4 = new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println(toString());
		}
	};
	
	Callable<String> helloCallable(String name) {
		String s = "Hello, ";
//		s = "Hello xx, ";
		return () -> s + name;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "HHHH";
	}
	
	public static void main(String[] args) {
		Test2 t = new Test2();
		t.r1.run();
		t.r2.run();
		t.r3.run();
		t.r4.run();
		
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		int sum = 0;
//		list.forEach(e -> sum =+ sum + e.size());
		List<Integer> aList = new ArrayList<>();
		list.forEach(e -> aList.add(e.get(0)));
	}
}
