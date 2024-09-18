package com.example;

import java.util.Arrays;

// 超级慢
class LC2332 {
  public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
    Arrays.sort(buses);
    Arrays.sort(passengers);
    int finalPassenger = 0;
    int pPas = 0;
    for (int bus : buses) {
        int nextPtrPassengers = findPassengerPointer(passengers, pPas, bus, capacity);
        if (nextPtrPassengers - pPas < capacity && passengers[Math.max(0,nextPtrPassengers-1)] < bus) finalPassenger = bus;
        pPas = nextPtrPassengers;
        System.out.println(pPas);
    }

  
  // 最后一个乘到车的人
  pPas = Math.min(pPas-1, passengers.length-1);
  int lo = 0;
  int hi = pPas;
  while (lo <= hi) {
      int mid = (lo+hi)/2;
      if (passengers[mid] < passengers[pPas]-pPas+mid)
          lo = mid +1;
      else
          hi = mid - 1;
  }
  return Math.min(Math.max(lo < 0? passengers[0] -1 : passengers[lo] - 1, finalPassenger), buses[buses.length-1]); 
}

private int findPassengerPointer(int[] passengers, int pPassengers, int bus, int capacity) {
    // 二分查找第一个上不到车的乘客，返回ptr
    int head = pPassengers; //, tail = ;
    int tail = Math.min(pPassengers+capacity-1, passengers.length-1);
    while (head <= tail) {
        int mid = (head+tail )/2 ;
        if (passengers[mid] <= bus)
            head = mid + 1;
        else
            tail = mid - 1;
    }
    return head;
}

  public static void main(String[] args) {
    LC2332 solution = new LC2332();
    // int [] buses = new int[]{3};
    // int [] passengers = new int[]{2,3};
    // int [] buses = new int[]{10,20};
    // int [] passengers = new int[]{2,16,17,18};
    int [] buses = new int[]{10,20,30};
    int [] passengers = new int[]{2,5,7,13,19,21,25};
    int capacity = 2;
    solution.latestTimeCatchTheBus(buses,passengers,capacity);
  }
}