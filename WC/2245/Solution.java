import java.util.*;

class Solution {
    public int maxTrailingZeros(int[][] grid) {
        int x = grid.length;
        int y = grid[0].length;
        
        int [][] f2a = new int [x][y];
        int [][] f5a = new int [x][y];
        for (int ix=0; ix<x; ix++) // for all lines
            for (int iy=0; iy<y; iy++){ // for each value
                for (int v=grid[ix][iy]; v>0 && v%2==0; v/=2) // 2^?
                    f2a[ix][iy]++;
                for (int v=grid[ix][iy]; v>0 && v%5==0; v/=5) // 5^?
                    f5a[ix][iy]++;
            }

        int [][] f2l = new int [x][y];
        int [][] f5l = new int [x][y];
        int [][] f2r = new int [x][y];
        int [][] f5r = new int [x][y];

        for (int ix=0; ix<x; ix++){ // for all lines
            // int t2 = 0;
            // int t5 = 0;
            f2l[ix][0] = f2a[ix][0];
            f5l[ix][0] = f5a[ix][0];
            for (int iy=1; iy<y; iy++){ // for each value
                // for (int v=grid[ix][iy]; v>0&&v%2==0; v/=2){ // 2^?
                //     t2++;
                // }
                // for (int v=grid[ix][iy]; v>0&&v%5==0; v/=5){ // 5^?
                //     t5++;
                // }
                f2l[ix][iy] = f2a[ix][iy]+f2l[ix][iy-1];
                f5l[ix][iy] = f5a[ix][iy]+f5l[ix][iy-1];
            }
            // t2=0;
            // t5=0;
            f2r[ix][y-1] = f2a[ix][y-1];
            f5r[ix][y-1] = f5a[ix][y-1];
            for (int iy=y-2; iy>=0; iy--){ // for each value
                // for (int v=grid[ix][iy]; v>0&&v%2==0; v/=2){ // 2^?
                //     t2++;
                // }
                // for (int v=grid[ix][iy]; v>0&&v%5==0; v/=5){ // 5^?
                //     t5++;
                // }
                // f2r[ix][iy] = t2;
                // f5r[ix][iy] = t5;
                f2r[ix][iy] = f2a[ix][iy]+f2r[ix][iy+1];
                f5r[ix][iy] = f5a[ix][iy]+f5r[ix][iy+1];
            }
        }
        
        int res = 0;
        int [] f2 = new int [y];
        int [] f5 = new int [y];
        for (int ix = 0; ix<x; ix++){ // for each line
            for (int iy=0; iy<y; iy++){
                res = 
                    Math.max(
                        Math.max( // 最大的0的个数
                            Math.min(f2[iy]+f2l[ix][iy],f5[iy]+f5l[ix][iy]), // 0的个数
                            Math.min(f2[iy]+f2r[ix][iy],f5[iy]+f5r[ix][iy])
                        ),
                        res
                    );
                f2[iy]+=f2a[ix][iy];
                f5[iy]+=f5a[ix][iy];
            }
        }
        f2 = new int [y];
        f5 = new int [y];
        for (int ix = x-1; ix>=0; ix--){ // for each line
            for (int iy=0; iy<y; iy++){
                res = 
                    Math.max(
                        Math.max( // 最大的0的个数
                            Math.min(f2[iy]+f2l[ix][iy],f5[iy]+f5l[ix][iy]), // 0的个数
                            Math.min(f2[iy]+f2r[ix][iy],f5[iy]+f5r[ix][iy])
                        ),
                        res
                    );
                f2[iy]+=f2a[ix][iy];
                f5[iy]+=f5a[ix][iy];
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        // var grid  = new int[][]{{23,17,15,3,20},{8,1,20,27,11},{9,4,6,2,21},{40,9,1,10,6},{22,7,4,5,3}};
        var grid  = new int[][]{{1,5,2,4,25}};
        s.maxTrailingZeros(grid);
    }
}