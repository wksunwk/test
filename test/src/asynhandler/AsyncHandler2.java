package asynhandler;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class AsyncHandler2 {

	/**
	 * 消息写入本地文件完成.
	 */
	private volatile boolean sendFinish;

	/**
	 * 阻塞队列.
	 */
	private BlockingQueue<Object> queue;


	public AsyncHandler2() {
		/**
		 * 使用链表实现.
		 */
		queue = new LinkedBlockingQueue<Object>();
		this.handle();
	}

	private void handle() {
		// 模拟性能瓶颈的执行过程,3s处理一条消息.
		new Thread() {
			public void run() {
				while (true) {
//					try {
//						TimeUnit.SECONDS.sleep(3);
//					} catch (InterruptedException e1) {
//						// 不做处理.
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
					// 若队列为空并且消息发送完成.
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
	 * 给出消息发送完成的标识.
	 * </pre>
	 *
	 */
	public void sendFinish() {
		sendFinish = true;
	}

	/**
	 * 
	 * <pre>
	 * 资源释放.
	 * </pre>
	 *
	 */
	public void release() {
		System.out.println("release!");
		// 其实使用queue = null就够了.
		if (queue != null) {
			queue.clear();
			queue = null;
		}
	}

	/**
	 * 
	 * <pre>
	 * 往队列发送消息.
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
