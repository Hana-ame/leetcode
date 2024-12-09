class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int [] m = new int [2001];
        int all = 0;
        int res = 0;
        for(int n: nums){
            if (m[n] == 0)  all++;
            m[n]++;
        }
        m = new int[2001];
        int now = 0;
        int l = 0;
        int r = 0;
        for(; r<nums.length; r++){
            
            if (m[nums[r]] == 0) now++;
            m[nums[r]]++;
            
            for (;now == all;l++) {
                res += (nums.length - r);    
                m[nums[l]]--;
                if (m[nums[l]] == 0) now--;                
            }
            
        }
        
        return res;
    }
}