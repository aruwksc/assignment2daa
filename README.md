# Kadane Algorithm – Assignment 2 (Student B)

This project implements **Kadane’s Algorithm** for finding the **maximum subarray sum** in a 1D array.  
It includes:
-  Performance tracking (comparisons, allocations, execution time)
-  CLI for benchmarking with configurable input sizes
-  JUnit 5 tests with edge cases

---

##  Usage Instructions

### 1. Build the Project

```bash
mvn clean install
```

### 2. Run Benchmarks

```bash
mvn exec:java -Dexec.mainClass=org.example.cli.BenchmarkRunner -Dexec.args="100 1000 10000"
```

 Output: `docs/performance-plots/metrics.csv`  
 Columns: `n, time_ns, comparisons, allocations, algorithm`

### 3. Run Tests

```bash
mvn test
```

---

##  Time and Space Complexity

| Phase | Complexity |
|-------|------------|
| Time  | O(n) – linear traversal |
| Space | O(1) – constant space, no extra memory |

---

##  Example

**Input:**

```java
int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
```

**Output:**

```
Max Sum: 6
Start Index: 3
End Index: 6
Subarray: 4 -1 2 1
```

---

##  Example Benchmark Results

| n       | time_ns | comparisons | allocations | algorithm |
|---------|---------|-------------|-------------|-----------|
| 100     | 13400   | 99          | 0           | Kadane    |
| 1000    | 59700   | 999         | 0           | Kadane    |
| 10000   | 347700  | 9999        | 0           | Kadane    |
| 100000  | 3168600 | 99999       | 0           | Kadane    |




