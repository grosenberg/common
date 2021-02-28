package net.certiv.common.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import net.certiv.common.stores.Pair;

/**
 * Utility for keeping running measurements of time.
 *
 * @see org.eclipse.core.runtime.PerformanceStats
 */
public class Time {

	/** key=category; value=start/stop times. */
	private static final Map<Enum<?>, Pair<Long, Long>> times = new HashMap<>();
	private static final int MILLI = 1000000;

	/** Start measuring time for the given id. */
	public static <E extends Enum<E>> void start(E id) {
		long start = System.nanoTime();
		times.put(id, Pair.of(start, start));
	}

	/** Stop measuring time for the given id; returns elapsed. */
	public static <E extends Enum<E>> double stop(E id) {
		Pair<Long, Long> time = times.get(id);
		if (time != null) times.put(id, Pair.of(time.left, System.nanoTime()));
		return elapsed(id);
	}

	public static <E extends Enum<E>> String stop(E id, String format) {
		return String.format(format, stop(id));
	}

	/**
	 * Returns the elapsed time for the given id in milliseconds with a decimal
	 * precision of 2.
	 */
	public static <E extends Enum<E>> double elapsed(E id) {
		double millis = 0;
		Pair<Long, Long> time = times.get(id);
		if (time != null) {
			long now = System.nanoTime();
			long stop = time.right > time.left ? time.right : now;
			millis = Math.max(stop - time.left, 0) / MILLI;
		}
		return Maths.round(millis, 2);
	}

	public static <E extends Enum<E>> String elapsed(E id, String format) {
		return String.format(format, elapsed(id));
	}

	public static <E extends Enum<E>> void clear(E id) {
		times.remove(id);
	}

	public static void clear() {
		times.clear();
	}

	// ------------------------------

	public static boolean wait(int seconds) {
		try {
			TimeUnit.SECONDS.sleep(seconds);
			return true;
		} catch (InterruptedException e) {
			return false;
		}
	}

	public static final String formatDate(LocalDateTime dt) {
		return dt.format(DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a"));
	}
}
