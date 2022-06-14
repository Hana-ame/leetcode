import java.util.Arrays;

class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int r = nums[nums.length-1] - nums[0];
        int l = 0;
        while(l<=r){
            int m = (l+r)/2;
            int c = cnt(nums,m);
            if (c < k)
                l = m+1;
            else
                r = m-1;
        }
        return l;
    }
    // public int smallestDistancePair(int[] nums, int k) {
    //     Arrays.sort(nums);
    //     int n = nums.length, left = 0, right = nums[n - 1] - nums[0];
    //     while (left <= right) {
    //         int mid = (left + right) / 2;
    //         int cnt = 0;
    //         for (int i = 0, j = 0; j < n; j++) {
    //             while (nums[j] - nums[i] > mid) {
    //                 i++;
    //             }
    //             cnt += j - i;
    //         }
    //         if (cnt >= k) {
    //             right = mid - 1;
    //         } else {
    //             left = mid + 1;
    //         }
    //     }
    //     return left;
    // }
    // 统计有多少个
    private int cnt(int[] nums, int key){
        int res=0;
        int l=0;
        for (int r=1;r<nums.length;r++){
            while(nums[r]-nums[l]>key)
                l++;
            res+=r-l;
        }
        return res;
    }
    public static void main(String[] args) {
        var s = new Solution();
        var nums = new int[]{
            38,33,57,65,13,2,86,75,4,56
            
        };
        var k = 26;
        s.smallestDistancePair(nums, k);
    }
}