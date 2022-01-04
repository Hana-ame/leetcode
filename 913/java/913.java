// import java.lang.System.Logger;
import java.util.logging.Level;
import java.util.logging.Logger;


class Solution {
    static int N = 55;
    static int[][][] f = new int[2 * N * N][N][N];
    int[][] g;
    int n;
    public int counter;
    public int catMouseGame(int[][] graph) {
        counter = 0;
        g = graph;
        n = g.length;
        for (int k = 0; k < 2 * n * n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    f[k][i][j] = -1;
                }
            }
        }
        return dfs(0, 1, 2);
    }
    // 0:draw / 1:mouse / 2:cat
    int dfs(int k, int a, int b) {
        System.out.println(counter);
        counter++;
        int ans = f[k][a][b];
        if (a == 0) ans = 1;
        else if (a == b) ans = 2;
        // else if (k >= 2 * n * n) ans = 0;
        else if (k >= 2 * n) ans = 0;
        else if (ans == -1) {
            if (k % 2 == 0) { // mouse
                boolean win = false, draw = false;
                for (int ne : g[a]) {
                    int t = dfs(k + 1, ne, b);
                    if (t == 1) win = true;
                    else if (t == 0) draw = true;
                    if (win) break;
                }
                if (win) ans = 1;
                else if (draw) ans = 0;
                else ans = 2;
            } else { // cat
                boolean win = false, draw = false;
                for (int ne : g[b]) {
                    if (ne == 0) continue;
                    int t = dfs(k + 1, a, ne);
                    if (t == 2) win = true;
                    else if (t == 0) draw = true;
                    if (win) break;
                }
                if (win) ans = 2;
                else if (draw) ans = 0;
                else ans = 1;
            }
        }
        f[k][a][b] = ans;
        return ans;
    }
};

class Main{
    // static Logger logger = Logger.getLogger("");
    public static void main(String[] args){        
        Solution solution = new Solution();
        System.out.println(solution.counter);
        int [][] sb = {{3,4,6,7,9,15,16,18},{4,5,8,19},{3,4,6,9,17,18},{0,2,11,15},{0,1,10,6,2,12,14,16},{1,10,7,9,15,17,18},{0,10,4,7,9,2,11,12,13,14,15,17,19},{0,10,5,6,9,16,17},{1,9,14,15,16,19},{0,10,5,6,7,8,2,11,13,15,16,17,18},{4,5,6,7,9,18},{3,6,9,12,19},{4,6,11,15,17,19},{6,9,15,17,18,19},{4,6,8,15,19},{0,3,5,6,8,9,12,13,14,16,19},{0,4,7,8,9,15,17,18,19},{5,6,7,9,2,12,13,16},{0,10,5,9,2,13,16},{1,6,8,11,12,13,14,15,16}};
        int res = solution.catMouseGame(sb);
        System.out.println(res);
        System.out.println(solution.counter);
        int [][] sb2 = {{1,3},{0},{3},{0,2}};
        res = solution.catMouseGame(sb2);
        System.out.println(res);
    }
}