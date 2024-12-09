import java.util.*;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    public long maxKelements(int[] nums, int k) {
        long r = 0;
        int cnt = 0; int end = nums.length;
        for (int i = end/2+1; i>=0; i--)
            maxHeapfy(nums, i, end);

        while (cnt < k) {
            r += nums[0];
            if (nums[0] % 3 == 0) nums[0] /= 3;
            else { nums[0]/=3; nums[0]++; }
            maxHeapfy(nums, 0, end);
            cnt++;
        }
        return r;
    }
    public void swap(int[] nums, int a, int b){
        // System.out.println(a + "<->" + b);
        // System.out.println(nums[a] + "<->" + nums[b]);
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
    public void maxHeapfy(int[] nums, int start, int end){
        if (start >= end) return Integer.MIN_VALUE;
        int right = start*2+2;
        int left = start*2+1;
        if (right >= end) {
            if (left >= end) {
                return;
            } else {
                if (nums[start] < nums[left]) {
                    swap(nums, start, left);
                    maxHeapfy(nums, left, end);
                }
            }
        } else {
            if (nums[left] > nums[right]) {
                if (nums[start] < nums[left]) {
                    swap(nums, start, left);
                    maxHeapfy(nums, left, end);
                }
            } else {
                if (nums[start] < nums[right]) {
                    swap(nums, start, right);
                    maxHeapfy(nums, right, end);
                }
            }
        }
        // swap 之后，
    }
}

