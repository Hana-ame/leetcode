import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int []>() {
            // @Override
            public int compare(int [] a, int [] b){
                // if (a[0]  ==  (b[0])){
                //     return a[1] - b[1];
                // }
                return a[0] - b[0];
            }
        });
        // 初始化
        int res = 1;
        // int len = 1;
        int lasti = 0;//points[0][0];
        Queue<Integer> queue = new PriorityQueue<Integer>();
        queue.add(points[0][1]);
        for (int i=1; i<points.length; i++){
            // System.out.println(i[0]+","+i[1]);
            // if (points[i][0] != lasti){
                lasti = points[i][0];
                queue.add(points[i][1]);
                while (!queue.isEmpty() && queue.peek() < lasti){
                    queue.poll();
                    // len--;
                }
                if (res < queue.size()) res = queue.size();

            // }

        }


        return res;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int [][] a  = {{10,16},{2,8},{1,6},{7,12}};
        
        // Queue<Integer> q = new PriorityQueue<Integer>();
        System.out.println(s.findMinArrowShots(a));
    }
}