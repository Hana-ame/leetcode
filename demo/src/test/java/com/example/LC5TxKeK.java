package com.example;
import java.util.ArrayList;
import java.util.PriorityQueue;

import com.example.tools.MidPriorityQueue;
import com.example.tools.MyUtils;
import com.example.tools.PriorityQueueWithMemo;

public class LC5TxKeK {
  public static void main(String[] args) {
    // input 
    ArrayList<Double> arr = Utils.getDataFromJsonFile("5TxKek.json");
    int [] nums = new int[arr.size()];
    for (int i=0; i<nums.length; i++) {
      double d = arr.get(i);
      nums[i] = (int) Math.round(d);
    }
    // arr = MyUtils.asList(nums);

    // https://leetcode.cn/problems/5TxKeK/?envType=daily-question&envId=2024-02-01
    PriorityQueueWithMemo<Long> head = new PriorityQueueWithMemo<Long>((a,b)->{return Long.compare(b,a);},(long)0){
      @Override
      public Long poll() {
        Long e = super.poll();
        memo -= e;
        return e;
      }
      @Override
      public boolean add(Long e) {
        memo += e;
        return super.add(e);
      }
    };
    PriorityQueueWithMemo<Long> tail = new PriorityQueueWithMemo<Long>((a,b)->{return Long.compare(a,b);},(long)0){
      @Override
      public Long poll() {
        Long e = super.poll();
        memo -= e;
        return e;
      }
      @Override
      public boolean add(Long e) {
        memo += e;
        return super.add(e);
      }
    };
    MidPriorityQueue<Long> mpq = new MidPriorityQueue<>(head, tail);

    // static
    final long MOD = (long)1e9+7;
    // input
    // int [] nums = new int[]{};
    // main
    int [] res = new int[nums.length];
    for (int i=0; i<nums.length; i++) {
        mpq.add((long)nums[i]-i);
        // calc
        long mid = mpq.peek() % MOD ;
        long part1 = (mid*head.size() % MOD +MOD)- (head.getMemo()+MOD) % MOD;
        long part2 = (tail.getMemo() % MOD +MOD) - (mid*tail.size()+MOD) % MOD;
        long sum = (part1 + part2) % MOD;
        res[i] = (int)sum;
    }
    // output
    System.out.println(MyUtils.asList(res));

    int[] official = numsGame(nums);
    System.out.println(MyUtils.asList(official));

    System.out.println(official.length);
    System.out.println(res.length);

    for (int i=0; i<official.length; i++) {
      if (official[i] != res[i]) {
        System.out.println(i);
        System.out.println(official[i]);
        System.out.println(res[i]);
      }
    }

  }
  static public int[] numsGame(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        PriorityQueue<Integer> lower = new PriorityQueue<Integer>((a, b) -> b - a);
        PriorityQueue<Integer> upper = new PriorityQueue<Integer>((a, b) -> a - b);
        final int MOD = 1000000007;
        long lowerSum = 0, upperSum = 0;
        for (int i = 0; i < n; i++) {
            int x = nums[i] - i;
            if (lower.isEmpty() || lower.peek() >= x) {
                lowerSum += x;
                lower.offer(x);
                if (lower.size() > upper.size() + 1) {
                    upperSum += lower.peek();
                    upper.offer(lower.peek());
                    lowerSum -= lower.peek();
                    lower.poll();
                }
            } else {
                upperSum += x;
                upper.offer(x);
                if (lower.size() < upper.size()) {
                    lowerSum += upper.peek();
                    lower.offer(upper.peek());
                    upperSum -= upper.peek();
                    upper.poll();
                }
            }
            if ((i + 1) % 2 == 0) {
                res[i] = (int) ((upperSum - lowerSum) % MOD);
            } else {
                res[i] = (int) ((upperSum - lowerSum + lower.peek()) % MOD);
            }
        }
        return res;
    }
}

