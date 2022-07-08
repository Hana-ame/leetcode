import java.util.*;

class Solution{
    long [][] mem;
    public long sellingWood(int m, int n, int[][] prices) {
        mem = new long[m+1][n+1];
        for (var p : prices){
            mem[p[0]][p[1]] = p[2];
        }
        if (mem[1][1] == 0) mem[1][1] = -1;
        return solve(m,n);
    }
    public long solve(int m, int n) {
        if (m==0 || n==0) return 0;
        if (mem[m][n] == -1) return 0;
        if (mem[m][n] > 0) return mem[m][n];
        long r = 0;

        for (int i=0; i<=m/2; i++){
            r = Math.max(r, solve(i,n) + solve(m-i,n));
        }
        for (int i=0; i<=n/2; i++){
            r = Math.max(r, solve(m,i) + solve(m,n-i));
        }
        mem[m][n] = r;
        if (r == 0) 
            mem[m][n] = -1;
        return r;
    }
    

    public static void main(String[] args) {
        var so = new Solution();

        so.sellingWood(4,2, new int[][]{{1,1,20}});

        return; 
    }
}