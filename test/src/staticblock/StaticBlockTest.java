package staticblock;

public class StaticBlockTest {
	
	public static void main(String args[]) {
		/**
		 * static{}(即static块)，会在类被加载的时候执行且仅会被执行一次
		 */
		/*
		 * 因为在虚拟机的生命周期中一个类只被加载一次；又因为static{}是伴随类加载执行的，
		 * 所以，不管你new多少次对象实例，static{}都只执行一次。
		 */
		/*
		 * 
		 * 上面说到static{}会在类被加载的时候执行，我们必须准确理解类加载的准确含义，含义如下:
		 */
		// 用Class.forName()显示加载的时候
//		try {
//			Class.forName("staticblock.Test");
//			Class.forName("staticblock.Test");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
		
		// 实例化一个类的时候
//		Test t=new Test();
		
		// 调用类的静态方法的时候
//		Test.display();
		
		// 调用类的静态变量的时候
//		System.out.println(Test.X);
		
		/*
		 * 调用类的静态常量的时候，是不会加载类的，即不会执行static{}语句块
		 * 这是java虚拟机的规定，当访问类的静态常量时，如果编译器可以计算出常量的值，则不会加载类，否则会加载类
		 */
		System.out.println(Test.Y);
	}
}

class Test {
	
	public static int X = 100;
	public final static int Y = 200;

	public Test() {
		System.out.println("Test构造函数执行");
	}

	static {
		System.out.println("static语句块执行");
	}

	public static void display() {
		System.out.println("静态方法被执行");
	}

	public void display_1() {
		System.out.println("实例方法被执行");
	}
}