import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

class Solution {

    int vis[];
    int lst[];
    ArrayList<List<Integer>> res;
    ArrayList<Integer> nodes[];
    int no;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        no = 0;
        res = new ArrayList<>();
        nodes = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new ArrayList<>();
        }
        for (int i = 0; i < connections.size(); i++) {
            List<Integer> c = connections.get(i);
            int a = c.get(0);
            int b = c.get(1);
            nodes[a].add(b);
            nodes[b].add(a);
        }

        vis = new int[n];
        lst = new int[n];
        Arrays.fill(vis, -1);
        Arrays.fill(lst, -1);

        dfs(0);

        return res;
    }

    public int dfs(int n, int p) {// n是节点编号
        if (lst[n] == -1) { // 未访问过
            lst[n] = no; // 访问顺序
            no++;

            ArrayList<Integer> node = nodes[n];
            

            int min = 999999;
            for (int i = 0; i < node.size(); i++) {
                int nxt = node.get(i);
                
                if (nxt == p) continue;
                
                if (lst[nxt] == -1 ){ // 未访问过
                    int minlst = dfs(nxt, n);
                    if (minlst > lst[n]) newpair(nxt, n);
                    min = Math.min(dfs(nxt, n), min);
                }else{ // 访问过
                    min = Math.min(lst[nxt], min);
                }
            }
            lst[n] = min;

        }

        return lst[n];
    }

    public void newpair(int a, int b) {
        ArrayList<Integer> l = new ArrayList<>();
        l.add(a);
        l.add(b);
        // return l;
        res.add(l);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 4;
        ArrayList<List<Integer>> c = new ArrayList<>();
        // for (int i=0; i<n; i++){
        c.add(np(0, 1));
        // c.add(np(1, 2));
        // c.add(np(2, 3));
        // c.add(np(3, 0));
        // c.add(np(1, 3));
        // c.add(np(2, 0));
        // }
        s.criticalConnections(n, c);
    }

    public static ArrayList<Integer> np(int a, int b) {
        ArrayList<Integer> l = new ArrayList<>();
        l.add(a);
        l.add(b);
        return l;
    }
}

/*
 * class Solution {
 * public String convert(String s, int numRows) {
 * 
 * if (numRows == 1) return s;
 * int n = (numRows<<1) -2;
 * StringBuilder sb = new StringBuilder();
 * for (int i = 0; i<s.length(); i++){
 * if ((n*i)<s.length()) sb.append(s.charAt(n*i));
 * }
 * int j = 1;
 * for ( ; (j)<(numRows-1); j++)
 * for (int i = 0; i<s.length(); i++){
 * if ((n*i-j)>=0 && (n*i-j)<s.length()) sb.append(s.charAt(n*i-j));
 * if ((n*i+j)<s.length()) sb.append(s.charAt(n*i+j));
 * }
 * for (int i = 0; i<s.length(); i++){
 * // if ((n*i-j)>=0) sb.append(s.charAt(n*i-j));
 * if ((n*i+j)<s.length()) sb.append(s.charAt(n*i+j));
 * }
 * return s.toString();
 * 
 * 
 * }
 * 
 * public static void main(String[] args) {
 * Solution s = new Solution();
 * s.convert("PAYPALISHIRING",
 * 3);
 * }
 * }
 * 
 */

/*
 * class Solution {
 * 
 * 
 * public double knightProbability(int n, int k, int row, int column) {
 * 
 * double [][] board = new double[n][n];
 * board[row][column] = 1.0;
 * 
 * for (int i=0; i<k; i++){ // k次
 * double [][] nb = new double[n][n];
 * for(int x=0; x<n; x++){
 * for(int y=0; y<n; y++){
 * next(nb,n,x,y,board[x][y]);
 * }
 * }
 * board = nb;
 * }
 * 
 * // 计算概率
 * double res = 0;
 * for(int x=0; x<n; x++){
 * for(int y=0; y<n; y++){
 * res+=board[x][y];
 * }
 * }
 * return res;
 * }
 * 
 * int [][] dirs = {{1,2},{2,1},{-1,2},{2,-1},{-2,1},{1,-2},{-1,-2},{-2,-1}};
 * public void next(double[][] b, int n, int x, int y, double v){
 * for (int [] d : dirs){
 * int xx = d[0]+x; int yy = d[1]+y;
 * if(xx>=n||yy>=n||xx<0||yy<0) continue;
 * b[xx][yy] = v/8;
 * }
 * }
 * 
 * }
 * /*
 * class Solution {
 * int N = 510;
 * int[] cnts = new int[N], fa = new int[N];
 * boolean[][] g = new boolean[N][N];
 * public int checkWays(int[][] pairs) {
 * int m = pairs.length;
 * Set<Integer> set = new HashSet<>();
 * for (int[] p : pairs) {
 * int a = p[0], b = p[1];
 * g[a][b] = g[b][a] = true;
 * cnts[a]++; cnts[b]++;
 * set.add(a); set.add(b);
 * }
 * List<Integer> list = new ArrayList<>(set);
 * Collections.sort(list, (a,b)->cnts[b]-cnts[a]);
 * int n = list.size(), root = list.get(0);
 * if (m < n - 1) return 0; // 森林
 * fa[root] = -1;
 * for (int i = 1; i < n; i++) {
 * int a = list.get(i);
 * boolean ok = false;
 * for (int j = i - 1; j >= 0 && !ok; j--) {
 * int b = list.get(j);
 * if (g[a][b]) {
 * fa[a] = b;
 * ok = true;
 * }
 * }
 * if (!ok) return 0;
 * }
 * int c = 0, ans = 1;
 * for (int i : set) {
 * int j = i;
 * while (fa[j] != -1) {
 * if (!g[i][fa[j]]) return 0;
 * if (cnts[i] == cnts[fa[j]]) ans = 2;
 * c++;
 * j = fa[j];
 * }
 * }
 * return c < m ? 0 : ans;
 * }
 * }
 */
