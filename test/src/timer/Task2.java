package timer;

import java.util.Timer;
import java.util.TimerTask;

public class Task2 {

	/** 
	 *  
	 * �ڵ�һ�ַ�ʽ��ȣ����� 1>��������ȥȡ������ʱ���Կ��� 2>��һ��ִ������ʱ����ָ������Ҫ��delayʱ�� 
	 *  
	 * ��ʵ��ʱ��Timer����Ե�������TimerTask����ͨ����run()������ʵ�־������� Timerʵ�����Ե��ȶ����������̰߳�ȫ�ġ� 
	 * ��Timer�Ĺ�����������ʱ����������һ���̣߳�����߳̿��������������� �����Ǵ��룺 
	 *  
	 * @author GT 
	 *  
	 */  
	public static void main(String[] args) {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {  
			int i = 0;
            @Override  
            public void run() {  
                // task to run goes here  
            	
                System.out.println(System.currentTimeMillis() + ", Hello !!!");  
                i++;
                if (i > 10) {
                	timer.cancel();
                }
            }  
        };  
        long delay = 0;  
        long intevalPeriod = 1 * 1000;  
        // schedules the task to be run in an interval  
        timer.scheduleAtFixedRate(task, delay, intevalPeriod);
//        timer.
//        if () {
//        	
//        }
        System.out.println("--------");
	}
}
