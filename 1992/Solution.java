import  java.util.*;
class Solution {
    public int[][] findFarmland(int[][] land) {
        PriorityQueue<int []> q1 = new PriorityQueue<>((o1,o2)->{
            if (o1[0]==o2[0])
                return o1[1]-o2[1];
            return o1[0]-o2[0];
        });
        PriorityQueue<int []> q2 = new PriorityQueue<>();

    }
}