// 作者：AC_OIer
// 链接：https://leetcode-cn.com/problems/number-of-ways-to-reconstruct-a-tree/solution/gong-shui-san-xie-gou-zao-yan-zheng-he-f-q6fc/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
/*
 * class Solution {
 * 
 * int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
 * int h;
 * int w;
 * 
 * public int numEnclaves(int[][] grid) {
 * 
 * h = grid.length;
 * w = grid[0].length;
 * System.out.println(h);
 * System.out.println(w);
 * for (int i = 0; i < w; i++) {
 * dfs(grid, i, 0);
 * dfs(grid, i, h - 1);
 * }
 * for (int i = 0; i < h; i++) {
 * dfs(grid, 0, i);
 * dfs(grid, w - 1, i);
 * }
 * // 清点
 * int res = 0;
 * for (int i = 0; i < h; i++) {
 * for (int j = 0; j < w; j++) {
 * res += grid[i][j];
 * }
 * }
 * return res;
 * 
 * }
 * 
 * public void dfs(int[][] grid, int x, int y) {
 * if (x < 0 || y < 0 || x >= h || y >= w)
 * return;
 * System.out.println(x);
 * System.out.println(y);
 * if (grid[x][y] == 1) {
 * grid[x][y] = 0;
 * for (int[] d : dir) {
 * dfs(grid, x + d[0], y + d[1]);
 * }
 * }
 * }
 * public static void main(String[] args) {
 * int [][] a = {{0},{1},{1},{0},{0}};
 * int [][] aa = {{0,1,1,0,0}};
 * Solution s = new Solution();
 * int b = s.numEnclaves(aa);
 * System.out.println(b);
 * }
 * 
 * }
 */
/*
 * class Solution {
 * // char [] ccs = {'1','2','3','4','5','6','7','8','9'};
 * public String getPermutation(int n, int k) {
 * char [] cs = new char [n];
 * for (char i = 0; i<n ; i++){
 * cs[i] = (char)(i+'1');
 * }
 * k--;
 * for (int i = 0; i<n; i++){
 * int t = k / fact(n-i-1);
 * k = k % fact(n-i-1);
 * 
 * // 第 t 位提前，轮换
 * char ct = cs[t+i];
 * for (int tt = t+i; tt > i; tt--){
 * cs[tt] = cs[tt-1];
 * }
 * cs[i] = ct;
 * 
 * }
 * return new String(cs);
 * 
 * }
 * public int fact(int n){
 * int r = 1;
 * for (;n>=1;n--){
 * r *= n;
 * }
 * return r;
 * }
 * public static void main(String[] args) {
 * Solution s = new Solution();
 * s.getPermutation(3,3);
 * }
 * }
 * 
 * /*
 * class Solution {
 * 
 * public int findMinArrowShots(int[][] points) {
 * Arrays.sort(points, (a,b)->compare(a,b)); // 以结束为序列排序
 * int ans = 0, arrow = 0;
 * for (int i = 0; i < points.length; i ++) {
 * System.out.println(points[i][0]+","+points[i][1]);
 * if (ans == 0 || points[i][0] > arrow) { // 没arrow(初始)或者 开始位置>arrow
 * ans ++;
 * arrow = points[i][1]; // 把arrow送到结尾
 * }
 * }
 * return ans;
 * }
 * 
 * private static int compare(int[]a,int[]b){
 * return a[1] - b[1];
 * }
 * public static void main(String[] args) {
 * Solution s = new Solution();
 * int [][] a = {{10,16},{2,8},{1,6},{7,12}};
 * 
 * 
 * System.out.println(s.findMinArrowShots(a));
 * 
 * Queue<Integer> q = new PriorityQueue<Integer>();
 * System.out.println(q.poll());
 * }
 * }
 */