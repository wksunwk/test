package generic;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		List<String> a = new ArrayList<String>();
		a.add("CSDN_SEU_Cavin");
		Class c = a.getClass();
		try {
			Method m = c.getMethod("add", Object.class);
			m.invoke(a, 100);
			System.out.println(a);
//			System.out.println(a.get(1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		FX1<String> s = new FX1<String>("ss");
		s.showType();
		FX1<Integer> i = new FX1<Integer>(100);
		i.showType();
		
		FX2 ss = new FX2("ss");
		ss.showType();
		FX2 ii = new FX2(100);
		ii.showType();
		
		getData(i);
//		getData(s);
		
		List<?>[] lsa = new List<?>[10];
		Object o = lsa;
		Object[] oa = (Object[])o;
		List<Integer> li = new ArrayList<Integer>();
		li.add(new Integer(3));
		oa[1] = li;
		List<String> ls = new ArrayList<String>();
		ls.add("123");
		oa[2] = ls;
		System.out.println(lsa[1].get(0));
		System.out.println(lsa[2].get(0));
		
		// 以下只能写入
		List<? super Integer> t1 = new ArrayList<Integer>();
		List<? super Integer> t2 = new ArrayList<Number>();
		List<? super Integer> t3 = new ArrayList<Object>();
		
		// 以下只能读出
		List<? extends Number>t4 = new ArrayList<Number>();
		List<? extends Number>t5 = new ArrayList<Integer>();
		List<? extends Number>t6 = new ArrayList<Double>();
		
		fromArrayToCollection(new Object[10], new ArrayList<Object>());
		fromArrayToCollection(new String[10], new ArrayList<Object>());
		
		fromArrayToCollectionG(new Object[10], new ArrayList<Object>());
		fromArrayToCollectionG(new String[10], new ArrayList<Object>());
//		fromArrayToCollectionG(new String[10], new ArrayList<Integer>());
		
		Test t = new Test();
		t.go("");
		t.<String>go("");
		t.<Object>go(new Object());
		
		go1("");
		Test.<String>go1("");
		Test.<Object>go1(new Object());
		
		List<String> l1 = new ArrayList<>();
		List<Integer> l2 = new ArrayList<>();
		System.out.println(l1.getClass() == l2.getClass());
		
		Collection<String> cs = new ArrayList<String>();
		if (cs instanceof ArrayList) {
			System.out.println("xxx");
		}
	}

	static void fromArrayToCollection(Object[] a, Collection<Object> c) {
		
	}
	
	static<T> void fromArrayToCollectionG(T[] a, Collection<T> c) {
		
	}
	
	static void getData(FX1<? extends Number> num) {
		
	}
	void go(String s) {
		System.out.println("normal function!");
	}
	<T> void go(T t) {
		System.out.println("generic function!");
	}
	
	static void go1(String s) {
		System.out.println("go1 normal function!");
	}
	static <T> void go1(T t) {
		System.out.println("go1 generic function!");
	}
	
	static class FX1<T> {
		private T ob;
		
		public FX1(T ob) {
			this.ob = ob;
		}
		
		public T getOb() {
			return this.ob;
		}
		
		public void showType() {
			System.out.println(this.ob.getClass().getName());
		}
	}
	
	static class FX2 {
		private Object ob;
		
		public FX2(Object ob) {
			this.ob = ob;
		}
		public Object getOb() {
			return this.ob;
		}
		
		public void showType() {
			System.out.println(this.ob.getClass().getName());
		}
	}
}
