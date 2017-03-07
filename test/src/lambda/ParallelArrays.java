package lambda;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class ParallelArrays {

	public static void main(String[] args) {
		long[] a = new long[20000];
		Arrays.parallelSetAll(a, index -> ThreadLocalRandom.current().nextInt(10000000));
		Arrays.stream(a).limit(10).forEach(i -> System.out.print(i + " "));
		System.out.println("");
		Arrays.parallelSort(a);
		Arrays.stream(a).limit(10).forEach(i -> System.out.print(i + " "));
	}
}
