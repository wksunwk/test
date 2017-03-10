package asynhandler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class AsyncHandler {

	/**
	 * ������Դ�ͷ�.
	 */
	private CountDownLatch latch;

	/**
	 * ������ɱ�ʶ.
	 */
	private volatile boolean handleFinish;

	/**
	 * ��Ϣд�뱾���ļ����.
	 */
	private volatile boolean sendFinish;

	/**
	 * ��������.
	 */
	private BlockingQueue<String> queue;

	private BufferedWriter bw;

	public AsyncHandler(CountDownLatch latch) {
		this.latch = latch;
		/**
		 * ʹ������ʵ��.
		 */
		queue = new LinkedBlockingQueue<String>();
		File file = new File("E:/hello.txt");
		try {
			bw = new BufferedWriter(new FileWriter(file));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void handle() {
		// ģ������ƿ����ִ�й���,3s����һ����Ϣ.
		new Thread() {
			public void run() {
				while (!handleFinish) {
					try {
						TimeUnit.SECONDS.sleep(3);
					} catch (InterruptedException e1) {
						// ��������.
					}
					String s = queue.peek();
					if (s != null) {
						queue.poll();
						try {
							bw.write(s);
							bw.newLine();
						} catch (IOException e) {
						}
					}
					// ������Ϊ�ղ�����Ϣ�������.
					if (queue.isEmpty() && sendFinish) {
						// ������1->0
						latch.countDown();
						// �ô�����̽���.
						handleFinish = true;
						break;
					}
				}
			}

		}.start();

	}

	/**
	 * 
	 * <pre>
	 * ������Ϣ������ɵı�ʶ.
	 * </pre>
	 *
	 */
	public void sendFinish() {
		sendFinish = true;
	}

	/**
	 * 
	 * <pre>
	 * ��Դ�ͷ�.
	 * </pre>
	 *
	 */
	public void release() {
		System.out.println("release!");
		if (bw != null) {
			try {
				bw.close();
			} catch (IOException e) {
				// TODO ��ӡ��־.
			}
		}
		// ��ʵʹ��queue = null�͹���.
		if (queue != null) {
			queue.clear();
			queue = null;
		}
	}

	/**
	 * 
	 * <pre>
	 * �����з�����Ϣ.
	 * </pre>
	 *
	 * @param text
	 */
	public void sendMsg(String text) {
		if (text != null && !text.isEmpty()) {
			queue.add(text);
		}
	}

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(1);
		AsyncHandler handler = new AsyncHandler(latch);
		handler.handle();

		// ��һ�μ��.
		Scanner scanner = new Scanner(System.in);
		while (true) {
			String text = scanner.next();
			// ���û�ѡ���˳�.
			if ("exit".equals(text)) {
				// ��ʾ��Ϣ�Ѿ��������.
				handler.sendFinish();
				break;
			}
			handler.sendMsg(text);
		}

		try {
			// �������̵߳ȴ���Ϣд�뵽�����ļ����.
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// �ͷ���Դ �ļ���,����.
		handler.release();
		// �رտ���̨����.
		scanner.close();
	}
}
