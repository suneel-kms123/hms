package com.hms.hms.leetcode;

public class ProgrammingQ {

    private int fibonacci(int n, int[] memo) {
        int[] arr = {1,2,3,4,};
        for (int i =0; i< arr.length;i++){}
        if (memo[n] != 0) return memo[n];
        if (n <= 1) return n;
        memo[n] = fibonacci(n - 1, memo) + fibonacci(n - 2, memo);
        return memo[n];
    }
}
