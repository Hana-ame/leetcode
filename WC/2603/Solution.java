import java.util.*;

class Solution {
    class Node {
        int coin = 0;
        int degree = 0;
        ArrayList<Integer> neighbour = new ArrayList<>();
    }
    public int collectTheCoins(int[] coins, int[][] edges) {
        int el = edges.length;

        int n = coins.length;
        Node [] m = new Node[n];
        for (int i = 0; i < n; i++) {
            m[i] = new Node();
        }
        for(int [] e:edges){
            m[e[0]].neighbour.add(e[1]);
            m[e[1]].neighbour.add(e[0]);
            m[e[0]].degree++;
            m[e[1]].degree++;
        }
        
        HashSet<Integer> [] sets = new HashSet[4];
        sets[0] = new HashSet<Integer>();
        sets[1] = new HashSet<Integer>();
        sets[2] = new HashSet<Integer>();
        sets[3] = new HashSet<Integer>();
        for (int i=0; i<n; i++) {
            m[i].coin = coins[i];
            sets[m[i].degree].add(i);
        }
        while (!sets[1].isEmpty()) {
            sets[0] = sets[1];
            sets[1] = new HashSet<>();

            for(Integer i : sets[0]) {
                Node node = m[i];
                if (node.coin >= 0b100){
                    continue;
                }
                int j = node.neighbour.get(0);
                sets[m[j].degree].remove(j);
                m[j].degree --;
                m[j].coin |= node.coin<<1;
                m[j].neighbour.remove(i);
                sets[m[j].degree].add(j);
                
                el--;
            }
        }

        return el*2;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        var coins = new int[]{1,0,0,0,0,1};
        var edges = new int[][]{{0,1},{1,2},{2,3},{3,4},{4,5}};
        solution.collectTheCoins(coins, edges);
    }
}

