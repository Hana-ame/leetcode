import java.util.Arrays;

class Solution {
    private int step[][][];
    private int[][] g;

    public int catMouseGame(int[][] graph) {
        int N = graph.length;
        step = new int[N][N][15];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(step[i][j], -1);
            }
        }
        g = graph;
        return dp(1, 2, 0);
    }

    private int dp(int mouse, int cat, int level) {
        if (level >= 15) {
            return 0;
        }

        if (step[mouse][cat][level] != -1) {
            return step[mouse][cat][level];
        }

        // 老鼠
        if (level % 2 == 0) {
            int cwin = 1;
            int[] nexts = g[mouse];
            for (int next : nexts) {
                if (next == cat) {
                    continue;
                }
                if (next == 0) {
                    return step[mouse][cat][level] = 1;
                }
                int f = dp(next, cat, level + 1);
                if (f == 1) {
                    return step[mouse][cat][level] = 1;
                }
                if (f != 2) {
                    cwin = 0;
                }
            }
            if (cwin == 1) {
                return step[mouse][cat][level] = 2;
            } else {
                return step[mouse][cat][level] = 0;
            }
        } else {
            // 猫
            int mwin = 1;
            int[] nexts = g[cat];
            for (int next : nexts) {
                if (next == 0) {
                    continue;
                }
                if (next == mouse) {
                    return step[mouse][cat][level] = 2;
                }
                int f = dp(mouse, next, level + 1);
                if (f == 2) {
                    return step[mouse][cat][level] = 2;
                }
                if (f != 1) {
                    mwin = 0;
                }
            }
            if (mwin == 1) {
                return step[mouse][cat][level] = 1;
            } else {
                return step[mouse][cat][level] = 0;
            }
        }
    }
}


class Main{
    // static Logger logger = Logger.getLogger("");
    public static void main(String[] args){        
        Solution solution = new Solution();
        // System.out.println(solution.counter);
        int [][] sb = {{3,4,6,7,9,15,16,18},{4,5,8,19},{3,4,6,9,17,18},{0,2,11,15},{0,1,10,6,2,12,14,16},{1,10,7,9,15,17,18},{0,10,4,7,9,2,11,12,13,14,15,17,19},{0,10,5,6,9,16,17},{1,9,14,15,16,19},{0,10,5,6,7,8,2,11,13,15,16,17,18},{4,5,6,7,9,18},{3,6,9,12,19},{4,6,11,15,17,19},{6,9,15,17,18,19},{4,6,8,15,19},{0,3,5,6,8,9,12,13,14,16,19},{0,4,7,8,9,15,17,18,19},{5,6,7,9,2,12,13,16},{0,10,5,9,2,13,16},{1,6,8,11,12,13,14,15,16}};
        int res = solution.catMouseGame(sb);
        System.out.println(res);
        // System.out.println(solution.counter);
        int [][] sb2 = {{1,3},{0},{3},{0,2}};
        res = solution.catMouseGame(sb2);
        System.out.println(res);
    }
}