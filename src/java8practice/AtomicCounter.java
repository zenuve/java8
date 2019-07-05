package java8practice;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {
	private AtomicCounterData data = new AtomicCounterData(new AtomicInteger(0));

	public void increment() {
        data.getC().incrementAndGet();
    }

    public void decrement() {
        data.getC().decrementAndGet();
    }

    public int value() {
        return data.getC().get();
    }
}
