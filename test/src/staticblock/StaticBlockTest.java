package staticblock;

public class StaticBlockTest {
	
	public static void main(String args[]) {
		/**
		 * static{}(��static��)�������౻���ص�ʱ��ִ���ҽ��ᱻִ��һ��
		 */
		/*
		 * ��Ϊ�������������������һ����ֻ������һ�Σ�����Ϊstatic{}�ǰ��������ִ�еģ�
		 * ���ԣ�������new���ٴζ���ʵ����static{}��ִֻ��һ�Ρ�
		 */
		/*
		 * 
		 * ����˵��static{}�����౻���ص�ʱ��ִ�У����Ǳ���׼ȷ�������ص�׼ȷ���壬��������:
		 */
		// ��Class.forName()��ʾ���ص�ʱ��
//		try {
//			Class.forName("staticblock.Test");
//			Class.forName("staticblock.Test");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
		
		// ʵ����һ�����ʱ��
//		Test t=new Test();
		
		// ������ľ�̬������ʱ��
//		Test.display();
		
		// ������ľ�̬������ʱ��
//		System.out.println(Test.X);
		
		/*
		 * ������ľ�̬������ʱ���ǲ��������ģ�������ִ��static{}����
		 * ����java������Ĺ涨����������ľ�̬����ʱ��������������Լ����������ֵ���򲻻�����࣬����������
		 */
		System.out.println(Test.Y);
	}
}

class Test {
	
	public static int X = 100;
	public final static int Y = 200;

	public Test() {
		System.out.println("Test���캯��ִ��");
	}

	static {
		System.out.println("static����ִ��");
	}

	public static void display() {
		System.out.println("��̬������ִ��");
	}

	public void display_1() {
		System.out.println("ʵ��������ִ��");
	}
}