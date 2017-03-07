package serializable;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;


/**
 * 1、序列化是干什么的？
 *    简单说就是为了保存在内存中的各种对象的状态（也就是实例变量，不是方法），
 *    并且可以把保存的对象状态再读出来。
 *    虽然你可以用你自己的各种各样的方法来保存object states，但是Java给你提供一种应该比你自己好的保存对象状态的机制，那就是序列化。
 * 2、什么情况下需要序列化   
 *  a）当你想把的内存中的对象状态保存到一个文件中或者数据库中时候；
 *  b）当你想用套接字在网络上传送对象的时候；
 *  c）当你想通过RMI传输对象的时候；
 *  
 * 相关注意事项
 *  a）序列化时，只对对象的状态进行保存，而不管对象的方法；
 *  b）当一个父类实现序列化，子类自动实现序列化，不需要显式实现Serializable接口；
 *  c）当一个对象的实例变量引用其他对象，序列化该对象时也把引用对象进行序列化；
 *  d）并非所有的对象都可以序列化，,至于为什么不可以，有很多原因了,比如：
 *     1.安全方面的原因，比如一个对象拥有private，public等field，对于一个要传输的对象，
 *       比如写到文件，或者进行rmi传输  等等，在序列化进行传输的过程中，这个对象的private等域是不受保护的。
 *     2.资源分配方面的原因，比如socket，thread类，如果可以序列化，进行传输或者保存，
 *       也无法对他们进行重新的资源分 配，而且，也是没有必要这样实现。
 * @author Administrator
 *
 */
public class Cat implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4041162129233070882L;
	private String name;

	public Cat() {

		this.name = "new cat";

	}

	public String getName() {

		return this.name;

	}

	public void setName(String name) {

		this.name = name;

	}

	public static void main(String[] args) {
		Cat cat = new Cat();
//		try {
//
//			FileOutputStream fos = new FileOutputStream("catDemo.out");
//
//			ObjectOutputStream oos = new ObjectOutputStream(fos);
//
//			System.out.println(" 1> " + cat.getName());
//
//			cat.setName("My Cat");
//
//			oos.writeObject(cat);
//
//			oos.close();
//
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}

		try {

			FileInputStream fis = new FileInputStream("catDemo.out");

			ObjectInputStream ois = new ObjectInputStream(fis);

			cat = (Cat) ois.readObject();

			System.out.println(" 2> " + cat.getName());

			ois.close();

		} catch (Exception ex) {

			ex.printStackTrace();

		}

	}

}
