import java.util.*;

class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int r = arr.length-1;
        for (; r!=0 && arr[r-1]<=arr[r]; r--);
        if (r == 0) return 0;
        
        int ans = r;
        int l = 0;
        int left = 0;
        for (; arr[left] <= arr[left+1]; left++);
        for (; l <= left  && r < n;) { // 枚举 l
            if (arr[l] <= arr[r]) {
                ans = Math.min(r-l-1, ans);
                l++;    
            }else{
                r++;
            }            
            
        }
        ans = Math.min(arr.length-left-1, ans);

        return ans;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int [] arr = new int[]{10,13,17,21,15,15,9,17,22,22,13};
        solution.findLengthOfShortestSubarray(arr);
    }
}

