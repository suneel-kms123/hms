package com.hms.hms.leetcode;

import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class SlidingWindowProblems {

    public static void main(String[] args) {
        solveProblems(10, 19);
    }

    private static int[] solveProblems(int left, int right) {
        List<Integer> primes = new ArrayList<>();
        if (left > right) return new int[]{-1, -1};
        for (int i = left; i <= right; i++) {
            if (isPrime(i)) {
                System.out.println(i);
                primes.add(i); //found the prime numbers in list
            }
        }

        //TODO improve naming convention
        //TODO think to solve with minimum data structure not collection all the time


        if (primes.size() < 2) return new int[]{-1, -1};

        int min = Integer.MAX_VALUE;
        final int[][] result = {new int[2]};


        Map<Integer, int[]> map = new HashMap<>();


        for (int i = 0; i < primes.size(); i++) {
            for (int j = i + 1; j < primes.size(); j++) {
                int num1 = primes.get(i);
                int num2 = primes.get(j);
                int minDiff = Math.abs(num2 - num1);
                if (minDiff < min) {
                    min = minDiff;
                    result[0][0] = num1;
                    result[0][1] = num2;
                    if (map.containsKey(min)) {
                        int[] listToCompare = map.get(min);
                        if (listToCompare[0] > num1) {
                            map.put(min, result[0]);
                        }
                    } else {
                        map.put(min, result[0]);
                    }
                }
            }
        }
        return map.get(map.keySet().stream().sorted().findFirst().orElseThrow());

    }

    private static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= num; i++) {

            if (num % i == 0) return false;
        }
        return true;
    }

    public void handleExceptions() {
        try (Scanner scan = new Scanner(System.in)) {
            int x = scan.nextInt();
            int y = scan.nextInt();

            int z = x / y;

            if (z > 0) {
                System.out.println(z);
            }
        } catch (Exception e) {

            System.out.println(e.getClass().getCanonicalName());
        }
    }

    /*
     * Complete the 'minOperations' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER threshold
     *  3. INTEGER d
     */

    public static int minOperations(List<Integer> arr, int threshold, int d) {
        int count=0;
        for (int i =0; i< arr.size(); i++) {
            int k = arr.get(i);
            while(threshold > 0) {
                k=Math.abs(k/d);
                threshold--;
            }
            if (arr.contains(k)) count++;

            arr.set(i, k);
        }

        return arr.size() - new HashSet<>(arr).size();

    }


}