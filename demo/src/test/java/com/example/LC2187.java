package com.example;

class LC2187 {
  public long minimumTime(int[] time, int totalTrips) {
      long hi = Long.MAX_VALUE;
      long lo = 0;
      while (lo<=hi) {
          boolean overf = false;
          long mid = (lo+hi)/2;
          long trips = totalTrips;
          for (int t:time) {
              trips -= (mid/t);
              if (trips < 0) break;
          }
          if (trips <= 0) {
              hi = mid - 1;
          } else {
              lo = mid + 1;
          }
      }

      return lo;
  }
  public static void main(String[] args) {
    LC2187 s = new LC2187();
    long a  = s.minimumTime(new int[]{1,2,3}, 5);
    System.out.println(a);
  }
}