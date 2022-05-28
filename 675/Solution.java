import java.util.*;
class Solution {
    int N = 50;
    int[][] g = new int[N][N];
    int n, m;
    public int cutOffTree(List<List<Integer>> forest) {
        n = forest.size(); m = forest.get(0).size();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                g[i][j] = forest.get(i).get(j);
                if (g[i][j] > 1) list.add(new int[]{g[i][j], i, j});
            }
        }
        Collections.sort(list, (a,b)->a[0]-b[0]);
        int x = 0, y = 0, ans = 0;
        for (int[] ne : list) {
            int nx = ne[1], ny = ne[2];
            int d = astar(x, y, nx, ny);
            if (d == -1) return -1;
            ans += d;
            x = nx; y = ny;
        }
        return ans;
    }
    int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    int getIdx(int x, int y) {
        return x * m + y;
    }
    int f(int X, int Y, int P, int Q) {
        return Math.abs(X - P) + Math.abs(Y - Q);
    }
    int astar(int X, int Y, int P, int Q) {
        if (X == P && Y == Q) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[0]-b[0]);
        q.add(new int[]{f(X, Y, P, Q), X, Y});
        map.put(getIdx(X, Y), 0);
        while (!q.isEmpty()) {
            int[] info = q.poll();
            int x = info[1], y = info[2], step = map.get(getIdx(x, y));
            for (int[] di : dirs) {
                int nx = x + di[0], ny = y + di[1], nidx = getIdx(nx, ny);
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (g[nx][ny] == 0) continue;
                if (nx == P && ny == Q) return step + 1;
                if (!map.containsKey(nidx) || map.get(nidx) > step + 1) {
                    q.add(new int[]{step + 1 + f(nx, ny, P, Q), nx, ny});
                    map.put(nidx, step + 1);
                }
            }
        }
        return -1;
    }
}

// 作者：AC_OIer
// 链接：https://leetcode.cn/problems/cut-off-trees-for-golf-event/solution/by-ac_oier-ksth/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。