import java.util.*;

class Solution {
    static TreeSet<Integer> arr;
    static {
        final int MAX_N = 1005;

        arr = new TreeSet<>();
        boolean [] primeN = new boolean[MAX_N];

        primeN[2] = true;
        arr.add(2);
        for (int i=2; i<MAX_N; i++){
            if (!primeN[i]) {
                arr.add(i);
            }
            for (int p: arr) {
                if (p*i >= MAX_N) break;
                primeN[p*i] = true;
            }
        }        
        // System.out.println(arr);
        arr.add(Integer.MIN_VALUE);
        arr.add(0);
    }
    public boolean primeSubOperation(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int k = nums[i];
            if (i>0) k -= nums[i-1];
            int p = Solution.arr.lower(k);
            if (p < 0) return false;
            nums[i] -= p;
        }
        return true;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Solution.arr);
        solution.primeSubOperation(new int[]{998,2});
    }
}

