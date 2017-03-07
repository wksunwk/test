package foreach;

public class TestArray2 {

	public static void main(String[] args) {
		int[] arr = new int[4];
		
		System.out.println("----未赋值前输出刚刚定义的数组----"); 
		for (int x : arr) {
			System.out.println(x);
		}
		System.out.println("----通过循环变量给数组元素赋值----"); 
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		System.out.println("----赋值后，foreach输出创建好的数组----"); 
		for (int i : arr) {
			System.out.println(i);
		}
	}
}
