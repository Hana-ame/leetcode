package com.example;

import java.util.HashMap;
import com.example.tools.Pair;
import com.example.tools.ModLong;


class LC552 {
  HashMap<Integer, Pair<ModLong, ModLong>> cache;

  public int checkRecord(int n) {
    cache = new HashMap<>();

    Pair<ModLong, ModLong> pair = checkRecordR(n);

    ModLong ret = ModLong.sum(pair.getKey(),pair.getValue());
    return (int)ret.getValue();

  }

  // records with absent
  // records without absent
  public Pair<ModLong, ModLong> checkRecordR(int n) {
    Pair<ModLong, ModLong> pair = cache.get(n);
    if (pair != null)
      return pair;
    // if (n == 0) 
    //   return new Pair<ModInteger, ModInteger>(new ModInteger(1),new ModInteger(1));
    if (n == 1)
      return new Pair<ModLong, ModLong>(new ModLong(1),new ModLong(2));
    if (n == 2)
      return new Pair<ModLong, ModLong>(new ModLong(4),new ModLong(4));
    if (n == 3)
      return new Pair<ModLong, ModLong>(new ModLong(12),new ModLong(7));  
    if (n > 3){
      Pair<ModLong, ModLong> sum = add(
        checkRecordR(n-1),
        checkRecordR(n-2),
        checkRecordR(n-3)
      );
      pair = mul(sum, new Pair<ModLong,ModLong>(new ModLong(1), new ModLong(1)));
    } else
      return null;
    cache.put(n, pair);
    return pair;
  }

  private Pair<ModLong, ModLong> add(Pair<ModLong, ModLong>... args) {
    ModLong key = new ModLong(0);
    ModLong value = new ModLong(0);
    for (Pair<ModLong, ModLong> arg : args) {
      key.add(arg.getKey());
      value.add(arg.getValue());
    }
    return new Pair<ModLong, ModLong>(
        key, value);
  }

  private static Pair<ModLong, ModLong> mul(Pair<ModLong, ModLong> a, Pair<ModLong, ModLong> b) {
    return new Pair<ModLong, ModLong>(
      ModLong.sum(
        ModLong.product(a.getKey(),b.getValue()),
        ModLong.product(b.getKey(),a.getValue())          
      ),
      ModLong.product(a.getValue(), b.getValue())
    );
  }

  public static void main(String[] args) {
    LC552 solution = new LC552();
    System.out.println( solution.checkRecord(20) );
  }
}