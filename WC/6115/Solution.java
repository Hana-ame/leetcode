import java.util.*;
class Solution {
    long MOD = 1000000000+7;
    // long [] f = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, MOD};
    ArrayList<Integer> fa;
    long [][] c = new long[11000][21];
    // int [][] m;
    public ArrayList<Integer> gen(int n){
        ArrayList<Integer> f = new ArrayList<>();
        boolean [] m = new boolean[n+1];
        m[0]=true;
        m[1]=true;
        for (int i=2; i<=n; i++){
            if (!m[i]) {
                f.add(i);                
            }
            for(var fv:f){
                if (i*fv>n) break;
                m[i*fv] = true;
            }
        }
        return f;
    }
    public int idealArrays(int n, int maxValue) {
        fa = gen(10001);
        c[0][0] = 1;
        for (int i = 1; i < 11000; ++i) {
            c[i][0] = 1;
            for (int j = 1; j <= Math.min(i, 20); ++j)
                c[i][j] = (c[i - 1][j] + c[i - 1][j - 1]) % MOD;
        }
        long res = 1;
        for (int i=2; i<=maxValue; i++){
            int ii = i;
            long r = 1;
            for (int f : fa){
                int cnt = 0;
                while (ii%f==0){
                    ii /= f;
                    cnt++;
                }
                if (cnt == 0) continue;
                // r *= Cmod1e9_7(n-1+c, c);
                r *= c[n-1+cnt][cnt];
                r %= MOD;
                if (ii==1) break;
            }
            res += (r % MOD);
            res %= MOD;
        }
        return (int)res;
    }

    public long Cmod1e9_7(int n , int k){
        long r = 1;
        for(int i=0; i<k; i++){
            r = r * (n-i) / (i+1);
            // r %= MOD;
        }
        r %= MOD;
        return r;
    }
    public static void main(String[] args) {
        var so = new Solution();

        var r = so.idealArrays(2747,5003);
        System.out.println(r);
        return; 
    }
}