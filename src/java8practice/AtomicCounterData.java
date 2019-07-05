package java8practice;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounterData {
	private AtomicInteger c;

	public AtomicCounterData(AtomicInteger c) {
		this.c = c;
	}

	public AtomicInteger getC() {
		return c;
	}

	public void setC(AtomicInteger c) {
		this.c = c;
	}
}