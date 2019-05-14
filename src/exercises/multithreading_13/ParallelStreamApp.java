package exercises.multithreading_13;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.LongStream;

public class ParallelStreamApp {

	public static void main(String[] args) {
		Instant before = Instant.now();

		OptionalDouble sum = LongStream.rangeClosed(1, 1_000_000_000L)
		      .parallel()
		      .mapToDouble(Math::sqrt)
		      .map(Math::log)
		      .average();
		Instant after = Instant.now();
		System.out.println(sum);
		System.out.println("Duration " + ChronoUnit.SECONDS.between(before, after));
	}
}