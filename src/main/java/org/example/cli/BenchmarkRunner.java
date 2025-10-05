package com.example.cli;

import com.example.Kadane;
import org.example.metrics.PerformanceTracker;

import java.io.IOException;
import java.nio.file.*;
import java.util.Random;

public class BenchmarkRunner {

    public static void main(String[] args) throws IOException {
        int[] sizes = {100, 1000, 10000, 100000};
        Path output = Paths.get("docs/performance-plots/metrics.csv");

        // создаём директории при необходимости
        Files.createDirectories(output.getParent());

        Random rnd = new Random();

        for (int n : sizes) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = rnd.nextInt(1000);
            }

            PerformanceTracker tracker = new PerformanceTracker();
            int result = Kadane.findMaxSum(arr, tracker);
            System.out.println("n = " + n + ", maxSum = " + result + ", time = " + tracker.getTimeNs() + "ns");

            tracker.toCSV(output, n, "Kadane");
        }
    }
}
