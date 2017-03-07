package functionalinterface;

@FunctionalInterface
public interface Functional {
	void method();
//	void method2();
	default void defaultMethod() {
		System.out.println("from interface");
	}
}
