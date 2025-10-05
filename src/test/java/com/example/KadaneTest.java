package com.example;

import com.example.metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class KadaneTest {

    @Test
    void testMaxSum() {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        PerformanceTracker tracker = new PerformanceTracker();
        assertEquals(6, Kadane.findMaxSum(arr, tracker));
    }

    @Test
    void testAllNegative() {
        int[] arr = {-2, -3, -4};
        PerformanceTracker tracker = new PerformanceTracker();
        assertEquals(-2, Kadane.findMaxSum(arr, tracker));
    }

    @Test
    void testSingleElement() {
        int[] arr = {5};
        PerformanceTracker tracker = new PerformanceTracker();
        assertEquals(5, Kadane.findMaxSum(arr, tracker));
    }
}
