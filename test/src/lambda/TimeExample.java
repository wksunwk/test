package lambda;

import java.time.Clock;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeExample {

	public static void main(String[] args) {
//		Clock clock = Clock.systemUTC();
//		System.out.println(clock.instant());
//		System.out.println(clock.millis());
		
//		Clock c = Clock.systemDefaultZone();
//		System.out.println(c.instant());
//		System.out.println(c.millis());
//		
		Clock clock = Clock.system(ZoneId.of("GMT+8"));
		System.out.println(clock.instant());
		System.out.println(clock.millis());
		
		LocalDate date = LocalDate.now(clock);
		LocalTime time = LocalTime.now(clock);
		System.out.println(date);
		System.out.println(time);
		
		LocalDateTime dt = LocalDateTime.now(clock);
		System.out.println(dt);
		
		ZonedDateTime zdt = ZonedDateTime.now(clock);
		System.out.println(zdt);
		
		LocalDateTime start = LocalDateTime.of(2014, Month.APRIL, 16, 0, 0, 0);
		LocalDateTime end = LocalDateTime.of(2014, Month.MAY, 16, 1, 59, 0);
		Duration d = Duration.between(start, end);
		System.out.println(d.toDays());
		System.out.println(d.toHours());
	}
}
