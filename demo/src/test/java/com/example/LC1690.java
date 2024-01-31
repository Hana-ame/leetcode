package com.example;

import java.util.ArrayList;
import java.util.HashMap;

public class LC1690 {
  int[] stones;

  public static void main(String[] args) {
    LC1690 s = new LC1690();
    ArrayList<Double> arr = Utils.getDataFromJsonFile("testcases/1690.json");
    int [] stones = new int[arr.size()];
    for(int i=0; i<arr.size(); i++) stones[i] = (int) Math.round(arr.get(i));
    // stones = new int[]{1,2,3,4,5,6};
    int ans = 0;
    for (int i=0; i<10; i++) {
      long start = System.nanoTime();
      ans = s.stoneGameVII(stones);
      long end = System.nanoTime();
      System.out.println(end-start);
    }
    System.out.println(ans);
  }


  public int stoneGameVII(int[] stones) {
    this.stones = stones;
    Cache<Integer> cache = new Cache<>();
    return cache.run(new MyFun(0, stones.length-1));
  }

  // public int stoneGameVII(int[] stones) {
  //   int n = stones.length;
  //   int[] sum = new int[n + 1];
  //   int[][] memo = new int[n][n];
  //   for (int i = 0; i < n; i++) {
  //       sum[i + 1] = sum[i] + stones[i];
  //   }
  //   return dfs(0, n - 1, sum, memo);
  // }

  public int dfs(int i, int j, int[] sum, int[][] memo) {
      if (i >= j) {
          return 0;
      }
      if (memo[i][j] != 0) {
          return memo[i][j];
      }
      int res = Math.max(sum[j + 1] - sum[i + 1] - dfs(i + 1, j, sum, memo), sum[j] - sum[i] - dfs(i, j - 1, sum, memo));
      memo[i][j] = res;
      return res;
  }

  // 作者：力扣官方题解
  // 链接：https://leetcode.cn/problems/stone-game-vii/solutions/2626699/shi-zi-you-xi-vii-by-leetcode-solution-8wqc/
  // 来源：力扣（LeetCode）
  // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

  class MyFun implements FunctionWithCache<Integer> {

    int l;
    int r;

    public String toString(){
      return l + "," + r;
    }

    MyFun(int l, int r) {
      this.l = l;
      this.r = r;
    }

    // someone chose the [i..j]
    // query the max difference can get form [i..j].
    @Override
    public Integer run(Cache<Integer> cache) {
      if (l == r) {
        return 0;
      }
      if (l+1 == r) {
        return Math.max(stones[l], stones[r]);
      } 
        
      // must not run it self. done by class<Cache>
      // if (cache.containsKey(this)) return cache.get(this);
      return Math.max(
        // r
        Math.min(stones[l] + cache.run(new MyFun(l+1, r-1)), stones[r-1] + cache.run(new MyFun(l, r-2))),
        // l
        Math.min(stones[r] + cache.run(new MyFun(l+1, r-1)), stones[l+1] + cache.run(new MyFun(l+2, r)))
      );
    }

    // query the max difference can get form [i..j].
    // @Override
    // public Integer run() {
    // if (l == r) return stones[l];
    // return Math.max(stones);
    // }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + l;
      result = prime * result + r;
      return result;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      MyFun other = (MyFun) obj;
      if (l != other.l)
        return false;
      if (r != other.r)
        return false;
      return true;
    }

  }

}

class Cache<T> extends HashMap<FunctionWithCache<T>, T> {

  Cache() {
    super();
  }

  public T run(FunctionWithCache<T> function) {
    T result = runOrCached(function, function);
    return result;
  }

  // public boolean containsKey(Object keyObject) {
  // return containsKey(keyObject);
  // }

  public T runOrCached(Object keyObject, FunctionWithCache<T> function) {
    if (containsKey(keyObject)) {
      // System.out.println(keyObject.toString());
      return get(keyObject);
    }
    // System.out.println(keyObject.toString());
    return cache(function);
  }

  // public T put(Function<T> function, T result) {
  // return super.put(function, result);
  // }

  public T cache(FunctionWithCache<T> function) {
    T result = function.run(this);
    put(function, result);
    return result;
  }

  

}

@FunctionalInterface // java 1.8
interface FunctionWithCache<T> {
  // public abstract String hashString();
  public abstract T run(Cache<T> cache);
}
