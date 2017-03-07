package javaassert;

/**
 * 
 * -ea java -ea 打开所有用户类的assertion
 * -da java -da 关闭所有用户类的assertion
 * -ea:<classname> java -ea:MyClass1 打开MyClass1的assertion
 * -da:<classname> java -da: MyClass1 关闭MyClass1的assertion
 * -ea:<packagename> java -ea:pkg1 打开pkg1包的assertion
 * -da:<packagename> java -da:pkg1 关闭pkg1包的assertion
 * -ea:... java -ea:... 打开缺省包(无名包)的assertion
 * -da:... java -da:... 关闭缺省包(无名包)的assertion
 * -ea:<packagename>... java -ea:pkg1... 打开pkg1包和其子包的assertion
 * -da:<packagename>... java -da:pkg1... 关闭pkg1包和其子包的assertion
 * -esa java -esa 打开系统类的assertion
 * -dsa java -dsa 关闭系统类的assertion
 * 综合使用 java -dsa:MyClass1:pkg1 关闭MyClass1和pkg1包的assertion
 * 
 * @author Administrator
 *
 */
public class AssertTest {

	/**
	 * 1、assert关键字需要在运行时候显式开启才能生效，否则你的断言就没有任何意义。
	 *    而现在主流的Java IDE工具默认都没有开启-ea断言检查功能。
	 * 2、assert的判断和if语句差不多，但两者的作用有着本质的区别：
	 *    assert关键字本意上是为测试调试程序时使用的，但如果不小心用assert来控制了程序的业务流程，那在测试调试结束后去掉assert关键字就意味着修改了程序的正常的逻辑。
	 * 3、assert断言失败将面临程序的退出。这在一个生产环境下的应用是绝不能容忍的。
	 *    一般都是通过异常处理来解决程序中潜在的错误。但是使用断言就很危险，一旦失败系统就挂了。
	 *    
	 * 因此，应当避免在Java中使用assert关键字。
	 * @param args
	 */
	public static void main(String[] args) {
		boolean isOpen = false;
		assert isOpen = true; // 如果开启了断言，会将isOpen的值改为true
		System.out.println(isOpen);// 打印是否开启了断言

		boolean isOk = 1 < 2;
		assert isOk;
		System.out.println("程序正常");

		boolean isOk2 = 1 > 2;
		try {
			assert isOk2 : "程序错误";
			System.out.println("程序正常");
		} catch (AssertionError err) {
			System.out.println(err.getMessage());
		}
	}
}
