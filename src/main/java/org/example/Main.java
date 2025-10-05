package org.example;

import org.example.Kadane;
import org.example.metrics.PerformanceTracker;

public class Main {
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        PerformanceTracker tracker = new PerformanceTracker();
        Kadane.Result result = Kadane.findMaxSubarray(arr, tracker);

        System.out.println("Max Sum: " + result.maxSum);
        System.out.println("Start Index: " + result.start);
        System.out.println("End Index: " + result.end);

        System.out.print("Subarray: ");
        for (int i = result.start; i <= result.end; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
