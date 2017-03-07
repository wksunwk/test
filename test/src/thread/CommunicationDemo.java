package thread;

public class CommunicationDemo {
	
	public static void main(String[] args) {

		ShareData s = new ShareData();

		new Consumer(s).start();

		new Producer(s).start();

	}
}

/**
 * 线程有四种状态，任何一个线程肯定处于这四种状态中的一种：
 * 1) 产生（New）：线程对象已经产生，但尚未被启动，所以无法执行。如通过new产生了一个线程对象后没对它调用start()函数之前。
 * 2) 可执行（Runnable）：每个支持多线程的系统都有一个排程器，排程器会从线程池中选择一个线程并启动它。当一个线程处于可执行状态时，表示它可能正处于线程池中等待排排程器启动它；也可能它已正在执行。如执行了一个线程对象的start()方法后，线程就处于可执行状态，但显而易见的是此时线程不一定正在执行中。
 * 3) 死亡（Dead）：当一个线程正常结束，它便处于死亡状态。如一个线程的run()函数执行完毕后线程就进入死亡状态。
 * 4) 停滞（Blocked）：当一个线程处于停滞状态时，系统排程器就会忽略它，不对它进行排程。
 */

/**
 * 调用wait()方法可以使调用该方法的线程释放共享资源的锁，然后从运行态退出，进入等待队列，直到被再次唤醒。
 * 而调用notify()方法可以唤醒等待队列中第一个等待同一共享资源的线程，并使该线程退出等待队列，进入可运行态。
 * 调用notifyAll()方法可以使所有正在等待队列中等待同一共享资源的线程从等待状态退出，进入可运行状态，此时，优先级最高的那个线程最先执行。
 * 
 * 被唤醒的线程是不能被执行的，需要等到当前线程放弃这个对象的锁。
 * @author Administrator
 *
 */
class ShareData {

	private char c;

	private boolean isProduced = false; // 信号量

	public synchronized void putShareChar(char c) { // 同步方法putShareChar()

		if (isProduced) { // 如果产品还未消费，则生产者等待

			try {
				wait(); // 生产者等待

			} catch (InterruptedException e) {

				e.printStackTrace();

			}

		}

		this.c = c;

		isProduced = true; // 标记已经生产

		notify(); // 通知消费者已经生产，可以消费

	}

	public synchronized char getShareChar() { // 同步方法getShareChar()

		if (!isProduced) { // 如果产品还未生产，则消费者等待

			try {

				wait(); // 消费者等待

			} catch (InterruptedException e) {

				e.printStackTrace();

			}

		}

		isProduced = false; // 标记已经消费

		notify(); // 通知需要生产

		return this.c;

	}

}

class Producer extends Thread { // 生产者线程

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

			s.putShareChar(ch); // 将产品放入仓库

			System.out.println(ch + " is produced by Producer.");

		}

	}

}

class Consumer extends Thread { // 消费者线程

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

			ch = s.getShareChar(); // 从仓库中取出产品

			System.out.println(ch + " is consumed by Consumer. ");

		} while (ch != 'D');

	}
}
