package com.example;
import com.example.tools.MyUtils;

// 好像也未完成
class LC2376 {
  public int countSpecialNumbers(int n) {
    int res = 0;
    int digs = 0;
    int [] digArray = new int[10];
    for(int i=n; i>0; i/=10) {    
      digArray[digs] = i%10;
      digs++;
      res += countSpecialNumbers(0, digs);
    }

    MyUtils.printArray(digArray);
    return res;
}

public int countSpecialNumbers(int captured, int digs) {
    if (digs == 0) return 0;
    if (captured == digs) return 1;
    int res = Math.min(10-captured, 9);
    return res * countSpecialNumbers(captured+1, digs); 
}
  
  public static void main(String[] args) {
    LC2376 s = new LC2376();
    int res;
    res = s.countSpecialNumbers(9);
    System.out.println(res);
    res = s.countSpecialNumbers(99);
    System.out.println(res);
    res = s.countSpecialNumbers(99999);
    System.out.println(res);
    res = s.countSpecialNumbers(99999999);
    System.out.println(res);
    res = s.countSpecialNumbers(12345);
    System.out.println(res);
  }
}