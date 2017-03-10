package timer;

public class Task1 {

	/** 
	 * ��ͨthread 
	 * ��������ģ�����һ��thread��Ȼ��������whileѭ����һֱ�����ţ� 
	 * ͨ��sleep�������ﵽ��ʱ�����Ч�����������Կ��ټ򵥵�ʵ�֣��������£� 
	 * @author GT 
	 * 
	 */ 
	public static void main(String[] args) {
		final long timeInterval = 1000;  
        Runnable runnable = new Runnable() {  
            public void run() {  
                for (int i = 0; i < 10; i++) {  
                    // ------- code for task to run  
                    System.out.println(System.currentTimeMillis() + ", Hello !!");  
                    // ------- ends here  
                    try {  
                        Thread.sleep(timeInterval);  
                    } catch (InterruptedException e) {  
                        e.printStackTrace();  
                    }  
                }  
            }  
        };  
        Thread thread = new Thread(runnable);  
        thread.start();
	}
}
