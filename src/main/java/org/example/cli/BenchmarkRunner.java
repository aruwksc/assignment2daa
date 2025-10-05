package org.example.cli;

import org.example.Kadane;
import org.example.metrics.PerformanceTracker;

import java.io.IOException;
import java.nio.file.*;
import java.util.Random;

public class BenchmarkRunner {

    public static void main(String[] args) throws IOException {

        int[] sizes;

        if (args.length > 0) {
            sizes = new int[args.length];
            for (int i = 0; i < args.length; i++) {
                try {
                    sizes[i] = Integer.parseInt(args[i]);
                } catch (NumberFormatException e) {
                    System.err.println("Invalid input: " + args[i]);
                    return;
                }
            }
        } else {
            sizes = new int[]{100, 1000, 10000, 100000};
        }

        Path outputPath = Paths.get("docs/performance-plots/metrics.csv");
        Files.createDirectories(outputPath.getParent());
        Random rnd = new Random(42);

        for (int n : sizes) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = rnd.nextInt(1000);
            }

            PerformanceTracker tracker = new PerformanceTracker();

            Kadane.Result res = Kadane.findMaxSubarray(arr, tracker);

            System.out.printf("n = %-7d | maxSum = %-10d | range = [%d, %d] | time = %dns\n",
                    n, res.maxSum, res.start, res.end, tracker.getTimeNs());

            tracker.toCSV(outputPath, n, "Kadane");
        }
    }
}
