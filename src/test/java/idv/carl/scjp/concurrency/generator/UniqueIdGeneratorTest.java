package idv.carl.scjp.concurrency.generator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

import static org.junit.Assert.assertEquals;

/**
 * @author Carl Lu
 */
public class UniqueIdGeneratorTest {

    @Test
    public void testNonConcurrentWith1Thread() throws InterruptedException, ExecutionException {
        testIdGenerationNonConcurrently(1);
    }

    @Test
    public void testNonConcurrentWith2Threads() throws ExecutionException, InterruptedException {
        testIdGenerationNonConcurrently(2);
    }

    @Test
    public void testNonConcurrentWith3Threads() throws ExecutionException, InterruptedException {
        testIdGenerationNonConcurrently(4);
    }

    @Test
    public void testNonConcurrentWith8Threads() throws ExecutionException, InterruptedException {
        testIdGenerationNonConcurrently(8);
    }

    @Test
    public void testNonConcurrentWith16Threads() throws ExecutionException, InterruptedException {
        testIdGenerationNonConcurrently(16);
    }

    @Test
    public void testNonConcurrentWith32Threads() throws ExecutionException, InterruptedException {
        testIdGenerationNonConcurrently(32);
    }

    @Test
    public void testConcurrentWith1Thread() throws InterruptedException, ExecutionException {
        testIdGenerationConcurrently(1);
    }

    @Test
    public void testConcurrentWith2Threads() throws ExecutionException, InterruptedException {
        testIdGenerationConcurrently(2);
    }

    @Test
    public void testConcurrentWith3Threads() throws ExecutionException, InterruptedException {
        testIdGenerationConcurrently(4);
    }

    @Test
    public void testConcurrentWith8Threads() throws ExecutionException, InterruptedException {
        testIdGenerationConcurrently(8);
    }

    @Test
    public void testConcurrentWith16Threads() throws ExecutionException, InterruptedException {
        testIdGenerationConcurrently(16);
    }

    @Test
    public void testConcurrentWith32Threads() throws ExecutionException, InterruptedException {
        testIdGenerationConcurrently(32);
    }

    private void testIdGenerationNonConcurrently(final int threadCount) throws InterruptedException, ExecutionException {
        final UniqueIdGenerator idGenerator = new UniqueIdGenerator();
        Callable<Long> nonConcurrentTask = idGenerator::getNextIdNonConcurrently;
        validateTaskResults(threadCount, nonConcurrentTask);
    }

    private void testIdGenerationConcurrently(final int threadCount) throws ExecutionException, InterruptedException {
        final UniqueIdGenerator idGenerator = new UniqueIdGenerator();
        Callable<Long> concurrentTask = idGenerator::getNextIdConcurrently;
        validateTaskResults(threadCount, concurrentTask);
    }

    private void validateTaskResults(final int threadCount, final Callable<Long> task)
            throws InterruptedException, ExecutionException {
        List<Callable<Long>> tasks = Collections.nCopies(threadCount, task);
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        List<Future<Long>> futures = executorService.invokeAll(tasks);

        List<Long> resultList = new ArrayList<>(futures.size());
        for (Future<Long> future : futures) {
            resultList.add(future.get());
        }

        assertEquals(threadCount, futures.size());

        List<Long> expectedList = new ArrayList<>(threadCount);
        for (long i = 1; i <= threadCount; i++) {
            expectedList.add(i);
        }

        Collections.sort(resultList);

        assertEquals(expectedList, resultList);
    }

}
