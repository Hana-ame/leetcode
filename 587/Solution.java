import java.util.*;

// class Solution{
//     public static int[][] outerTrees(int[][] trees) {
//         // Deque<int[]> res = new ArrayDeque<>();
//         List<int[]> res = new ArrayList<>();
//         int [] leftup = trees[0]; // find one most up-left point and 
//         int [] leftdown = trees[0]; // find one most up-left point and 
//         for (int i=0; i<trees.length; i++){
//             if (trees[i][0] < leftup[0]){
//                 leftdown = trees[i];
//                 leftup = trees[i];
//                 res.clear();
//                 res.add(trees[i]);
//             }else if (trees[i][0] == leftup[0]){
//                 res.add(trees[i]);
//                 if (trees[i][1] < leftdown[1])
//                     leftdown = trees[i];
//                 if (trees[i][1] > leftup[1])
//                     leftup = trees[i];
//             }                                
//         }
//         int [] base = leftup;
//         PriorityQueue<int []> pq = new PriorityQueue<>((x, y) -> { // int[2], (dx, dy)            
//             if (x[0]==base[0] && x[1]==base[1]) return -1;
//             if (y[0]==base[0] && y[1]==base[1]) return 1;
//             if (x[0]==y[0] && x[1]==y[1]) return 0; // never
//             // if (x[0] == 0 && y[0] == 0){   // 全是0
//             //     if (x[1]>0 && y[1]>0) return x[1]-y[1];
//             //     if (x[1]<0 && y[1]<0) return x[1]-y[1];
//             //     // else                               
//             //     if (x[1]>0) return -1;
//             //     else return 1;
//             // }
//             int r =  Double.compare(
//                 Math.atan2(x[1]-base[1],x[0]-base[0]),
//                 Math.atan2(y[1]-base[1],y[0]-base[0])
//             );
//             if (r == 0) // share one same k
//                 if (Math.atan2(x[1]-base[1],x[0]-base[0])<=0)
//                     r = Integer.compare(x[0]-base[0], y[0]-base[0]);
//                 else
//                     r = -Integer.compare(x[0]-base[0], y[0]-base[0]);
//             return r;
//             // }else if (x[0] == 0){
//             //     if (x[1] > 0) return -1;
//             //     else return 1;
//             // }else if (y[0] == 0){
//             //     if (y[1] > 0) return -1;
//             //     else return 1;
//             // }else{

//             // }
//             // return 0;
//         });
//         // join 
//         for (int i=0; i<trees.length; i++){
//             if (trees[i][0] >base[0])
//                 pq.add(trees[i]);
//         }
//         pq.add(leftup);
//         if (leftdown != leftup)
//             pq.add(leftdown);
//         // while(!pq.isEmpty()){
//         //     int [] t = pq.remove();
//         //     System.out.println("["+t[0]+","+t[1]+"]");
//         // }
//         Deque<int []> st = new ArrayDeque<>();
//         st.addFirst(pq.poll());
//         st.addFirst(pq.poll());
//         for (;!pq.isEmpty();){
//             int [] t = pq.poll();
//             int [] m = st.removeFirst();
//             int [] p = st.peekFirst();
//             while (!check(t,m,p) && !st.isEmpty()){
//                 m = st.removeFirst();
//                 p = st.peekFirst();
//             }
//             st.addFirst(m);
//             st.addFirst(t);            
//         }
        
//         for (;!st.isEmpty();){
//             int [] t = st.removeFirst();
//             if (t[0] > base[0])
//                 res.add(t);
//         }
//         int [][] ret = new int[res.size()][];
//         res.toArray(ret);
//         return ret;
//     }
//     private static boolean check(int[] t, int[] m, int[] p){
//         double atanthis = Math.atan2(t[1]-m[1], t[0]-m[0]);
//         double atanthat = Math.atan2(m[1]-p[1], m[0]-p[0]);
//         double sub = atanthis-atanthat;
//         while (sub<0) sub+=2*Math.PI;
//         if (sub >= 0 && sub<Math.PI)
//         // if ( atanthis - atanthat >= 0 )
//             return true;
//         else
//             return false;
//     }
//     public static void main(String[] args) {
//         int [][] a;
//         a = new int[][]{{1,2},{2,2},{4,2}};
//         outerTrees(a);
//         a = new int[][]{{3,0},{4,0},{5,0},{6,1},{7,2},{7,3},{7,4},{6,5},{5,5},{4,5},{3,5},{2,5},{1,4},{1,3},{1,2},{2,1},{4,2},{0,3}};
//         outerTrees(a);
//     }
// }

class Solution {
    public int[][] outerTrees(int[][] trees) {
        int n = trees.length;
        if (n < 4) {
            return trees;
        }
        int bottom = 0;
        /* 找到 y 最小的点 bottom*/
        for (int i = 0; i < n; i++) {
            if (trees[i][1] < trees[bottom][1]) {
                bottom = i;
            }
        }
        swap(trees, bottom, 0);
        /* 以 bottom 原点，按照极坐标的角度大小进行排序 */
        Arrays.sort(trees, 1, n, (a, b) -> {
            int diff = cross(trees[0], a, b);
            if (diff == 0) {
                return distance(trees[0], a) - distance(trees[0], b);
            } else {
                return -diff;
            }
        });
        /* 对于凸包最后且在同一条直线的元素按照距离从大到小进行排序 */
        int r = n - 1;
        while (r >= 0 && cross(trees[0], trees[n - 1], trees[r]) == 0) {
            r--;
        }
        for (int l = r + 1, h = n - 1; l < h; l++, h--) {
            swap(trees, l, h);
        }
        Deque<Integer> stack = new ArrayDeque<Integer>();
        stack.push(0);
        stack.push(1);
        for (int i = 2; i < n; i++) {
            int top = stack.pop();
            /* 如果当前元素与栈顶的两个元素构成的向量顺时针旋转，则弹出栈顶元素 */
            while (!stack.isEmpty() && cross(trees[stack.peek()], trees[top], trees[i]) < 0) {
                top = stack.pop();
            }
            stack.push(top);
            stack.push(i);
        }

        int size = stack.size();
        int[][] res = new int[size][2];
        for (int i = 0; i < size; i++) {
            res[i] = trees[stack.pop()];
        }
        return res;
    }

    public int cross(int[] p, int[] q, int[] r) {
        return (q[0] - p[0]) * (r[1] - q[1]) - (q[1] - p[1]) * (r[0] - q[0]);
    }

    public int distance(int[] p, int[] q) {
        return (p[0] - q[0]) * (p[0] - q[0]) + (p[1] - q[1]) * (p[1] - q[1]);
    }

    public void swap(int[][] trees, int i, int j) {
        int temp0 = trees[i][0], temp1 = trees[i][1];
        trees[i][0] = trees[j][0];
        trees[i][1] = trees[j][1];
        trees[j][0] = temp0;
        trees[j][1] = temp1;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        var a = new int[][]{{5,0},{6,1},{7,2},{7,3},{7,4},{6,5},{5,5},{4,5},{3,5},{2,5},{1,4},{1,3},{1,2},{2,1},{4,2},{0,3}};
        sol.outerTrees(a);
    }
}

// 作者：LeetCode-Solution
// 链接：https://leetcode-cn.com/problems/erect-the-fence/solution/an-zhuang-zha-lan-by-leetcode-solution-75s3/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。