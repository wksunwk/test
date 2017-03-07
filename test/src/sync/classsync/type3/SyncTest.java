package sync.classsync.type3;

/**
 * 类的同步
 * 要实现真正的断面(类的同步)，必须同步一个全局对象或者对类进行同步。
 * @author Administrator
 *
 */
public class SyncTest {

	public static void main(String args[]) {
		/**
		 * JVM有一种优化机制，String类型的对象是不可变的，因此当你使用""的形式引用字符串时，
		 * 如果JVM发现内存已经有一个这样的对象，那么它就使用那个对象而不再生成一个新的String对象，
		 * 这样是为了减小内存的使用。
		 */
		// Foo f1 = new Foo("Foo 1:", "printVal");
		// f1.start();
		// Foo f2 = new Foo("Foo 2:", "printVal");
		// f2.start();

		String value = "printVal";
		Foo f1 = new Foo("Foo 1:", value);
		f1.start();
		Foo f2 = new Foo("Foo 2:", value);
		f2.start();
	}
}

/**
 * 总结：
 * 1、synchronized关键字的作用域有二种：
 * 	1）是某个对象实例内，synchronized aMethod(){}
 * 	     可以防止多个线程同时访问这个对象的synchronized方法
 *     （如果一个对象有多个synchronized方法，只要一个线程访问了其中的一个synchronized方法，其它线程不能同时访问这个对象中任何一个synchronized方法）。
 *     这时，不同的对象实例的synchronized方法是不相干扰的。
 *     也就是说，其它线程照样可以同时访问相同类的另一个对象实例中的synchronized方法；
 *  2）是某个类的范围，synchronized static aStaticMethod{}
 *     防止多个线程同时访问这个类中的synchronized static 方法。
 *     它可以对类的所有对象实例起作用。
 * 2、除了方法前用synchronized关键字，synchronized关键字还可以用于方法中的某个区块中，
 *    表示只对这个区块的资源实行互斥访问。
 *    用法是: synchronized(this){区块}，它的作用域是当前对象；
 * 3、synchronized关键字是不能继承的，
 *    也就是说，基类的方法synchronized f(){} 在继承类中并不自动是synchronized f(){}，而是变成了f(){}。
 *    继承类需要你显式的指定它的某个方法为synchronized方法。
 *    
 * 总的说来，synchronized关键字可以作为函数的修饰符，也可作为函数内的语句，也就是平时说的同步方法和同步语句块。
 * 如果再细的分类，synchronized可作用于instance变量(byte[] lock = new byte[0])、object reference（对象引用,比如this）、static函数和class literals(类名称字面常量,比如Foo.class)身上。
 * @author Administrator
 *
 */

class Foo extends Thread {
	private String name;
	private String val;

	public Foo(String name, String v) {
		this.name = name;
		val = v;
	}
	/**
	 * 此处示例类锁
	 * 不再对个别的类实例同步而是对类进行同步。
	 * 这个例子与type2原理一致。
	 * @param args
	 */
	public void printVal() {
		synchronized (val) {
			while (true)
				System.out.println(name + val);
		}
	}

	public void run() {
		printVal();
	}
}
