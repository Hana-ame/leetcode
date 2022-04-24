import java.util.*;

class Solution {
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        List<Integer>[] m = new List[101];
        for (int i=0; i<=100; i++)
            m[i] = new ArrayList<>();
        for (int [] r : rectangles){
            m[r[1]].add(r[0]); // 加入
        }
        for (int i=0; i<=100; i++)
            m[i].sort((x,y)->Integer.compare(y, x));
        
        
        int [] res = new int[points.length];
        for (int i=0; i<points.length; i++){
            res[i] = search(m, points[i]);
        }
        return res;
    }
    private int search(List<Integer>[] m, int [] p){
        int res = 0;
        for (int i=p[1]; i<=100; i++){
            int t = bs(m[i],p[0])+1;
            res += t ;
        }
        return res;
    }
    private int bs(List<Integer> arr, int key){
        int n = arr.size();
        int l = 0; 
        int r = n-1;
        for (;l<=r;){
            int m = (l+r)/2;
            int t = arr.get(m);
            if (t == key) return m;
            if (key > t) {
                r = m-1;
                // continue;
            }else{ // key < t
                l = m+1;
            }            
        }
        return r;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        var rectangles= new int[][]{{1,2},{2,3},{2,5}};
        var points = new int[][]{{2,1},{1,4}};
        s.countRectangles(rectangles, points);
    }
}