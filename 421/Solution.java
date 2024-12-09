import java.util.*;



class Solution {
    public int findMaximumXOR(int[] nums) {
        // Arrays.sort(nums);
        int r = 0;
        int mask = 0;
        out:for (int i=31; i>=0; i--) {
            mask |= 1 << i;
            r ^= 1 << i;
            HashSet<Integer> s = new HashSet<>();
            for (int n: nums) {
                s.add(n & mask);
            }
            for (int n: nums) {
                if (s.contains((r^n)&mask)) continue out;
            }            
            r ^= 1 << i;
        }
        return r;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findMaximumXOR(new int[]{3,10,5,25,2,8});
    }
}