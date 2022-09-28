class Solution {
    static int[] m;
    static{
        // int[] m = new int[1000];
        int[] dp = new int[648+1];
        dp[1] = 1;
        int p3 = 1, p5 = 1, p7 = 1;
        for (int i = 2; i < dp.length; i++) {
            int num3 = dp[p3] * 3, num5 = dp[p5] * 5, num7 = dp[p7] * 7;
            dp[i] = Math.min(Math.min(num3, num5), num7);
            if (dp[i] == num3) {
                p3++;
            }
            if (dp[i] == num5) {
                p5++;
            }
            if (dp[i] == num7) {
                p7++;
            }
        }
        // return dp[k];      
        m = dp;
    }
    
    public int getKthMagicNumber(int k) {
        return m[k];
        // return dp[k]; //error

        // TreeSet<Long> s = new TreeSet<>();
        // long f = 1;
        // s.add(f);
        // for (int i=0; i<k; i++){
        //     f = s.first();
        //     s.add(f*3);
        //     s.add(f*5);
        //     s.add(f*7);
        //     s.remove(f);
        // }
        // return (int)f;
    }
}

/*

1 3 5 7
  3 


 */
