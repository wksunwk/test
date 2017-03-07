package annotation.test2;

@MyAnnotationClass(msg = "����һ����ע��.")
public class MyAnnotationDemo {

	public MyAnnotationDemo() {
	}
	
	public MyAnnotationDemo(String hello) {
		this.hello = hello;
	}
	
	@MyAnnotationField(request = true)
	private String hello = null;
	
	@MyAnnotationMethod(common = "����һ������ע��.")
	private void print() {
		System.out.println(this.hello);
	}
}
