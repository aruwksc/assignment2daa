package org.example.metrics;

import java.io.*;
import java.nio.file.*;
import java.util.Locale;

public class PerformanceTracker {
    private long comparisons = 0;
    private long allocations = 0;
    private long start, end;

    public void start() {
        start = System.nanoTime();
    }

    public void stop() {
        end = System.nanoTime();
    }

    public long getTimeNs() {
        return end - start;
    }

    public void incComparison() {
        comparisons++;
    }

    public void incAllocation() {
        allocations++;
    }

    public long getComparisons() {
        return comparisons;
    }

    public long getAllocations() {
        return allocations;
    }

    public void toCSV(Path path, int n, String algoName) throws IOException {
        boolean fileExists = Files.exists(path);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path.toFile(), true))) {
            if (!fileExists) {
                writer.write("n,time_ns,comparisons,allocations,algorithm\n");
            }
            writer.write(String.format(Locale.US, "%d,%d,%d,%d,%s%n",
                    n, getTimeNs(), comparisons, allocations, algoName));
        }
    }
}
