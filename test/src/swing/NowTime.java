package swing;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class NowTime extends JFrame {

	private static final long serialVersionUID = -4566126708687309087L;
	
	private static ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
//	private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	// ��� ��ʾʱ���JLabel
	public NowTime() {
		JLabel time = new JLabel();
		add(time);
		this.setTimer(time);
	}

	// ����Timer 1000msʵ��һ�ζ��� ʵ����һ���߳�
	private void setTimer(JLabel time) {
//		final JLabel varTime = time;
//		Timer timeAction = new Timer(1000, new ActionListener() {
//
//			public void actionPerformed(ActionEvent e) {
//				long timemillis = System.currentTimeMillis();
//				// ת��������ʾ��ʽ
//				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//				varTime.setText(df.format(new Date(timemillis)));
//			}
//		});
//		timeAction.start();
		
//      ScheduledExecutorService service = Executors  
//      .newSingleThreadScheduledExecutor(); 

		Runnable runnable = new Runnable() {
			int i = 0;

			public void run() {
				// task to run goes here
//				System.out.println(System.currentTimeMillis() + ", " + i + ", Hello !!");
				time.setText(System.currentTimeMillis() + ", " + i + ", Hello !!");
//				try {
//					Thread.sleep(1500);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
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
		// �ڶ�������Ϊ�״�ִ�е���ʱʱ�䣬����������Ϊ��ʱִ�еļ��ʱ��
		service.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.SECONDS);
	}

	// ���з���
	public static void main(String[] args) {
		NowTime timeFrame = new NowTime();
		timeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		timeFrame.setSize(360, 180);
		timeFrame.setLocation((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() - timeFrame.getWidth()) / 2,
				(int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() - timeFrame.getHeight()) / 2);// ������ʾ����
		timeFrame.setVisible(true);

	}
}
