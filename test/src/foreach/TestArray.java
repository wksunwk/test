package foreach;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestArray {
	/**
	 * foreach������һά����
	 */
	public void test1() {
		// ���岢��ʼ��һ������
		int arr[] = { 2, 3, 1 };
		System.out.println("----1----����ǰ��һά����");
		for (int x : arr) {
			System.out.println(x); // ����������Ԫ�ص�ֵ
		}

		// ����������
		Arrays.sort(arr);

		// ����java������for eachѭ���������
		System.out.println("----1----������һά����");
		for (int x : arr) {
			System.out.println(x); // ����������Ԫ�ص�ֵ
		}
	}

	/**
	 * ����ת��Ϊһά����
	 */
	public void listToArray() {
		// ����List�����Ԫ��
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("3");
		list.add("4");

		// ����froeach����������Ԫ��
		System.out.println("----2----froeach����������Ԫ��");
		for (String x : list) {
			System.out.println(x);
		}

		// ��ArrayListת��Ϊ����
		Object s[] = list.toArray();

		// ����froeach����������Ԫ��
		System.out.println("----2----froeach����������ת������������Ԫ��");
		for (Object x : s) {
			System.out.println(x.toString()); // ����������Ԫ�ص�ֵ
		}
	}

	/**
	 * foreach�����ά�������
	 */
	public void testArray2() {
		int arr2[][] = { { 4, 3 }, { 1, 2 } };
		System.out.println("----3----foreach�����ά�������");
		for (int x[] : arr2) {
			for (int e : x) {
				System.out.println(e); // ����������Ԫ�ص�ֵ
			}
		}
	}

	/**
	 * foreach�����ά����
	 */
	public void testArray3() {
		int arr[][][] = { { { 1, 2 }, { 3, 4 } }, { { 5, 6 }, { 7, 8 } } };

		System.out.println("----4----foreach�����ά�������");
		for (int[][] a2 : arr) {
			for (int[] a1 : a2) {
				for (int x : a1) {
					System.out.println(x);
				}
			}
		}
	}

	public static void main(String[] args) {
		TestArray test = new TestArray();
		test.test1();
		test.listToArray();
		test.testArray2();
		test.testArray3();
	}
}
