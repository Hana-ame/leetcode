import java.util.*;

class Solution {
    public int countLatticePoints(int[][] circles) {
        Set<Integer> ps = new HashSet<>();
        for (int[] c : circles){
            setc(c,ps);
        }
        return ps.size();
    }
    private void setc(int [] c, Set<Integer> ps){
        int d2 = c[2]*c[2];
        int r = Math.min(c[0], c[1]);
        for (int x=-r; x<=r; x++)
            for (int y=-r; y<=r; y++){                
                if (dist(x, y) <= d2){
                    int xx = c[0]+x;
                    int yy = c[1]+y;
                    ps.add(hash(xx,yy));
                }
            }        
    }

    private int hash(int x, int y){
        return x*1000+y;
    }
    private int dist(int x, int y){
        return x*x+y*y;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        s.countLatticePoints(new int[][]{{2,2,2},{3,4,1}});
    }
}