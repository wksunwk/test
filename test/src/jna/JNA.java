package jna;


import com.sun.jna.Library;
import com.sun.jna.Native;

public class JNA {

	// 定义接口CLibrary，继承自com.sun.jna.Library
	public interface JNATestDll extends Library {
		// msvcrt为dll名称,msvcrt目录的位置为:C:\Windows\System32下面,
//		testdll Instance = (testdll) Native.loadLibrary((Platform.isWindows() ? "msvcrt" : "c"),
//				testdll.class);
//		JNATestDll Instance = (JNATestDll) Native.loadLibrary("dll/TestDll", JNATestDll.class);
		JNATestDll Instance = (JNATestDll) Native.loadLibrary("dll/LC_PHLIBS", JNATestDll.class);
//		JNATestDll Instance = (JNATestDll) Native.loadLibrary("dll/TestDll32", JNATestDll.class);
//		JNATestDll Instance = (JNATestDll) Native.loadLibrary("dll/TPH_DLL", JNATestDll.class);
		// printf为msvcrt.dll中的一个方法.
//		void printf(String format, Object... args);
		public void hello();
		public int SumNumbers(int a, int b);
		public void LC_Init();
		public long LC_TPH_OpenDev();
		
//		public int test();
	}

	public static void main(String[] args) {
		// 调用printf打印信息
//		testdll.Instance.printf("yyyyMMdd");
//		JNATestDll.Instance.hello();
//		System.out.println(JNATestDll.Instance.SumNumbers(83, 8));
//		JNATestDll.Instance.test();
		JNATestDll.Instance.LC_Init();
//		JNATestDll.Instance.LC_TPH_OpenDev();
	}

}
