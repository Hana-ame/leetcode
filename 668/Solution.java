class Solution {
    public int findKthNumber(int m, int n, int k) {
        int l = 0;
        int r = m*n;
        while (l<r){
            int mid = (l+r)/2;
            var h = help(mid,m,n);
            if (h < k){
                l = mid+1;
            }else{
                r = mid;
            }
        }
        return l;
    }
    private int help(int mid, int m, int n){
        int res = 0;
        for (int i = 1; i<=m; i++){
            res += Math.min(
                mid/i
                ,n
            );
        }
        return res;
    }
    public static void main(String[] args) {
        var s = new Solution();
        s.findKthNumber(3,3,5);
    }
}