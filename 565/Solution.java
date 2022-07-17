class Solution {
    // int [] m;
    public int arrayNesting(int[] nums) {
        int r = 0;
        // m = new int [nums.length];
        for(int i=0; i<nums.length; i++){
            // m[i] = s(nums, i);
        // }
        // for (var i : nums)
            r = Math.max(r,s(nums, i));
        }
        return r;
    }
    public int s(int[] nums, int i){
        // if (m[i] > 0) return m[i];
        // if (i == nums[i]) return m[i]=1;
        // m[i] = -1;
        // return m[i]=s(nums, nums[i])+1;
        boolean [] m = new boolean [nums.length];
        int r = 0;
        while(!m[i]){
            m[i] = true;
            r++;
            i = nums[i];
        }
        return r;
    }
    public static void main(String[] args) {
        Solution so = new Solution();
        var nums = new int[]{
            5,4,0,3,1,6,2
        };
        var r = so.arrayNesting(nums);
        System.out.println(r);
    }
}