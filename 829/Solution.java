class Solution {
    public int consecutiveNumbersSum(int n) {
        int res = 0;
        // {
        //     int d = 2;
        //     // int i = 0;
        //     while (n%d==0){
        //         d*=2;
        //         // i++;
        //     }
        //     if (n / d - d/2 + 1 > 0)
        //         res++;
        // }
        for(int d=1;true;d++){ // n^{1/2}
            if (d%2==0 && n%d == d>>1){
                int c = (n)/d+1;
                int l = c - d/2;
                if (l>0)
                    res++;
                else 
                    break;
            }else if (d%2!=0 && n/d*d==n){
                int c = n/d;
                int l = c - d/2;
                if (l>0)
                    res++;
                else 
                    break;
            }
            // if (n%d != 0)
            //     if (n/d-d/2>0)
            //         continue;
            //     else
            //         break;
            // int c = n/d;
            // int l = c-d/2;
            // if (l>0)
            //     res++;
            
        }
        return res;
    }
    public static void main(String[] args) {
        var s = new Solution();
        s.consecutiveNumbersSum(4);
    }
}