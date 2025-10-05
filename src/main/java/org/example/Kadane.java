package org.example;

import org.example.metrics.PerformanceTracker;

public class Kadane {

    public static class Result {
        public final int maxSum;
        public final int start;
        public final int end;

        public Result(int maxSum, int start, int end) {
            this.maxSum = maxSum;
            this.start = start;
            this.end = end;
        }
    }

    public static Result findMaxSubarray(int[] arr, PerformanceTracker tracker) {
        tracker.start();

        int maxSum = arr[0];
        int currentSum = arr[0];
        int start = 0, end = 0, tempStart = 0;

        for (int i = 1; i < arr.length; i++) {
            tracker.incComparison();
            if (arr[i] > currentSum + arr[i]) {
                currentSum = arr[i];
                tempStart = i;
            } else {
                currentSum += arr[i];
            }

            if (currentSum > maxSum) {
                tracker.incComparison();
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }
        }

        tracker.stop();
        return new Result(maxSum, start, end);
    }
}
