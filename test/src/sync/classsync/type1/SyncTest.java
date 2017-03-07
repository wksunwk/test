package sync.classsync.type1;

/**
 * ���ͬ��
 * Ҫʵ�������Ķ���(���ͬ��)������ͬ��һ��ȫ�ֶ�����߶������ͬ����
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
	 * �˴�ʾ������
	 * ���ٶԸ������ʵ��ͬ�����Ƕ������ͬ����
	 * ������Foo���ԣ���ֻ��Ψһ���ඨ�壬�����߳�����ͬ������ͬ����
	 * ���ֻ��һ���߳̿���ִ��printVal������
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