package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Car {

	public static Car create(Supplier<Car> supplier) {
		return supplier.get();
	}
	
	public static void collide(Car car) {
		System.out.println("collite: " + car.toString());
	}
	
	public void follow(Car another) {
		System.out.println("follow: " + another.toString());
	}
	
	public void repair() {
		System.out.println("repair: " + this.toString());
	}
	
	/*
	 * ��������ʹ�ÿ����߿���ֱ�������ִ�ķ�����Java��Ĺ��췽������ʵ������
	 * �������ú�Lambda���ʽ���ʹ�ã�ʹ��java��Ĺ��췽�����������ն���࣬û�кܶิ�ӵ�ģ����롣
	 */
	public static void main(String[] args) {
		/*
		 * ��һ�ַ������õ������ǹ��������ã��﷨��Class::new��
		 * ���߸�һ�����ʽ��Class<T>::new��ע�⣺���������û�в�����
		 */
		Car car = Car.create(Car::new);
		List<Car> cars = Arrays.asList(car);
		
		/*
		 * �ڶ��ַ������õ������Ǿ�̬�������ã��﷨��Class::static_method��
		 * ע�⣺�����������һ��Car���͵Ĳ�����
		 */
		cars.forEach(Car::collide);
		
		/*
		 * �����ַ������õ�������ĳ����ĳ�Ա���������ã��﷨��Class::method��
		 * ע�⣬�������û�ж�����Σ�
		 */
		cars.forEach(Car::repair);
		
		/*
		 * �����ַ������õ�������ĳ��ʵ������ĳ�Ա���������ã��﷨��instance::method��
		 * ע�⣺�����������һ��Car���͵Ĳ�����
		 */
		cars.forEach(car::follow);
	}
}
