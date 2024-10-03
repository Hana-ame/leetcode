package com.example;

// 未完成，需要换成整数的。
public class LC1870 {
  static class Solution {
      private int divide1(int d, int s) {
          int r = d/s;
          if (d%s!=0) r++;
          return r;
      }
      public int minSpeedOnTime(int[] dist, double hour) {
          if (dist.length - 1 > hour) return -1;
          // 大概是二分。
          int h = 0;
          int hi = 0;
          int lo = 1;
          for (int d: dist) {
              h += d;
              hi = Math.max(d,hi);
          }
          if (h <= hour) return 1;
          hi = Math.max(
            (int)(dist[dist.length-1]/(hour-dist.length+1)+1),
            hi);

          while (lo <= hi) {
              h = 0;
              int mid = (lo+hi)/2;
              for (int i = dist.length-2; i>=0; i--) {
                  h += divide1(dist[i],mid);
              }      
              if (h <= hour - (double)dist[dist.length-1]/(double)mid+0.0001) {
                  // 允许的情况
                  hi = mid - 1;
                } else {
                  // 不允许的情况
                  lo = mid + 1;
              }
          }

          return lo;
      }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    s.minSpeedOnTime(new int[]{1,1,1000000}, 2.01);
    // s.minSpeedOnTime(new int[]{1,3,2}, 2.7);

  }
}
