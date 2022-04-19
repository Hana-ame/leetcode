class Solution {

    public int findKthNumber(int n, int k) {
        long curr = 1;
        while (k != 1){
            int nums = getCurrNumber(curr, n);
            if (k>nums){
                k-=nums;
                curr++;
            }else{
                curr*=10;
                k--;
            }
        }
        return (int) curr;
    }

    public int getCurrNumber(long curr,int n){
        long res=0; 
        long nxt=curr+1;
        while (curr<=n){
            res += Math.min(n-curr+1, nxt-curr);
            curr*=10;
            nxt *=10;
        }

        return (int) res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.findKthNumber(20000, 9);
    }

}