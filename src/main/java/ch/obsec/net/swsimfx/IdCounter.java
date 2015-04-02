package ch.obsec.net.swsimfx;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @version 1.1
 * @since 1.1
 * @author mario.oberli@obsec.ch
 */
public class IdCounter {

    private static AtomicLong counter = new AtomicLong(0);

    public static long nextId() {
        return counter.incrementAndGet();
    }
}
