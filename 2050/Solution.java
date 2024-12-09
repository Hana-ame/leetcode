import java.util.*;

class Solution {
    class Node {
        int indegree = 0;
        ArrayList<Node> childs = new ArrayList<>();
        int startTime = 0;
        int costTime = 0;
        int res = -1;
        Node(int time){
            costTime = time;
        }
        public void addChild(Node child){
            childs.add(child);
            child.indegree++;
        }
        public int deleteNode(){
            if (indegree>0) return -1;
            if (res > -1) return res;
            int endTime = startTime + costTime;
            res = endTime;
            for(Node c: childs){
                c.startTime = Math.max(c.startTime, endTime);
                c.indegree--;
                res = Math.max (res, c.deleteNode());
            }
            return res;
        }
    }
    public int minimumTime(int n, int[][] relations, int[] time) {
        int ans = 0;
        
        Node[] nodes = new Node[n];
        for(int i=0;i<n;i++){
            nodes[i] = new Node(time[i]);
        }
        // build graph
        for (int [] r: relations) {
            nodes[r[0]-1].addChild(nodes[r[1]-1]); // 有向图
        }
        
        for(int i=0; i<n; i++){
            ans = Math.max(ans, nodes[i].deleteNode());
        }
        return ans;
    }
}