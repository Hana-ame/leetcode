import java.text.ParseException;
import java.util.*;
class Solution {
    int res = 1;
    List<Integer> [] m;
    int [] parent;
    String s;
    public int longestPath(int[] parent, String s) {
        this.parent = parent;
        this.s = s;
        // int res = 0;
        // 建图
        m = new List[parent.length];
        for (int i=0; i<parent.length; i++)
            m[i] = new ArrayList<Integer>();
        for (int i=1; i<parent.length; i++)
            m[parent[i]].add(i);
        // 从纯叶子节点开始从下往上遍历 BFS
        bfs(0);
        // 保存每个节点下属的最长路径，+1，返回
        // 并且下属的两个最长路径和当前路径相加找到通过当前节点的最大长度


        return res;
    }
    private int bfs(int n){
        int maxPath = 0;

        for (int i : m[n]){
            int path = bfs(i);
            res = Math.max(res, path+maxPath+1);
            maxPath = Math.max(maxPath, path);
        }

        if (n==0 || s.charAt(parent[n]) == s.charAt(n))
            return 0;
        return maxPath+1;
    }
    public static void main(String[] args) {
        Solution slt = new Solution();
        int [] p = {-1,0,0,1,2,2};
        String s = "abacbe";
        slt.longestPath(p, s);
    }
}