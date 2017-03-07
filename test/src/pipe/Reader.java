package pipe;

import java.io.PipedInputStream;

public class Reader extends Thread {

	private PipedInputStream in = new PipedInputStream();// 发送者创建PipedOutputStream向外写数据

	public PipedInputStream getIn() {

		return in;

	}

	public void run() {

		byte[] buf = new byte[1024];// 声明字节数组

		try {

			int len = in.read(buf);// 读取数据，并返回实际读到的字节数

			System.out
					.println("receive from sender:" + new String(buf, 0, len));

			in.close();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
