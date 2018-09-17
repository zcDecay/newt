package com.newt.utils;

import org.apache.commons.lang3.time.FastDateFormat;

import java.util.Locale;
import java.util.TimeZone;

/**
 * 订单号生成器 18位
 */
public class OrderCodeUtil {

	public static final FastDateFormat s = FastDateFormat.getInstance("yyMMddHHmmssSSS", TimeZone.getDefault(),
			Locale.getDefault());

	public static volatile OrderCodeUtil codeWorker;

	public static OrderCodeUtil getInstance() {
		if (codeWorker == null) {
			synchronized (OrderCodeUtil.class) {
				if (codeWorker == null) {
					codeWorker = new OrderCodeUtil();
				}
			}
		}
		return codeWorker;
	}

	private long lastTimestamp = -1L;

	/**
	 * 序号
	 */
	private long sequence = 0L;

	private long maxSequence = 99L;

	public OrderCodeUtil() {
	}

	public synchronized long nextCode() {
		return this.nextCode("37");
	}

	public synchronized long nextCode(String prefix) {
		long timestamp = timeGen();

		if (timestamp < lastTimestamp) {
			throw new RuntimeException(String.format(
					"Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
		}

		if (lastTimestamp == timestamp) {
			sequence = (sequence + 1);
			if (sequence >= maxSequence) {
				sequence = 1L;
				timestamp = tilNextMillis(lastTimestamp);
			}
		} else {
			sequence = 1L;
		}
		lastTimestamp = timestamp;
		return Long.parseLong(prefix + timestamp + String.format("%02d", sequence));
	}

	protected long tilNextMillis(long lastTimestamp) {
		long timestamp = timeGen();
		while (timestamp <= lastTimestamp) {
			timestamp = timeGen();
		}
		return timestamp;
	}

	protected long timeGen() {
		return Long.parseLong(s.format(System.currentTimeMillis()));
	}

}
