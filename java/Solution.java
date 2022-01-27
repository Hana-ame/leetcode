import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


class Solution {
    // char [] ccs = {'1','2','3','4','5','6','7','8','9'};
    public String getPermutation(int n, int k) {
        char [] cs = new char [n];
        for (char i = 0; i<n ; i++){
            cs[i] = (char)(i+'1');
        }
        k--;
        for (int i = 0; i<n; i++){
            int t = k / fact(n-i-1);
            k = k % fact(n-i-1);
            
            // 第 t 位提前，轮换
            char ct = cs[t+i];
            for (int tt = t+i; tt > i; tt--){
                cs[tt] = cs[tt-1];
            }
            cs[i] = ct;
            
        }
        return new String(cs);
        
    }
    public int fact(int n){
        int r = 1;
        for (;n>=1;n--){
            r *= n;
        }
        return r;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        s.getPermutation(3,3);
    }
}

/*
class Solution {
   
        public int findMinArrowShots(int[][] points) {
            Arrays.sort(points, (a,b)->compare(a,b)); // 以结束为序列排序
            int ans = 0, arrow = 0;
            for (int i = 0; i < points.length; i ++) {
                System.out.println(points[i][0]+","+points[i][1]);
                if (ans == 0 || points[i][0] > arrow) { // 没arrow(初始)或者 开始位置>arrow
                    ans ++;
                    arrow = points[i][1]; // 把arrow送到结尾
                }
            }
            return ans;
        }
    
        private static int compare(int[]a,int[]b){
            return a[1] - b[1];
        }
    public static void main(String[] args) {
        Solution s = new Solution();
        int [][] a  = {{10,16},{2,8},{1,6},{7,12}};
        
        
        System.out.println(s.findMinArrowShots(a));

        Queue<Integer> q = new PriorityQueue<Integer>();
        System.out.println(q.poll());
    }
}*/