import java.util.*;

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        PriorityQueue<int[]> pqS = new PriorityQueue<>((a,b)->{
            return a[0]-b[0];
        });
        PriorityQueue<int[]> pqE = new PriorityQueue<>((a,b)->{
            return a[0]-b[0];
        });
        for(int i=0;i<n;i++){
            pqS.add(new int[]{intervals[i][0],i});
            pqE.add(new int[]{intervals[i][1],i});
        }
        int [] res = new int[n];
        while(!pqE.isEmpty()){
            int[] e = pqE.poll();
            int[] s = pqS.peek();
            while (s!=null&&s[0]<e[0]){
                s = pqS.poll();
                s = pqS.peek();
            }
            if (s==null){
                res[e[1]] = -1;
            }else{
                res[e[1]] = s[1];
            }
        }
        return res;
    }
    public static void main(String[] args) {
        var s = new Solution();
        var intervals = new  int[][]
        {{1,12},{2,9},{3,10},{13,14},{15,16},{16,17}}
        ;
        s.findRightInterval(intervals);
    }
}