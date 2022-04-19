import java.time.Month;
import java.util.*;

class Solution {
    int [] node ;
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        node = new int[patience.length];
        // bfs搜索到0的距离
        ArrayList<Integer> [] m = new ArrayList[patience.length];
        for (int i=0; i<patience.length; i++)
            m[i] = new ArrayList<>();

        // HashSet<int []> map = new HashSet<>();
        for(int i=0; i<edges.length; i++){
            m[edges[i][0]].add(edges[i][1]);
            m[edges[i][1]].add(edges[i][0]);
        }
        // bfs        
        ArrayList<Integer> l = new ArrayList<>();
        ArrayList<Integer> another = new ArrayList<>();
        boolean flag = true;
        int distance = 1;
        l.add(0);
        node[0] = -1;
        for (;flag;){
            flag = false;
            for (int i=0; i<l.size(); i++){
                ArrayList<Integer> edgs = m[l.get(i)];
                for (int j=0; j<edgs.size(); j++){
                    int nxt = edgs.get(j);                    
                    if (node[nxt] == 0){ // 更新
                        node[nxt] = distance;
                        flag = true;
                        another.add(nxt); // 加入下一次遍历
                    }                                        
                }                
            }
            l = another;
            another = new ArrayList<>();
            distance++;
        }
        node[0] ^= node[0] ;

        int res = 0;// 存储答案
        for (int i=1; i<patience.length; i++){ // 遍历最大值
            // 计算最后发包时间
            int ans = 0;
            // for (;ans < node[i]*2; ans+=patience[i]);
            // ans -= patience[i];
            // ans += node[i]*2;
            int dist = node[i];
            int v = i;
            ans = patience[v] * ((2 * dist - 1) / patience[v]) + 2 * dist + 1;

            res = Math.max(res, ans);
        }       
            
        return ++res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.networkBecomesIdle(new int[][]{{1,0},{1,2},{0,2}}, new int[]{0,20,10});
    }
}