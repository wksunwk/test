package pipe;

import java.io.PipedOutputStream;

public class Sender extends Thread {

	private PipedOutputStream out = new PipedOutputStream();// 发送者创建PipedOutputStream向外写数据;

	public PipedOutputStream getOut() {
		return out;
	}

	public void run() {

		String strInfo = "hello,receiver";

		try {

			out.write(strInfo.getBytes());// 写入数据

			out.close();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
