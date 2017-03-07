package sync.classsync.type2;

/**
 * 类的同步
 * 要实现真正的断面(类的同步)，必须同步一个全局对象或者对类进行同步。
 * @author Administrator
 *
 */
public class SyncTest {
	
	public static void main(String args[]) {
		Foo f1 = new Foo(1);
		f1.start();
		Foo f2 = new Foo(3);
		f2.start();
	}
}

class Foo extends Thread {
	
	private int val;
	
	private static Object lock=new Object();

	public Foo(int v) {
		val = v;
	}
	/**
	 * 此处示例类锁
	 * 不再对个别的类实例同步而是对类进行同步。
	 * 这个例子比type1给出的例子要好一些，因为type1中的加锁是针对类定义的，一个类只能有一个类定义，
	 * 而同步的一般原理是应该尽量减小同步的粒度以到达更好的性能。
	 * 此处的范例的同步粒度比type1的要小。
	 * @param args
	 */
	public void printVal(int v) {
		synchronized (lock) {
			while (true)
				System.out.println(v);
		}
	}

	public void run() {
		printVal(val);
	}
}