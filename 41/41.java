// 2ms 96.1MB
class Solution {
    public int firstMissingPositive(int[] nums) {
        // int t;
        int n = nums.length;
        for (int i = 0; i<n; i++){
            int numsi = nums[i];
            if (numsi <= 0 || numsi >= n || numsi == i+1) continue;
            if (swap(i , --numsi , nums))
                i--;
        }
        // for (int i : nums)
        //     System.out.print(i);
        // System.out.println();
        for (int i = 0; i<n; ){
            if (nums[i++] != i) return i; // 故意的
        }
        return n+1;
    };
    private boolean swap(int i, int j, int[] nums){
        if (nums[i] == nums[j]) return false;        
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return true;
    }
}