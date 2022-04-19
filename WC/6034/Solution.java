class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int i=0; i<n; i++){
            res += (int)((nums[i]*C(i,n-1)) % 10);
            res %= 10;
        }
        return res;
    }
    private long C(int a, int b){
        a = Math.min(a,b-a);
        long res = 1;
        for (int i=0; i<a; i++){
            res *= b-i;
        }
        for (int i=2; i<=a; i++){
            res /= i;
        }
        // res *= b;
        return res;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.triangularSum(new int[]{0,3,3,4,1,2,6,4,9,3,5,1,7,7,3,0,3,2,5,1,9,0,2,6,3,9,2,5,9,2,6,4,2,9,7,2,0,3,0,1,1,2,7,8,6,4,4,5})); 
        for (int i=0; i<48; i++)
            System.out.println(s.C(i,48-1)); 
    }
}