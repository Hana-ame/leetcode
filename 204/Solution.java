import java.util.*;

class Solution {
    static TreeMap<Integer,Integer> arr;
    static {
        final int MAX_N = (int)5e6+1;

        arr = new TreeMap<>();
        boolean [] notPrime = new boolean[MAX_N];
        int cnt = 0;
        notPrime[0] = true;
        notPrime[1] = true;
        // arr.put(2, 1);
        for (int i=2; i<MAX_N; i++){
            if (!notPrime[i]) {
                cnt++;
                arr.put(i, cnt);
            }
            for (int p: arr.keySet()) {
                if (p*i >= MAX_N) break;
                notPrime[p*i] = true;
            }
        }        
        // System.out.println(arr);
        arr.put(Integer.MIN_VALUE, 0);
        // arr.add(0);
    }
    public int countPrimes(int n) {
        // return arr.lowerEntry(n).getValue();
        TreeMap<Integer, Integer> arr = new TreeMap<>();
        boolean [] notPrime = new boolean[n];
        int cnt = 0;
        notPrime[0] = true;
        notPrime[1] = true;
        // arr.put(2, 1);
        for (int i=2; i<n; i++){
            if (!notPrime[i]) {
                cnt++;
                arr.put(i, cnt);
            }
            for (int p: arr.keySet()) {
                if (p*i >= n) break;
                notPrime[p*i] = true;
            }
        }        
        // System.out.println(arr);
        // arr.put(Integer.MIN_VALUE, 0);
        return cnt;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        // solution.countPrimes(1);
        // solution.countPrimes(3);
        // solution.countPrimes(5);
        // solution.countPrimes(7);
        solution.countPrimes(10);
        // solution.countPrimes(15);
    }
}

