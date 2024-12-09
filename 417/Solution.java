import java.util.*;

class Solution {
    List<List<Integer>> res;
    int [][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    int [][] memo;
    int [][] heights;
    int A0;
    int A1;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // 只从传输到更大的部分
        A0 = heights.length;
        A1 = heights[0].length;
        memo = new int [A0][A1];
        this.heights = heights;
        res = new ArrayList<List<Integer>>();
    
        for (int i=0; i<A0; i++)
            dfsp(i,0);
        for (int i=0; i<A1; i++)
            dfsp(0,i);
        for (int i=0; i<A0; i++)
            dfsa(i,A1-1);
        for (int i=0; i<A1; i++)
            dfsa(A0-1,i);
        
        return res;
    }
    public void dfsp(int x, int y){
        if ((memo[x][y]&1) == 1) return;
        memo[x][y] |= 1;
        for (int[] d : dirs){
            int xx = x+d[0];
            int yy = y+d[1];
            if (xx<0||xx>=A0||yy<0||yy>=A1) continue;
            if (heights[xx][yy] >= heights[x][y]){                
                dfsp(xx,yy);
            }
        }
    }
    public void dfsa(int x, int y){
        if ((memo[x][y]&2) == 2) return;
        memo[x][y] |= 2;
        if (memo[x][y] == 3){
            addRes(genPair(x,y));
        }
        for (int[] d : dirs){
            int xx = x+d[0];
            int yy = y+d[1];
            if (xx<0||xx>=A0||yy<0||yy>=A1) continue;
            if (heights[xx][yy] >= heights[x][y]){                
                dfsa(xx,yy);
            }
        }
    }

    public List<Integer> genPair(int a, int b){
        List<Integer> t = new ArrayList<Integer>();
        t.add(a);
        t.add(b);
        return t;
    }
    public void addRes(List<Integer> o){
        res.add(o);
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        var heights = new int[][]{{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        s.pacificAtlantic(heights);
    }
}