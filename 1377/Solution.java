import java.util.*;

class Solution {
    ArrayList<Integer>[] nodes;
    // int[]
    public double frogPosition(int n, int[][] edges, int t, int target) {
        // ArrayList<Integer>[] 
        nodes = new ArrayList[n+1];
        for(int i=0; i<=n; i++) {
            nodes[i] = new ArrayList<>();
        }
        for(int [] edge : edges) {
            nodes[edge[0]].add(edge[1]);
            nodes[edge[1]].add(edge[0]);
        }
        nodes[0].add(1);
        nodes[1].add(0);

        double ans =  frogPosition(0, 1, t, target, 1.0);
        if(ans > 1.5) return 0;
        return ans;
    }
    public double frogPosition(int previous, int present, int t, int target, double amount) {
        int childCnt = nodes[present].size() - 1;
        if (target == present) {
            if (childCnt == 0 || t == 0) return amount;
            else return 2.0;
        }
        if (t == 0) return 0;
        double childAmount = amount / childCnt;
        for(int i : nodes[present]) {
            if ( i == previous ) continue;
            double ans = frogPosition(present, i, t-1, target, childAmount);
            if (ans > 0) return ans;
        }
        return 0;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.frogPosition(3, new int[][]{{2,1},{3,2}}, 1, 2);
    }
}

