package com.example;

import org.example.Kadane;
import org.example.metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KadaneTest {

    @Test
    void testSingleElement() {
        int[] arr = {5};
        PerformanceTracker tracker = new PerformanceTracker();
        Kadane.Result result = Kadane.findMaxSubarray(arr, tracker);
        assertEquals(5, result.maxSum);
        assertEquals(0, result.start);
        assertEquals(0, result.end);
    }

    @Test
    void testAllNegative() {
        int[] arr = {-3, -2, -5};
        PerformanceTracker tracker = new PerformanceTracker();
        Kadane.Result result = Kadane.findMaxSubarray(arr, tracker);
        assertEquals(-2, result.maxSum);
        assertEquals(1, result.start);
        assertEquals(1, result.end);
    }

    @Test
    void testMixed() {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        PerformanceTracker tracker = new PerformanceTracker();
        Kadane.Result result = Kadane.findMaxSubarray(arr, tracker);
        assertEquals(6, result.maxSum); // [4, -1, 2, 1]
        assertEquals(3, result.start);
        assertEquals(6, result.end);
    }

    @Test
    void testAllPositive() {
        int[] arr = {1, 2, 3, 4};
        PerformanceTracker tracker = new PerformanceTracker();
        Kadane.Result result = Kadane.findMaxSubarray(arr, tracker);
        assertEquals(10, result.maxSum);
        assertEquals(0, result.start);
        assertEquals(3, result.end);
    }

    @Test
    void testEqualElements() {
        int[] arr = {2, 2, 2, 2};
        PerformanceTracker tracker = new PerformanceTracker();
        Kadane.Result result = Kadane.findMaxSubarray(arr, tracker);
        assertEquals(8, result.maxSum);
        assertEquals(0, result.start);
        assertEquals(3, result.end);
    }

    @Test
    void testEmptyArray() {
        int[] arr = {};
        PerformanceTracker tracker = new PerformanceTracker();
        assertThrows(IllegalArgumentException.class, () -> {
            Kadane.findMaxSubarray(arr, tracker);
        });
    }
}
