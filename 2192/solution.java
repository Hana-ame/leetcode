import  java.util.*;

class Solution {

    ArrayList<List<Integer>> res;
    ArrayList<Integer>[] ns;
    boolean[][] rs;
    int len;

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        len = n;
        res = new ArrayList<>();
        ns = new ArrayList[n];
        rs = new boolean[n][n + 1];

        for (int i = 0; i < n; i++) {
            ns[i] = new ArrayList<Integer>();
            // Arrays.fill(rs[i],-1);
        }

        // 反着方向，图
        for (int[] e : edges) {
            ns[e[1]].add(e[0]);
        }

        for (int i = 0; i < n; i++) {
            boolean[] r = dfs(i);
            ArrayList<Integer> t = new ArrayList<Integer>();
            for (int k = 0; k < len; k++) {
                if (r[k])
                    t.add(k);
            }
            res.add(t);
        }

        return res;

    }

    private boolean[] dfs(int x) {
        if (rs[x][len])
            return rs[x];

        ArrayList<Integer> n = ns[x];// 图
        for (int i = 0; i < n.size(); i++) {            
            int j = n.get(i); // 下一个节点
            rs[x][j] = true;
            boolean[] r = dfs(j);
            for (int k = 0; k < len; k++) {
                rs[x][k] |= r[k];
            }
        }
        rs[x][len] = true;
        return rs[x];
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        s.getAncestors(8, new int[][]{{0,3},{0,4},{1,3},{2,4},{2,7},{3,5},{3,6},{3,7},{4,6}});
    }
}