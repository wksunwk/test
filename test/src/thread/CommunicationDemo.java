package thread;

public class CommunicationDemo {
	
	public static void main(String[] args) {

		ShareData s = new ShareData();

		new Consumer(s).start();

		new Producer(s).start();

	}
}

/**
 * �߳�������״̬���κ�һ���߳̿϶�����������״̬�е�һ�֣�
 * 1) ������New�����̶߳����Ѿ�����������δ�������������޷�ִ�С���ͨ��new������һ���̶߳����û��������start()����֮ǰ��
 * 2) ��ִ�У�Runnable����ÿ��֧�ֶ��̵߳�ϵͳ����һ���ų������ų�������̳߳���ѡ��һ���̲߳�����������һ���̴߳��ڿ�ִ��״̬ʱ����ʾ�������������̳߳��еȴ����ų�����������Ҳ������������ִ�С���ִ����һ���̶߳����start()�������߳̾ʹ��ڿ�ִ��״̬�����Զ��׼����Ǵ�ʱ�̲߳�һ������ִ���С�
 * 3) ������Dead������һ���߳��������������㴦������״̬����һ���̵߳�run()����ִ����Ϻ��߳̾ͽ�������״̬��
 * 4) ͣ�ͣ�Blocked������һ���̴߳���ͣ��״̬ʱ��ϵͳ�ų����ͻ�������������������ų̡�
 */

/**
 * ����wait()��������ʹ���ø÷������߳��ͷŹ�����Դ������Ȼ�������̬�˳�������ȴ����У�ֱ�����ٴλ��ѡ�
 * ������notify()�������Ի��ѵȴ������е�һ���ȴ�ͬһ������Դ���̣߳���ʹ���߳��˳��ȴ����У����������̬��
 * ����notifyAll()��������ʹ�������ڵȴ������еȴ�ͬһ������Դ���̴߳ӵȴ�״̬�˳������������״̬����ʱ�����ȼ���ߵ��Ǹ��߳�����ִ�С�
 * 
 * �����ѵ��߳��ǲ��ܱ�ִ�еģ���Ҫ�ȵ���ǰ�̷߳���������������
 * @author Administrator
 *
 */
class ShareData {

	private char c;

	private boolean isProduced = false; // �ź���

	public synchronized void putShareChar(char c) { // ͬ������putShareChar()

		if (isProduced) { // �����Ʒ��δ���ѣ��������ߵȴ�

			try {
				wait(); // �����ߵȴ�

			} catch (InterruptedException e) {

				e.printStackTrace();

			}

		}

		this.c = c;

		isProduced = true; // ����Ѿ�����

		notify(); // ֪ͨ�������Ѿ���������������

	}

	public synchronized char getShareChar() { // ͬ������getShareChar()

		if (!isProduced) { // �����Ʒ��δ�������������ߵȴ�

			try {

				wait(); // �����ߵȴ�

			} catch (InterruptedException e) {

				e.printStackTrace();

			}

		}

		isProduced = false; // ����Ѿ�����

		notify(); // ֪ͨ��Ҫ����

		return this.c;

	}

}

class Producer extends Thread { // �������߳�

	private ShareData s;

	Producer(ShareData s) {

		this.s = s;

	}

	public void run() {

		for (char ch = 'A'; ch <= 'D'; ch++) {

			try {

				Thread.sleep((int) (Math.random() * 3000));

			} catch (InterruptedException e) {

				e.printStackTrace();

			}

			s.putShareChar(ch); // ����Ʒ����ֿ�

			System.out.println(ch + " is produced by Producer.");

		}

	}

}

class Consumer extends Thread { // �������߳�

	private ShareData s;

	Consumer(ShareData s) {

		this.s = s;

	}

	public void run() {

		char ch;

		do {

			try {

				Thread.sleep((int) (Math.random() * 3000));

			} catch (InterruptedException e) {

				e.printStackTrace();

			}

			ch = s.getShareChar(); // �Ӳֿ���ȡ����Ʒ

			System.out.println(ch + " is consumed by Consumer. ");

		} while (ch != 'D');

	}
}
