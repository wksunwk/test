package sync.classsync.type2;

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
	
	private static Object lock=new Object();

	public Foo(int v) {
		val = v;
	}
	/**
	 * �˴�ʾ������
	 * ���ٶԸ������ʵ��ͬ�����Ƕ������ͬ����
	 * ������ӱ�type1����������Ҫ��һЩ����Ϊtype1�еļ���������ඨ��ģ�һ����ֻ����һ���ඨ�壬
	 * ��ͬ����һ��ԭ����Ӧ�þ�����Сͬ���������Ե�����õ����ܡ�
	 * �˴��ķ�����ͬ�����ȱ�type1��ҪС��
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