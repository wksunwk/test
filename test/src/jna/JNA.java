package jna;


import com.sun.jna.Library;
import com.sun.jna.Native;

public class JNA {

	// ����ӿ�CLibrary���̳���com.sun.jna.Library
	public interface JNATestDll extends Library {
		// msvcrtΪdll����,msvcrtĿ¼��λ��Ϊ:C:\Windows\System32����,
//		testdll Instance = (testdll) Native.loadLibrary((Platform.isWindows() ? "msvcrt" : "c"),
//				testdll.class);
//		JNATestDll Instance = (JNATestDll) Native.loadLibrary("dll/TestDll", JNATestDll.class);
		JNATestDll Instance = (JNATestDll) Native.loadLibrary("dll/LC_PHLIBS", JNATestDll.class);
//		JNATestDll Instance = (JNATestDll) Native.loadLibrary("dll/TestDll32", JNATestDll.class);
//		JNATestDll Instance = (JNATestDll) Native.loadLibrary("dll/TPH_DLL", JNATestDll.class);
		// printfΪmsvcrt.dll�е�һ������.
//		void printf(String format, Object... args);
		public void hello();
		public int SumNumbers(int a, int b);
		public void LC_Init();
		public long LC_TPH_OpenDev();
		
//		public int test();
	}

	public static void main(String[] args) {
		// ����printf��ӡ��Ϣ
//		testdll.Instance.printf("yyyyMMdd");
//		JNATestDll.Instance.hello();
//		System.out.println(JNATestDll.Instance.SumNumbers(83, 8));
//		JNATestDll.Instance.test();
		JNATestDll.Instance.LC_Init();
//		JNATestDll.Instance.LC_TPH_OpenDev();
	}

}
