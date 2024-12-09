import java.util.*;

class Solution {
    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {        
        long [] S1;
        long [] S2;
        long [] D;
        ArrayList<int[]> [] map = new ArrayList[n];
        for (int i=0; i<n; i++)
            map[i] = new ArrayList<int[]>();
        for (int i=0; i<edges.length; i++){
            int [] e = edges[i]; // [from, to, cost]
            map[e[0]].add(e);
            map[e[1]].add(e);
        }
        S1 = bfs(n, map, src1);
        S2 = bfs(n, map, src2);
        D = bfs1(n, map, dest);
        // long s1d = bfs1(n, map, src1, dest);
        // if (s1d==-1) return -1;
        // long s2d = bfs2(n, map, src2, dest);
        // if (s2d==-1) return -1;
        // long s1s2 = bfs(n, map, src1, src2);
        // // if (s1s2==-1) return -1;
        // long s2s1 = bfs(n, map, src2, src1);
        // // if (s2s1==-1) return -1;
        // long res = s1d+s2d;
        // if (s1s2!=-1)
        //     res = Math.min(res, s1s2+s2d);
        // if (s2s1!=-1)
        //     res = Math.min(res, s2s1+s1d);
        // return res;
        long res = Long.MAX_VALUE;
        for (int i=0;i<n;i++)
            if (S1[i]>=0&&S2[i]>=0&&D[i]>=0)
                res = Math.min(S1[i]+S2[i]+D[i],res);
        if (res == Long.MAX_VALUE)
            return -1;
        return res;
    }
    private long [] bfs(int n, ArrayList<int[]> [] map, int src){
        long [] memo = new long[n]; // 记录能到达时的最小状态 
        Arrays.fill(memo, -1);

        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)->{// 搜索次序的队列，从小到大(?)
            return Long.compare(a[0], b[0]);
        }); 

        memo[src] = 0;
        for (int i=0; i<map[src].size(); i++){
            int [] e = map[src].get(i);
            if (e[0] == src)
                pq.add(new long[]{e[2], e[1]}); // 总长度，下一跳
        }
        while (!pq.isEmpty()){
            long [] o = pq.poll(); // 总是取出最小的长度所以除了第一次之外之后都比这更长
            int s = (int)o[1];
            if (memo[s] == -1){
                long t = o[0];
                memo[s] = t;
                for (int i=0; i<map[s].size(); i++){
                    int [] e = map[s].get(i);
                    if (e[0] == s)
                        pq.add(new long[]{e[2]+t, e[1]}); // 总长度，下一跳
                }
            }
            // continue;
            // if (s==dest) return memo[s];
        }        
        return memo;        
    }
    private long [] bfs1(int n, ArrayList<int[]> [] map, int src){
        long [] memo = new long[n]; // 记录能到达时的最小状态 
        Arrays.fill(memo, -1);

        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)->{// 搜索次序的队列，从小到大(?)
            return Long.compare(a[0], b[0]);
        }); 

        memo[src] = 0;
        for (int i=0; i<map[src].size(); i++){
            int [] e = map[src].get(i);
            if (e[1] == src)
                pq.add(new long[]{e[2], e[0]}); // 总长度，下一跳
        }
        while (!pq.isEmpty()){
            long [] o = pq.poll(); // 总是取出最小的长度所以除了第一次之外之后都比这更长
            int s = (int)o[1];
            if (memo[s] == -1){
                long t = o[0];
                memo[s] = t;
                for (int i=0; i<map[s].size(); i++){
                    int [] e = map[s].get(i);
                    if (e[1] == s)
                        pq.add(new long[]{e[2]+t, e[0]}); // 总长度，下一跳
                }
            }
            // if (s==dest) return memo[s];
        }        
        return memo;        
    }
    // private long bfs1(int n, ArrayList<int[]> [] map, int src, int dest){
    //     alt = new long[n]; // 记录能到达时的最小状态 
    //     long [] memo = alt;
    //     Arrays.fill(memo, -1);

    //     PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)->{// 搜索次序的队列，从小到大(?)
    //         return Long.compare(a[0], b[0]);
    //     }); 
    //     // for ()
    //     // 加入第一个节点的所有
    //     memo[src] = 0;
    //     for (int i=0; i<map[src].size(); i++){
    //         int [] e = map[src].get(i);
    //         pq.add(new long[]{e[2], e[1]}); // 总长度，下一跳
    //     }
    //     while (!pq.isEmpty()){
    //         long [] o = pq.poll(); // 总是取出最小的长度所以除了第一次之外之后都比这更长
    //         int s = (int)o[1];
    //         if (memo[s] == -1){
    //             long t = o[0];
    //             memo[s] = t;
    //             for (int i=0; i<map[s].size(); i++){
    //                 int [] e = map[s].get(i);
    //                 pq.add(new long[]{e[2]+t, e[1]}); // 总长度，下一跳
    //             }
    //         }
    //         // if (s==dest) return memo[s];
    //     }        
    //     return memo[dest];        
    // }
    // private long bfs2(int n, ArrayList<int[]> [] map, int src, int dest){
    //     long [] memo = new long[n]; // 记录能到达时的最小状态 
    //     Arrays.fill(memo, -1);

    //     PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)->{// 搜索次序的队列，从小到大(?)
    //         return Long.compare(a[0], b[0]);
    //     }); 
    //     // for ()
    //     // 加入第一个节点的所有
    //     if (memo[src] != -1) return 0;
    //     for (int i=0; i<map[src].size(); i++){
    //         int [] e = map[src].get(i);
    //         pq.add(new long[]{e[2], e[1]}); // 总长度，下一跳
    //     }

    //     long res = Long.MAX_VALUE;
    //     while (!pq.isEmpty()){
    //         long [] o = pq.poll(); // 总是取出最小的长度所以除了第一次之外之后都比这更长
    //         int s = (int)o[1];
    //         if (memo[s] == -1){
    //             long t = o[0];
    //             memo[s] = t;
    //             for (int i=0; i<map[s].size(); i++){
    //                 int [] e = map[s].get(i);
    //                 pq.add(new long[]{e[2]+t, e[1]}); // 总长度，下一跳
    //             }
    //         }
    //         // if ()
    //         // if (s==dest) return memo[s];
    //     }
    //     return res;        
    // }
    public static void main(String[] args) {
        Solution s = new Solution();
        int n= 5;
        int [][] edges = {{4,2,20},{4,3,46},{0,1,15},{0,1,43},{0,1,32},{3,1,13}};
        int src1=0;
        int src2=4;
        int dest=1;

        s.minimumWeight(n, edges, src1, src2, dest);
    }
}