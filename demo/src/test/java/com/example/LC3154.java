package com.example;

import com.example.tools.*;
/**
 * LC3154
 */
public class LC3154 {

  public int waysToReachStair(int k) {
    if (k==0) return 2;
    if (k==1) return 4;
    int r = 0;
    for (int j=1;;j++) {
        int n = 1 << j; // j个跳，最大到达处
        int m = n - k; // j个跳，需要的下降
        if (m < 0) continue;
        if (m > j+1) break;
        r += Mathmatic.combination(j+1,m);
    }
    return r;
  }

  public static void main(String[] args) {
    int r = 0;
    LC3154 s = new LC3154();
    r = s.waysToReachStair(0);
    System.out.println(r);
    r = s.waysToReachStair(1);
    System.out.println(r);
    r = s.waysToReachStair(2);
    System.out.println(r);
    r = s.waysToReachStair(20);
    System.out.println(r);
    r = s.waysToReachStair(1048566);
    System.out.println(r);
    r = s.waysToReachStair(0);
    System.out.println(r);
  }

}