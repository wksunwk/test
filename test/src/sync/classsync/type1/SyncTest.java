package sync.classsync.type1;

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

	public Foo(int v) {
		val = v;
	}
	/**
	 * 此处示例类锁
	 * 不再对个别的类实例同步而是对类进行同步。
	 * 对于类Foo而言，它只有唯一的类定义，两个线程在相同的锁上同步，
	 * 因此只有一个线程可以执行printVal方法。
	 * @param args
	 */
	public void printVal(int v) {
		synchronized (Foo.class) {
			while (true)
				System.out.println(v);
		}
	}

	public void run() {
		printVal(val);
	}
}