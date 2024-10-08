package com.example;
class LC3137 {
  // 这是一个随长度单调递增的指标
  // 因此可以移动
  
  // 使用数组存储几个值
  int [] cnt;
  int o;

  private int add(int n) {
      o|=n;
      for (int i = 0; i < 32; i++,n>>=1) {
          cnt[i] += (n&1);
      }        
      // MyUtils.printArray(cnt);
      return o;
  }
  private int sub(int n) {
      for (int i = 0; i < 32; i++,n>>=1) {
          cnt[i] -= (n&1);
          if (cnt[i] <= 0) {
              o &= ~(1<<i);
          }
      } 
      // MyUtils.printArray(cnt);
      return o;
  }

  public int minimumDifference(int[] nums, int k) {
      cnt = new int[32];
      o = nums[0];

      int res = k;

      int lp = 0;
      for (int rp = 0; rp < nums.length; rp++) {
          o = add(nums[rp]);
          res = Math.min(Math.abs(k-o), res);
          while (k-o < 0) {
              if (lp >= rp) break;
              o = sub(nums[lp]);
              lp++;
              res = Math.min(Math.abs(k-o), res);
          }
          if (k-o == 0) return 0;
      }
      return res;
  }


  public static void main(String[] args) {
    LC3137 s = new LC3137();
    s.minimumDifference(new int[]{6}, 2);
  }
}