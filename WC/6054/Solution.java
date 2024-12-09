import java.util.*;
class Solution {
    ArrayList<int []> fires;
    int [][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
    public int maximumMinutes(int[][] grid) {
        var x = grid.length;
        var y = grid[0].length;
        int [][] fire = new int[x][y];
        int [][] men = new int[x][y];
        fires = new ArrayList<>();
        for (int ix = 0; ix<x; ix++)
            for (int iy=0; iy<y; iy++){
                if (grid[ix][iy] == 1){
                    fire[ix][iy] = 1;
                    fires.add(new int[]{ix,iy});
                }else if (grid[ix][iy] == 2){
                    men[ix][iy] = -1;
                    fire[ix][iy] = -1;
                }             
                
            }    
        // 初始化 men格子，fire格子
        // 然后开始bfs
        bfs(fire, fires);
        ArrayList<int []> mmmm = new ArrayList<>();
        mmmm.add(new int[]{0,0});
        men[0][0] = 1;
        bfs(men,mmmm);
        // 0942 得到格子之后dfs寻找通过世间最短
        // var res = new int [x][y];
        // dfs(men,fire,res,x,y,0,0,1000000000);
        // return res[x-1][y-1];
        // 1012 草不用？直接返回最后一个单元格的减法-1
        // men人的进度
        // fire火的进度
        // System.out.println("  "+men[x-1][y-1]);
        // System.out.print("  "+men[x-1][y-1]);
        
        int fff = fire[x-1][y-1];
        int mmm = men[x-1][y-1];
        if (mmm == 0) return -1;
        if (fff == 0) return 1000000000;
        // if (fff>mmm) return fff-mmm-1;
        if (fff<mmm) return -1;
        // fff>=mmm 火到达时间，人到达时间
        int sub1 = fire[x-2][y-1] - men[x-2][y-1];
        int sub2 = fire[x-1][y-2] - men[x-1][y-2];
        int res = 10000;
        if (sub1>sub2)
            res = Math.min(res, sub1-1);
        else 
            res = Math.min(res, sub2-1);
        res = Math.min(res, fff-mmm);
        return res;    

        // if (fire[x-1][y-1]==0) return 1000000000;
        // int subs = fire[x-1][y-1]-men[x-1][y-1];
        // if (subs < 0)  return -1;
        // if (subs == 0){
        //     if (x>1 && fire[x-2][y-1]!=-1 && fire[x-2][y-1]==men[x-2][y-1])
        //         if (y>1 && fire[x-1][y-2]!=-1 && fire[x-1][y-2]==men[x-1][y-2])
        //             return -1;
            
        //     return 0;            
        // }
        // return subs;
        
    }
    public void dfs(int [][] men, int [][] fire, int[][] memo, int X, int Y){        
             

        // return res;
    }
    public void dfs(int [][] men, int [][] fire, int[][] memo, int X, int Y, int x, int y, int c){        
        if (x<0||y<0||x>=X||y>=Y) return;
        if (men[x][y] == -1) return; // 撞墙。
        if (men[x][y] >= fire[x][y]) return; // 撞火

        for (var d:dirs){

        }
            

        // return res;
    }

    public void bfs(int[][] fire, ArrayList<int []> fires){
        int [][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
        ArrayList<int []> pre = new ArrayList<>();
        ArrayList<int []> thi = new ArrayList<>();
        for (var a:fires){
            thi.add(a);
        }
        int iii = 1;
        for (;thi.size()>0;){
            iii++;
            pre = thi;
            thi = new ArrayList<>();
            for (var pos : pre){
                for (var d:dirs){
                    int xx = pos[0]+d[0];
                    int yy = pos[1]+d[1];
                    if (xx<0||yy<0||xx>=fire.length||yy>=fire[0].length) continue;
                    if (fire[xx][yy] == 0){
                        fire[xx][yy] = iii;
                        thi.add(new int[]{xx,yy});
                    }
                        
                }
            }
        }
    }
 
    public static void main(String[] args) {
        Solution s = new Solution();
        var grid = new int[][]{{0,0,0,0,0},{0,2,0,2,0},{0,2,0,2,0},{0,2,1,2,0},{0,2,2,2,0},{0,0,0,0,0}};
        grid = new int[][]{{0,2,0,0,0,0,0},{0,0,0,2,2,1,0},{0,2,0,0,1,2,0},{0,0,2,2,2,0,2},{0,0,0,0,0,0,0}};  System.out.println(s.maximumMinutes(grid));
        grid = new int[][]{{0,0,0,0},{0,1,2,0},{0,2,0,0}};  System.out.println(s.maximumMinutes(grid));
        grid = new int[][]{{0,0,0},{2,2,0},{1,2,0}};  System.out.println(s.maximumMinutes(grid));
        grid = new int[][]{{0,2,0,0,1},{0,2,0,2,2},{0,2,0,0,0},{0,0,2,2,0},{0,0,0,0,0}};  System.out.println(s.maximumMinutes(grid));
        grid = new int[][]{{0,2,1,1,0},{1,2,0,0,1},{2,2,1,1,0}};  System.out.println(s.maximumMinutes(grid));
        grid = new int[][]{{0,0,2,2,1,1,0,2,1,1,2,2,0,2,2,1,2,0,1,2,2,0,1,2,2,1,2,2},{2,2,2,1,1,2,2,1,2,0,1,1,1,2,2,1,1,0,2,2,2,0,1,0,1,2,2,2},{0,0,1,1,0,1,2,0,1,1,1,1,0,2,0,2,0,2,1,1,0,2,1,2,2,2,1,2},{2,2,0,0,0,0,1,0,1,0,2,0,1,0,2,0,0,1,2,1,0,1,1,1,2,0,2,0},{2,2,1,1,1,1,1,0,0,0,0,2,0,1,1,1,1,2,0,2,1,1,2,0,2,0,2,0},{0,1,0,1,2,2,2,0,2,0,2,2,1,2,0,0,1,0,2,0,2,0,1,2,2,0,2,0},{1,0,2,2,2,0,2,0,2,0,2,0,1,0,2,2,0,2,1,1,1,0,1,0,1,1,0,0},{0,1,2,0,1,0,1,0,2,1,2,0,1,1,1,1,0,1,1,0,0,2,0,1,0,1,0,2},{2,1,1,0,1,1,2,2,1,2,2,1,0,1,0,0,0,2,1,0,2,2,1,2,1,2,0,1},{1,1,2,0,2,2,1,2,0,2,1,1,0,0,0,2,2,2,2,1,2,2,0,2,1,1,2,0},{2,1,2,2,0,0,1,0,1,2,1,0,1,0,2,0,0,1,1,0,2,0,2,0,1,2,2,0},{1,0,1,1,0,0,0,0,0,1,0,2,0,2,1,2,1,1,0,1,0,0,2,1,2,1,0,2},{2,0,1,0,2,0,1,0,2,0,2,1,2,0,2,2,2,1,0,2,1,0,1,2,1,0,1,1},{0,2,2,1,0,2,1,0,1,2,2,1,2,2,1,2,0,1,2,2,0,2,1,0,2,1,0,0},{0,2,2,2,1,2,1,0,0,2,2,0,1,0,2,1,0,0,2,1,1,1,2,1,2,1,0,1},{2,2,2,1,1,1,1,0,2,2,2,1,0,0,2,2,0,0,1,1,0,0,2,1,2,1,2,2},{2,1,2,1,1,1,0,2,1,0,1,1,2,1,0,0,1,1,2,1,2,2,1,2,0,2,0,0}};  System.out.println(s.maximumMinutes(grid));
        grid = new int[][]{{0,0,0,0,0},{0,2,0,2,0},{0,2,0,2,0},{0,2,1,2,0},{0,2,2,2,0},{0,0,0,0,0}};  System.out.println(s.maximumMinutes(grid));
    }
}