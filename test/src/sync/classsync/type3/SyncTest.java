package sync.classsync.type3;

/**
 * ���ͬ��
 * Ҫʵ�������Ķ���(���ͬ��)������ͬ��һ��ȫ�ֶ�����߶������ͬ����
 * @author Administrator
 *
 */
public class SyncTest {

	public static void main(String args[]) {
		/**
		 * JVM��һ���Ż����ƣ�String���͵Ķ����ǲ��ɱ�ģ���˵���ʹ��""����ʽ�����ַ���ʱ��
		 * ���JVM�����ڴ��Ѿ���һ�������Ķ�����ô����ʹ���Ǹ��������������һ���µ�String����
		 * ������Ϊ�˼�С�ڴ��ʹ�á�
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
 * �ܽ᣺
 * 1��synchronized�ؼ��ֵ��������ж��֣�
 * 	1����ĳ������ʵ���ڣ�synchronized aMethod(){}
 * 	     ���Է�ֹ����߳�ͬʱ������������synchronized����
 *     �����һ�������ж��synchronized������ֻҪһ���̷߳��������е�һ��synchronized�����������̲߳���ͬʱ��������������κ�һ��synchronized��������
 *     ��ʱ����ͬ�Ķ���ʵ����synchronized�����ǲ�����ŵġ�
 *     Ҳ����˵�������߳���������ͬʱ������ͬ�����һ������ʵ���е�synchronized������
 *  2����ĳ����ķ�Χ��synchronized static aStaticMethod{}
 *     ��ֹ����߳�ͬʱ����������е�synchronized static ������
 *     �����Զ�������ж���ʵ�������á�
 * 2�����˷���ǰ��synchronized�ؼ��֣�synchronized�ؼ��ֻ��������ڷ����е�ĳ�������У�
 *    ��ʾֻ������������Դʵ�л�����ʡ�
 *    �÷���: synchronized(this){����}�������������ǵ�ǰ����
 * 3��synchronized�ؼ����ǲ��ܼ̳еģ�
 *    Ҳ����˵������ķ���synchronized f(){} �ڼ̳����в����Զ���synchronized f(){}�����Ǳ����f(){}��
 *    �̳�����Ҫ����ʽ��ָ������ĳ������Ϊsynchronized������
 *    
 * �ܵ�˵����synchronized�ؼ��ֿ�����Ϊ���������η���Ҳ����Ϊ�����ڵ���䣬Ҳ����ƽʱ˵��ͬ��������ͬ�����顣
 * �����ϸ�ķ��࣬synchronized��������instance����(byte[] lock = new byte[0])��object reference����������,����this����static������class literals(���������泣��,����Foo.class)���ϡ�
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
	 * �˴�ʾ������
	 * ���ٶԸ������ʵ��ͬ�����Ƕ������ͬ����
	 * ���������type2ԭ��һ�¡�
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
