package foreach;

public class TestArray2 {

	public static void main(String[] args) {
		int[] arr = new int[4];
		
		System.out.println("----δ��ֵǰ����ոն��������----"); 
		for (int x : arr) {
			System.out.println(x);
		}
		System.out.println("----ͨ��ѭ������������Ԫ�ظ�ֵ----"); 
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		System.out.println("----��ֵ��foreach��������õ�����----"); 
		for (int i : arr) {
			System.out.println(i);
		}
	}
}
