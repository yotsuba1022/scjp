package idv.carl.scjp.concurrency.generator;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Carl Lu
 */
public class UniqueIdGenerator {

    private final AtomicLong atomicLong = new AtomicLong();
    private long counter = 0;

    public long getNextIdNonConcurrently() {
        return ++counter;
    }

    public long getNextIdConcurrently() {
        return atomicLong.incrementAndGet();
    }

}
