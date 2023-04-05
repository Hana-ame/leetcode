import java.util.*;

class Solution {
    int n;
    int k;
    public int[] minReverseOperations(int n, int p, int[] banned, int k) {
        this.n = n;
        this.k = k;
        // bfs
        int [] r = new int[n];
        Arrays.fill(r, -1);
        for (int i = 0; i < banned.length; i++) {
            r[banned[i]] = -2;
        }
        r[p] = 0;

        int e = 0;
        boolean flag = true;
        while(flag){
            flag = false;
            // loop
            for (int i = 0; i < n; i++) {
                if (r[i] == e) {
                    for (int l=i-k+1; l<=i; l++) {
                        int np = flip(i, l, l+k-1);
                        if (np < 0) { continue; }
                        else if (r[np]==-1) {
                            r[np] = e+1;
                            flag = true;
                        }
                    }
                }
            }
            e++;
        }
        // 善后
        for (int i = 0; i < banned.length; i++) {
            r[banned[i]] = -1;
        }
        return r;

    }
    public int flip(int p, int l, int r) {
        // r - l + 1 = k
        if (l<0 || r>=n) return -1;
        return r-(p-l);
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] banned = new int[]{};
        solution.minReverseOperations(5,0,banned,2);
    }
}

