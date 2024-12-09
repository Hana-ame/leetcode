import java.util.*;
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
// int [] memo = new int[n+1];
ArrayList<Integer>[] m = new ArrayList[n+1];
for (int i=0; i<n; i++){
    m[i] = new ArrayList<>();
}
for (int [] e :edges){
    m[e[0]].add(e[1]);
    m[e[1]].add(e[0]);
}
ArrayList<Integer> res = new ArrayList<>();
HashSet<Integer> vis = new HashSet<>();
HashSet<Integer> ths = new HashSet<>();
HashSet<Integer> nxt = new HashSet<>();
for (int i=0; i<n; i++){
    if (m[i].size() == 1){
        ths.add(i);
        // vis.add(i);
        res.add(i);
    }
        
}

while (vis.size()<n){
    res.clear();
    // 加入下一组
    for (int i:ths){
        vis.add(i);
        res.add(i);
        for ( int j : m[i]){
            if (vis.contains(j)) continue;
            nxt.add(j);
        }
    }
    ths = nxt;
    nxt = new HashSet<>();
}
return res;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        s.findMinHeightTrees(4, new int[][]{{1,0},{1,2},{1,3}});
    }
}