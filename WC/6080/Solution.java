// UNSOLVED

import java.util.ArrayList;

class Solution {
    public int totalSteps(int[] nums) {
        int max = nums[0];
        int single = nums[0];
        int res = 0;
        int s = 0;
        ArrayList<int []> list = new ArrayList<>();

        int last = nums[0];
        int li = 0;
        for (int i=1;i<nums.length;i++){

        }
        /////////////
        // WA
        // int p0 = nums.length-1;
        // // int p1 = 0;
        // int last = nums[p0];
        // // int s = 0;
        // int res = 0;
        // for (int i=p0;i>0;i--){
        //     if (nums[i-1]>nums[i]){
        //         res = Math.max(res, last-i);
        //         last = i-1;
        //     }                
        // }
        // return res;
        ///////////////
        // TLE
        // int n = nums.length;
        // int s = -1;
        // int res = -1;
        // while (s!=0){
        //     res++;            
        //     s = 0;
        //     int p0 = 0;
        //     int p1 = 1;
        //     for (p1 = 1;p1<n;p1++){
        //         if (nums[p1]<nums[p1-1]){
        //             s++;
        //         }else{
        //             p0++;
        //             nums[p0] = nums[p1];
        //         }
        //     }
        //     n -= s;
        // }
        // return res;
    }
    public static void main(String[] args) {
        var s = new Solution();
        var nums = new int[]{
            5,3,4,4,7,3,6,11,8,5,11
        };
        s.totalSteps(nums);
    }
}