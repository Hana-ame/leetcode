class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        var g = numsDivide[0];
        for (int i=1; i<numsDivide.length; i++){
            g = gcd(g,numsDivide[i]);
        }
        Arrays.sort(nums);
        for (int i=0; i<nums.length; i++){
            if (g%nums[i]==0) return i;
        }
        return -1;
    }
    // 最小公约数
    public int gcd(int a, int b){
        if (b>a){
            var t = b;
            b = a;
            a = t;
        }
        while(b>0){
            var t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}