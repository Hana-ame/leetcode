import java.util.*;

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        class Cls {
            int pass;
            int total;
            Cls (int _pass, int _total) {
                pass = _pass;
                total = _total;
            }
            public double diff() {
                return ((double)(pass+1))/(total+1) - ((double)(pass))/total;
            }
            public Cls add() {
                pass += 1;
                total += 1;
                return this;
            }
        }
        double r = 0;
        PriorityQueue<Cls> pq = new PriorityQueue<>(
            (a, b) -> {
                return -Double.compare( a.diff() , b.diff() );
            }
        );
        for (int[] cls : classes) {
            r += ((double)(cls[0]))/cls[1];
            pq.add(new Cls(cls[0],cls[1]));
        }
        // r /= classes.length;

        for (int i=0; i<extraStudents; i++) {
            Cls c = pq.poll();
            r += c.diff();
            pq.add(c.add());
        }
        
        r /= classes.length;

        return r;
    }

    public static void main(String[] args) {
        int[][] classed = new int[][]{
            {1,2}, {3,5}, {2,2}
        };
        int extraStudents = 2;

        Solution so = new Solution();
        so.maxAverageRatio(classed, extraStudents);
    }
}