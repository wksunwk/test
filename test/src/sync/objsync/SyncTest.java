package sync.objsync;

/**
 * ͬ���������Ƕ��󣬶����Ǵ��롣
 * ��ˣ�������������һ��ͬ������������������Ա�������ͬ���߳�ͬʱִ�У�
 * ֻҪÿ���߳��Լ�����һ�������ʵ�����ɡ�
 * 
 * @author Administrator
 *
 */
public class SyncTest {
	/**
	 * ����SyncTest�����������1��3����ġ�
	 * ���printVal�Ƕ���(�������Ե�����,���Ƕ���Ļ�)��
	 * ���������ֻ����1����ֻ����3������������ͬʱ����(��Ϊ�÷�����ͬ����,����������һ������ѭ����û����ֹ)��
	 * �������еĽ��֤�������̶߳��ڲ�����ִ��printVal������
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
	 * �˴�ʾ��������.
	 */
	public synchronized void printVal(int v) {
		while (true)
			System.out.println(v);
	}

	public void run() {
		printVal(val);
	}
}
