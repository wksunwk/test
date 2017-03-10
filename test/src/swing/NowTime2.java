package swing;

import java.awt.Toolkit;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JLabel;

import asynhandler.AsyncHandler2;

public class NowTime2 extends JFrame {

	private static final long serialVersionUID = -4566126708687309087L;
	
	private static ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

	// 添加 显示时间的JLabel
	public NowTime2() {
		JLabel time = new JLabel();
		add(time);
		this.setTimer(time);
	}

	// 设置Timer 1000ms实现一次动作 实际是一个线程
	private void setTimer(JLabel time) {

		AsyncHandler2 handler = new AsyncHandler2(){
			@Override
			public void handleMsg(Object msg) {
				// TODO Auto-generated method stub
				super.handleMsg(msg);
				
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
				}
				time.setText((String) msg);
			}
		};
		
		Runnable runnable = new Runnable() {
			int i = 0;

			public void run() {
				// task to run goes here
				handler.sendMsg(System.currentTimeMillis() + ", " + i + ", Hello !!");
				
				i++;
				if (i == 5) {
					service.shutdown();
					service = Executors.newSingleThreadScheduledExecutor();
					service.scheduleAtFixedRate(this, 1, 2, TimeUnit.SECONDS);
					// throw new RuntimeException();

				}
				if (i > 10) {
					service.shutdown();
				}
			}
		};
		// 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间
		service.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.SECONDS);
	}

	// 运行方法
	public static void main(String[] args) {
		NowTime2 timeFrame = new NowTime2();
		timeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		timeFrame.setSize(360, 180);
		timeFrame.setLocation((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() - timeFrame.getWidth()) / 2,
				(int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() - timeFrame.getHeight()) / 2);// 居中显示窗体
		timeFrame.setVisible(true);

	}
}
