package pipe;

import java.io.PipedOutputStream;

public class Sender extends Thread {

	private PipedOutputStream out = new PipedOutputStream();// �����ߴ���PipedOutputStream����д����;

	public PipedOutputStream getOut() {
		return out;
	}

	public void run() {

		String strInfo = "hello,receiver";

		try {

			out.write(strInfo.getBytes());// д������

			out.close();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
