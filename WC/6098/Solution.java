import java.util.*;
class Solution {
    public long countSubarrays(int[] nums, long k) {
        long res = 0;
        // HashSet<Long> set = new HashSet<>();
        int l = 0;
        int r = 0;
        long sum = 0;
        for (;r<nums.length;){
            sum += nums[r];
            r++;
            while (sum*(r-l)>=k){
                sum-=nums[l];
                l++;
            }
            res += r-l;
            
        }
        return res;
    }
    // private 
    // private long hash(int[] arr){
    //     long res = 1;
    //     for (int i:arr){
    //         res = res*1034 + 666 + i;
    //     }
    //     return res;
    // }
    public static void main(String[] args) {
        var s = new Solution();
        var nums = new int[]{2,1,4,3,5};
        long k = 10;
        s.countSubarrays(nums, k);
    }
}