package lambda;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

	private enum Status {
		OPEN, CLOSED
	};
	
	public static void main(String[] args) {
		Collection<Task> tasks = Arrays.asList(new Task(Status.OPEN, 5),
				new Task(Status.OPEN, 13), new Task(Status.CLOSED, 8));
		
		long total = tasks.stream()
				.filter(task -> task.getStatus() == Status.OPEN)
				.mapToInt(Task::getPoints).sum();
		System.out.println(total);
		
		total = tasks.stream().parallel().map(task -> task.getPoints())
				.reduce(0, Integer::sum);
		System.out.println(total);
		
		Map<Status, List<Task>> m = tasks.stream().collect(
				Collectors.groupingBy(Task::getStatus));
		System.out.println(m);
		
		final double d = total;
		Collection<String> c = tasks.stream()
				.mapToInt(task -> task.getPoints()).asLongStream()
				.mapToDouble(point -> point / d).boxed()
				.mapToLong(weight -> (long) (weight * 100))
				.mapToObj(percentage -> percentage + "%")
				.collect(Collectors.toList());
		System.out.println(c);
		
		String filePath = "D:\\t1.csv";
		Path path = new File(filePath).toPath();
		try {
			Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8);
			lines.onClose(() -> System.out.println("Done!")).forEach(
					System.out::println);
			lines.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	private static class Task {
		
		private Status status;
		
		private Integer points;
		
		public Task(Status status, Integer points) {
			this.status = status;
			this.points = points;
		}

		public Status getStatus() {
			return status;
		}

		public Integer getPoints() {
			return points;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return String.format("[%s, %d]", status, points);
		}
	}
}
