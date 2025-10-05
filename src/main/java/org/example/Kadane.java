package com.example;

import com.example.metrics.PerformanceTracker;

public class Kadane {

    public static int findMaxSum(int[] arr, PerformanceTracker tracker) {
        tracker.start();

        int maxSum = arr[0];
        int currentSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            tracker.incComparison();  // сравнение внутри Math.max
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        tracker.stop();
        return maxSum;
    }
}
