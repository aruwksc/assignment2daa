package org.example;
import org.example.metrics.PerformanceTracker;


public class Kadane {

    public static Result findMaxSubarray(int[] arr, PerformanceTracker tracker) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Input array must not be null or empty.");
        }

        if (arr.length == 1) {
            return new Result(arr[0], 0, 0);
        }

        int maxSum = arr[0];
        int start = 0;
        int end = 0;
        int tempStart = 0;
        int currentSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (currentSum + arr[i] > arr[i]) {
                currentSum += arr[i];
            } else {
                currentSum = arr[i];
                tempStart = i;
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }
        }

        return new Result(maxSum, start, end);
    }

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
}
