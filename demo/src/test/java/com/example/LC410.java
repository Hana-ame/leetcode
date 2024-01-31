package com.example;
import java.util.*;
public class LC410 {
    // https://leetcode.cn/problems/split-array-largest-sum/description/
    public static void main(String[] args) {

    }

    // 似乎不用考虑溢出
    // nums 分为 k 份，使得k份的最大值最小
    public static int splitArray(int[] nums, int k) {
        // k = 1 时遍历
        

        // cache the sum for nums;
        int [] sum = new int[nums.length+1];
        for (int i=1; i<sum.length; i++) {
            sum[i] = sum[i-1] + nums[i-1];
        }
        // note:
        // sum(nums[i..j]) = sum[j+1] - sum[i]

        // initial the mem while k = 1;
        int [] mem = Arrays.copyOf(sum, sum.length);
        // mem[i]:
        // for nums[0..i-i], divided into k groups, the maxium's minum.
        // k >= 2 
        for (int i=2; i<=k; i++) { // i = k
            // for every k,
            for (int j=nums.length; j>=i; j--) { // for not overwrite the mem
                // for nums[k-1..j-1], k-1 => k
                for (int l=i-1; l<j; l++) {
                    mem[j] = Math.min(mem[j], Math.max(mem[l],sum[j]-sum[l]));
                }
            }
        }
        return mem[nums.length];        
    }
}
