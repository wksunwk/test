package functionalinterface;

import java.util.function.Supplier;

public interface FunctionalFactory {

	public static Functional create(Supplier<Functional> supplier) {
		return supplier.get();
	}
	public static void main(String[] args) {
		Functional f = FunctionalFactory.create(DefaultableImpl::new);
		f.defaultMethod();
	}
}
