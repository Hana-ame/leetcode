import java.util.*;

class Solution{
    public int cherryPickup(int[][] grid) {
        
        var A0 = grid.length;
        var A1 = grid[0].length;
        
        int [][] m = new int[A0][A1];
        
        for (int i0=0;i0<A0;i0++)
        for (int i1=0;i1<A1;i1++){
            if ((i0|i1)==0){
                m[i0][i1] = grid[0][0];
                continue;
            }
            if (grid[i0][i1]==-1){
                m[i0][i1] = -1;
                continue;
            }
            int max = -1;
            if (i0>0)
                max = Math.max(m[i0-1][i1], max);
            if (i1>0)
                max = Math.max(m[i0][i1-1], max);
            if (max>=0)
                m[i0][i1] = grid[i0][i1]+max;
            else
                m[i0][i1] = -1;
        }

        int res = m[A0-1][A1-1];
        if (res == -1) return -1;
        
        var p0 = A0-1;
        var p1 = A1-1;
        while (p0>0 && p1>0){
            grid[p0][p1] = 0;
            if (m[p0-1][p1]>m[p0][p1-1])
                p0--;
            else
                p1--;
        }
        for(int ip=0; ip<=p0; ip++)
            grid[ip][p1] = 0;
        for(int ip=0; ip<=p1; ip++)
            grid[p0][ip] = 0;

        m = new int[A0][A1];
        
        for (int i0=0;i0<A0;i0++)
        for (int i1=0;i1<A1;i1++){
            if ((i0|i1)==0){
                m[i0][i1] = grid[0][0];
                continue;
            }
            if (grid[i0][i1]==-1){
                m[i0][i1] = -1;
                continue;
            }
            int max = -1;
            if (i0>0)
                max = Math.max(m[i0-1][i1], max);
            if (i1>0)
                max = Math.max(m[i0][i1-1], max);
            if (max>=0)
                m[i0][i1] = grid[i0][i1]+max;
            else
                m[i0][i1] = -1;
        }

        return res + m[A0-1][A1-1];
        
        
    }
    

    public static void main(String[] args) {
        var so = new Solution();
        var grid = new int [][]
        {{1,1,1,1,0,0,0},{0,0,0,1,0,0,0},{0,0,0,1,0,0,1},{1,0,0,1,0,0,0},{0,0,0,1,0,0,0},{0,0,0,1,0,0,0},{0,0,0,1,1,1,1}}
        ;
        so.cherryPickup(grid);


        return; 
    }
}