package com.example;

public class LC3007 {
  // 1836
  // +1
  // 0019 超过int的range就会
  class Solution {
    public long findMaximumNumber(long k, int x) {
        // bi-search
        long lo = 1; long hi = (long)1e15;
        while (hi >= lo) {
            long mid = (hi+lo)/2;
            long a = accumulatedPrice(mid, x, k);
            if (a > k) hi = mid -1;
            else if (a <= k) lo = mid + 1;
        }
        return hi;
    }

    private long accumulatedPrice(long n, int x, long k) {
        long a = 0;
        for (int i=x; a<=k; i+=x) {
            long r = countOnes(n, i);
            if (r<=0) break;
            a += r;
        }
        return a;
    }
    // d = [1, n]
    private long countOnes(long n ,int d) {
        n = n+1;
        long c = 1L << (long)d; // 注意这里的L。
        long a = n/c*c/2; // answer = half of cycle.
        long r = n % c; // out of cycle.
        a += Math.max(0,r-c/2); // 
        System.out.println("n = "+n+", d = "+d+", a = "+a);
        return a;
    }
  }
  
  public static void main(String[] args) {
    LC3007 outer = new LC3007();  // Create an instance of LC3007
    LC3007.Solution s = outer.new Solution();  // Use the outer instance to create Solution
    long result = s.findMaximumNumber((long)10000000000L, 2);
    System.out.println(result);
  }

}

/*
1312123123131

620933712881

*/