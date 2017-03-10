package timer;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Task3 {

	private static ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
//	private static ScheduledExecutorService service = Executors.newScheduledThreadPool(2);


	/** 
	 *  
	 *  
	 * ScheduledExecutorService�Ǵ�Java SE5��java.util.concurrent���Ϊ���������౻�����ģ�����������Ķ�ʱ����ʵ�ַ�ʽ��  
	 * ������������������������ºô��� 
	 * 1>�����Timer�ĵ��̣߳�����ͨ���̳߳صķ�ʽ��ִ�������  
	 * 2>���Ժ�����ȥ�趨��һ��ִ������delayʱ�� 
	 * 3>�ṩ�����õ�Լ�����Ա��趨ִ�е�ʱ���� 
	 *  
	 * ������ʵ�ִ��룬����ͨ��ScheduledExecutorService#scheduleAtFixedRateչʾ������ӣ�ͨ������������Ŀ��ƣ��״�ִ�м���delayʱ�䡣 
	 *  
	 *  
	 * @author GT 
	 *  
	 */ 
	public static void main(String[] args) {
//        ScheduledExecutorService service = Executors  
//                .newSingleThreadScheduledExecutor(); 
        
		Runnable runnable = new Runnable() {  
			int i = 0;
            public void run() {  
                // task to run goes here  
                System.out.println(System.currentTimeMillis() + ", " + i + ", Hello !!"); 
                try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                i++;
                if (i == 5) {
                	service.shutdown();
					service = Executors.newSingleThreadScheduledExecutor();
                	service.scheduleAtFixedRate(this, 1, 2, TimeUnit.SECONDS);
//                	throw new RuntimeException();
                	
                }
                if (i > 10) {
                	service.shutdown();
                }
            }  
        };  
        // �ڶ�������Ϊ�״�ִ�е���ʱʱ�䣬����������Ϊ��ʱִ�еļ��ʱ��  
        service.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.SECONDS);
	}
}
