import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

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
        
        // Queue<Integer> q = new PriorityQueue<Integer>();
        System.out.println(s.findMinArrowShots(a));
    }
}