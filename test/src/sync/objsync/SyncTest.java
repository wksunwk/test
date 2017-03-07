package sync.objsync;

/**
 * 同步加锁的是对象，而不是代码。
 * 因此，如果你的类中有一个同步方法，这个方法可以被两个不同的线程同时执行，
 * 只要每个线程自己创建一个的类的实例即可。
 * 
 * @author Administrator
 *
 */
public class SyncTest {
	/**
	 * 运行SyncTest产生的输出是1和3交叉的。
	 * 如果printVal是断面(如果锁针对的是类,而非对象的话)，
	 * 看到的输出只能是1或者只能是3而不能是两者同时出现(因为该方法是同步的,并且由于是一个无限循环而没有终止)。
	 * 程序运行的结果证明两个线程都在并发的执行printVal方法。
	 * @param args
	 */
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
	 * 此处示例对象锁.
	 */
	public synchronized void printVal(int v) {
		while (true)
			System.out.println(v);
	}

	public void run() {
		printVal(val);
	}
}
