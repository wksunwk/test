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
	 * ScheduledExecutorService是从Java SE5的java.util.concurrent里，做为并发工具类被引进的，这是最理想的定时任务实现方式。  
	 * 相比于上两个方法，它有以下好处： 
	 * 1>相比于Timer的单线程，它是通过线程池的方式来执行任务的  
	 * 2>可以很灵活的去设定第一次执行任务delay时间 
	 * 3>提供了良好的约定，以便设定执行的时间间隔 
	 *  
	 * 下面是实现代码，我们通过ScheduledExecutorService#scheduleAtFixedRate展示这个例子，通过代码里参数的控制，首次执行加了delay时间。 
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
        // 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间  
        service.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.SECONDS);
	}
}
