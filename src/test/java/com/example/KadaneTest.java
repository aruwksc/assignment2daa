package com.example;

import org.example.metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KadaneTest {

    @Test
    void testSingleElement() {
        int[] arr = {5};
        PerformanceTracker tracker = new PerformanceTracker();
        int result = Kadane.findMaxSum(arr, tracker);
        assertEquals(5, result);
    }

    @Test
    void testAllNegative() {
        int[] arr = {-3, -2, -5};
        PerformanceTracker tracker = new PerformanceTracker();
        int result = Kadane.findMaxSum(arr, tracker);
        assertEquals(-2, result);
    }

    @Test
    void testMixed() {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        PerformanceTracker tracker = new PerformanceTracker();
        int result = Kadane.findMaxSum(arr, tracker);
        assertEquals(6, result); // [4, -1, 2, 1]
    }

    @Test
    void testAllPositive() {
        int[] arr = {1, 2, 3, 4};
        PerformanceTracker tracker = new PerformanceTracker();
        int result = Kadane.findMaxSum(arr, tracker);
        assertEquals(10, result);
    }

    @Test
    void testEqualElements() {
        int[] arr = {2, 2, 2, 2};
        PerformanceTracker tracker = new PerformanceTracker();
        int result = Kadane.findMaxSum(arr, tracker);
        assertEquals(8, result);
    }

    @Test
    void testEmptyArray() {
        int[] arr = {};
        PerformanceTracker tracker = new PerformanceTracker();
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            Kadane.findMaxSum(arr, tracker);
        });
    }
}
