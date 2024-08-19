package com.example;

import java.util.HashMap;
import com.example.tools.Pair;
import com.example.tools.ModInteger;


class LC552 {
  HashMap<Integer, Pair<ModInteger, ModInteger>> cache;

  public int checkRecord(int n) {
    cache = new HashMap<>();

    Pair<ModInteger, ModInteger> pair = checkRecordR(n);

    ModInteger ret = ModInteger.sum(pair.getKey(),pair.getValue());
    return ret.getValue();

  }

  // records with absent
  // records without absent
  public Pair<ModInteger, ModInteger> checkRecordR(int n) {
    Pair<ModInteger, ModInteger> pair = cache.get(n);
    if (pair != null)
      return pair;
    // if (n == 0) 
    //   return new Pair<ModInteger, ModInteger>(new ModInteger(1),new ModInteger(1));
    if (n == 1)
      return new Pair<ModInteger, ModInteger>(new ModInteger(1),new ModInteger(2));
    if (n == 2)
      return new Pair<ModInteger, ModInteger>(new ModInteger(4),new ModInteger(4));
    if (n == 3)
      return new Pair<ModInteger, ModInteger>(new ModInteger(12),new ModInteger(7));  
    if (n > 3){
      Pair<ModInteger, ModInteger> sum = add(
        checkRecordR(n-1),
        checkRecordR(n-2),
        checkRecordR(n-3)
      );
      pair = mul(sum, new Pair<ModInteger,ModInteger>(new ModInteger(1), new ModInteger(1)));
    } else
      return null;
    cache.put(n, pair);
    return pair;
  }

  private Pair<ModInteger, ModInteger> add(Pair<ModInteger, ModInteger>... args) {
    ModInteger key = new ModInteger(0);
    ModInteger value = new ModInteger(0);
    for (Pair<ModInteger, ModInteger> arg : args) {
      key.add(arg.getKey());
      value.add(arg.getValue());
    }
    return new Pair<ModInteger, ModInteger>(
        key, value);
  }

  private static Pair<ModInteger, ModInteger> mul(Pair<ModInteger, ModInteger> a, Pair<ModInteger, ModInteger> b) {
    return new Pair<ModInteger, ModInteger>(
      ModInteger.sum(
        ModInteger.product(a.getKey(),b.getValue()),
        ModInteger.product(b.getKey(),a.getValue())          
      ),
      ModInteger.product(a.getValue(), b.getValue())
    );
  }

  public static void main(String[] args) {
    LC552 solution = new LC552();
    System.out.println( solution.checkRecord(20) );
  }
}