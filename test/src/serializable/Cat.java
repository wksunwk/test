package serializable;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;


/**
 * 1�����л��Ǹ�ʲô�ģ�
 *    ��˵����Ϊ�˱������ڴ��еĸ��ֶ����״̬��Ҳ����ʵ�����������Ƿ�������
 *    ���ҿ��԰ѱ���Ķ���״̬�ٶ�������
 *    ��Ȼ����������Լ��ĸ��ָ����ķ���������object states������Java�����ṩһ��Ӧ�ñ����Լ��õı������״̬�Ļ��ƣ��Ǿ������л���
 * 2��ʲô�������Ҫ���л�   
 *  a��������ѵ��ڴ��еĶ���״̬���浽һ���ļ��л������ݿ���ʱ��
 *  b�����������׽����������ϴ��Ͷ����ʱ��
 *  c��������ͨ��RMI��������ʱ��
 *  
 * ���ע������
 *  a�����л�ʱ��ֻ�Զ����״̬���б��棬�����ܶ���ķ�����
 *  b����һ������ʵ�����л��������Զ�ʵ�����л�������Ҫ��ʽʵ��Serializable�ӿڣ�
 *  c����һ�������ʵ���������������������л��ö���ʱҲ�����ö���������л���
 *  d���������еĶ��󶼿������л���,����Ϊʲô�����ԣ��кܶ�ԭ����,���磺
 *     1.��ȫ�����ԭ�򣬱���һ������ӵ��private��public��field������һ��Ҫ����Ķ���
 *       ����д���ļ������߽���rmi����  �ȵȣ������л����д���Ĺ����У���������private�����ǲ��ܱ����ġ�
 *     2.��Դ���䷽���ԭ�򣬱���socket��thread�࣬����������л������д�����߱��棬
 *       Ҳ�޷������ǽ������µ���Դ�� �䣬���ң�Ҳ��û�б�Ҫ����ʵ�֡�
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
