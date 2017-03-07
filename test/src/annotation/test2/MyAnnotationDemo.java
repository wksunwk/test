package annotation.test2;

@MyAnnotationClass(msg = "这是一个类注解.")
public class MyAnnotationDemo {

	public MyAnnotationDemo() {
	}
	
	public MyAnnotationDemo(String hello) {
		this.hello = hello;
	}
	
	@MyAnnotationField(request = true)
	private String hello = null;
	
	@MyAnnotationMethod(common = "这是一个方法注解.")
	private void print() {
		System.out.println(this.hello);
	}
}
