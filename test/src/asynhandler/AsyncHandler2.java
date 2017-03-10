package asynhandler;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class AsyncHandler2 {

	/**
	 * ��Ϣд�뱾���ļ����.
	 */
	private volatile boolean sendFinish;

	/**
	 * ��������.
	 */
	private BlockingQueue<Object> queue;


	public AsyncHandler2() {
		/**
		 * ʹ������ʵ��.
		 */
		queue = new LinkedBlockingQueue<Object>();
		this.handle();
	}

	private void handle() {
		// ģ������ƿ����ִ�й���,3s����һ����Ϣ.
		new Thread() {
			public void run() {
				while (true) {
//					try {
//						TimeUnit.SECONDS.sleep(3);
//					} catch (InterruptedException e1) {
//						// ��������.
//					}
					Object s = queue.peek();
					if (s != null) {
						queue.poll();
						handleMsg(s);
					}
					if (queue.isEmpty()) {
						try {
							TimeUnit.MILLISECONDS.sleep(10);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					// ������Ϊ�ղ�����Ϣ�������.
					if (sendFinish) {
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
	public void sendMsg(Object text) {
		if (text != null) {
			queue.add(text);
		}
	}
	
	public void handleMsg(Object msg) {
		
	}
}
