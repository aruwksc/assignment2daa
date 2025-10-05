package org.example.benchmark;

import org.example.Kadane;
import org.example.metrics.PerformanceTracker;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;
import java.util.Random;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
public class KadaneBenchmark {

    private int[] array;
    private PerformanceTracker tracker;

    @Param({"100", "1000", "10000", "100000"})
    int size;

    @Setup(Level.Iteration)
    public void setUp() {
        array = new int[size];
        Random random = new Random(42);
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1000) - 500;
        }
        tracker = new PerformanceTracker();
    }

    @Benchmark
    public int benchmarkKadane() {
        Kadane.Result result = Kadane.findMaxSubarray(array, tracker);
        return result.maxSum;
    }
}
