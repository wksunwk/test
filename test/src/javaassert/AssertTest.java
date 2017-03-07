package javaassert;

/**
 * 
 * -ea java -ea �������û����assertion
 * -da java -da �ر������û����assertion
 * -ea:<classname> java -ea:MyClass1 ��MyClass1��assertion
 * -da:<classname> java -da: MyClass1 �ر�MyClass1��assertion
 * -ea:<packagename> java -ea:pkg1 ��pkg1����assertion
 * -da:<packagename> java -da:pkg1 �ر�pkg1����assertion
 * -ea:... java -ea:... ��ȱʡ��(������)��assertion
 * -da:... java -da:... �ر�ȱʡ��(������)��assertion
 * -ea:<packagename>... java -ea:pkg1... ��pkg1�������Ӱ���assertion
 * -da:<packagename>... java -da:pkg1... �ر�pkg1�������Ӱ���assertion
 * -esa java -esa ��ϵͳ���assertion
 * -dsa java -dsa �ر�ϵͳ���assertion
 * �ۺ�ʹ�� java -dsa:MyClass1:pkg1 �ر�MyClass1��pkg1����assertion
 * 
 * @author Administrator
 *
 */
public class AssertTest {

	/**
	 * 1��assert�ؼ�����Ҫ������ʱ����ʽ����������Ч��������Ķ��Ծ�û���κ����塣
	 *    ������������Java IDE����Ĭ�϶�û�п���-ea���Լ�鹦�ܡ�
	 * 2��assert���жϺ�if����࣬�����ߵ��������ű��ʵ�����
	 *    assert�ؼ��ֱ�������Ϊ���Ե��Գ���ʱʹ�õģ��������С����assert�������˳����ҵ�����̣����ڲ��Ե��Խ�����ȥ��assert�ؼ��־���ζ���޸��˳�����������߼���
	 * 3��assert����ʧ�ܽ����ٳ�����˳�������һ�����������µ�Ӧ���Ǿ��������̵ġ�
	 *    һ�㶼��ͨ���쳣���������������Ǳ�ڵĴ��󡣵���ʹ�ö��Ծͺ�Σ�գ�һ��ʧ��ϵͳ�͹��ˡ�
	 *    
	 * ��ˣ�Ӧ��������Java��ʹ��assert�ؼ��֡�
	 * @param args
	 */
	public static void main(String[] args) {
		boolean isOpen = false;
		assert isOpen = true; // ��������˶��ԣ��ὫisOpen��ֵ��Ϊtrue
		System.out.println(isOpen);// ��ӡ�Ƿ����˶���

		boolean isOk = 1 < 2;
		assert isOk;
		System.out.println("��������");

		boolean isOk2 = 1 > 2;
		try {
			assert isOk2 : "�������";
			System.out.println("��������");
		} catch (AssertionError err) {
			System.out.println(err.getMessage());
		}
	}
}
